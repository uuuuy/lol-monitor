package com.uuuuy.lol.analysis;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.uuuuy.lol.crawler.ChampionRunner;
import com.uuuuy.lol.domain.Champion;
import com.uuuuy.lol.file.PutFile;

public class AnalysisGame {
	
	
	public static String analysis(String account, JSONObject msg) {
		PutFile putFile;
		try {
			 putFile = new PutFile(account);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(account + "创建存储文件失败");
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t = msg.getJSONObject("gameInfo").getString("gameId");
		String r = putFile.read();
		if (r != null && r.equals(t)) {
			return "";
		}
		putFile.output(t);
		
		Timestamp timestamp = new Timestamp(msg.getJSONObject("gameStats").getLongValue("finalFrameTimestamp"));
		String result = "<p>summonerName，刚刚完成了一次比赛。</p>";
		JSONArray persons = msg.getJSONArray("participants");
		Map<Integer, Double> damageMap = new HashMap<Integer, Double>();
		Map<Integer, Double> goldMap = new HashMap<Integer, Double>();
		JSONObject me = null;
		for (int i = 0; i < persons.size(); i++) {
			JSONObject person =  persons.getJSONObject(i);
			JSONObject otherStats =  person.getJSONObject("stats");
			double damage = 0;
			if (damageMap.containsKey(person.getInteger("teamId"))) {
				damage = damageMap.get(person.getInteger("teamId"));
			}
			damageMap.put(person.getInteger("teamId"), damage + otherStats.getInteger("totalDamageDealtToChampions"));
			
			double gold = 0;
			if (goldMap.containsKey(person.getInteger("teamId"))) {
				gold = goldMap.get(person.getInteger("teamId"));
			}
			goldMap.put(person.getInteger("teamId"), gold + otherStats.getInteger("goldEarned"));
			
			
			if (account.equals(person.getString("currentAccountId"))) {
				me = persons.getJSONObject(i);
			}
		}
		JSONObject stats = me.getJSONObject("stats");
		if (stats.getBoolean("winner")) {
			result += "<p>恭喜，本次比赛胜利。</p>";
		} else {
			result += "<p>本次比赛失败，下次继续努力。</p>";
		}
		result += "<p>比赛结束时间为：" + sdf.format(timestamp) + "。</p>";
		result += "<p>本场KDA为：" + stats.getString("kills") + "/" + stats.getString("deaths") + "/" + stats.getString("assists") + "。</p>";
		
		Champion champion = ChampionRunner.championMap.get(me.getString("championId"));
		result += "<p>本场使用的英雄是：" + champion.getName() + "·" + champion.getTitle() + "</p>";
		result += "<p><img src='" + champion.getImage() + "'/></p>";
		if (stats.getInteger("quadraKills") > 0) {
			result += "<p>本场完成" + stats.getInteger("quadraKills") + "个四杀。</p>";
		}
		if (stats.getInteger("pentaKills") > 0) {
			result += "<p>本场完成" + stats.getInteger("pentaKills") + "个五杀。</p>";
		}
		DecimalFormat df = new DecimalFormat("#.00");
		result += "<p>本场对英雄造成伤害：" + stats.getInteger("totalDamageDealtToChampions") + "。</p>";
		result += "<p>本场对英雄造成伤害占全队比例：" + df.format(stats.getDouble("totalDamageDealtToChampions") / damageMap.get(me.getInteger("teamId")) * 100) + "%。</p>";
		
		result += "<p>本场获得经济：" + stats.getInteger("goldEarned") + "。</p>";
		result += "<p>本场获得经济占全队比例：" + df.format(stats.getInteger("goldEarned") / goldMap.get(me.getInteger("teamId")) * 100) + "%。</p>";
		
		result = result.replace("summonerName", me.getString("summonerName"));
		
		
		return result;
	}

}
