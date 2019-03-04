package com.uuuuy.lol.analysis;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
		String t = msg.getJSONObject("gameStats").getString("finalFrameTimestamp");
		String r = putFile.read();
		if (r != null && r.equals(t)) {
			return "";
		}
		putFile.output(t);
		Timestamp timestamp = new Timestamp(msg.getJSONObject("gameStats").getLongValue("finalFrameTimestamp"));
		String result = "<p>summonerName，刚刚完成了一次比赛。</p>";
		JSONArray persons = msg.getJSONArray("participants");
		for (int i = 0; i < persons.size(); i++) {
			JSONObject person = persons.getJSONObject(i);
			if (account.equals(person.getString("currentAccountId"))) {
				JSONObject stats = person.getJSONObject("stats");
				if (stats.getBoolean("winner")) {
					result += "<p>恭喜，本次比赛胜利。</p>";
				} else {
					result += "<p>本次比赛失败，下次继续努力。</p>";
				}
				result += "<p>比赛结束时间为：" + sdf.format(timestamp) + "。</p>";
				result += "<p>本场KDA为：" + stats.getString("kills") + "/" + stats.getString("deaths") + "/" + stats.getString("assists") + "。</p>";
				
				Champion champion = ChampionRunner.championMap.get(person.getString("championId"));
				result += "<p>本场使用的英雄是：" + champion.getName() + "·" + champion.getTitle() + "</p>";
				result += "<p><img src='" + champion.getImage() + "'/></p>";
				if (stats.getInteger("quadraKills") > 0) {
					result += "<p>本场完成" + stats.getInteger("quadraKills") + "个四杀。</p>";
				}
				if (stats.getInteger("pentaKills") > 0) {
					result += "<p>本场完成" + stats.getInteger("pentaKills") + "个五杀。</p>";
				}
				result += "<p>本场对英雄造成伤害：" + stats.getInteger("totalDamageDealtToChampions") + "。</p>";
				
				result = result.replace("summonerName", person.getString("summonerName"));
			}
		}
		
		
		return result;
	}

}
