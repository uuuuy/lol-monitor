package com.uuuuy.lol.tast;

import com.alibaba.fastjson.JSONObject;
import com.uuuuy.lol.analysis.AnalysisGame;
import com.uuuuy.lol.connect.header.GameHeader;
import com.uuuuy.lol.connect.header.Header;
import com.uuuuy.lol.crawler.impl.CrawlerGameInfo;
import com.uuuuy.lol.crawler.impl.CrawlerGameList;
import com.uuuuy.lol.domain.Gameuser;
import com.uuuuy.lol.domain.Mailuser;
import com.uuuuy.lol.mail.NotifyByMail;

public class Task {

	private Gameuser user;
	

	public Task(Gameuser user) {
		this.user = user;
	}
	
	public void task() {
		//定义头部
		Header gamehHeader = new GameHeader();
		//获取游戏列表内容
		CrawlerGameList gameList = new CrawlerGameList(user, gamehHeader);
		if (gameList.getResponse().getCode() != 0) {
			return;
		}
		//获取最近一次游戏ID
		JSONObject lastgame;
		try {
			lastgame = gameList.getResponse().getMsg().getJSONArray("games").getJSONObject(0);
		} catch (Exception e) {
			System.out.println("获取最近游戏ID出错===" + gameList.getResponse().getMsg());
			return;
		}
		String gameId = lastgame.getString("gameId");
		//获取游戏内容
		CrawlerGameInfo info = new CrawlerGameInfo(gameId, user, gamehHeader);
		
		if (info.getResponse().getCode() != 0) {
			return;
		}
		JSONObject msg = info.getResponse().getMsg();
		String notify = AnalysisGame.analysis(user.getAccount(), msg);
		if (!"".equals(notify)) {
			for (Mailuser user : Mailuser.values()) {
				NotifyByMail.send(user.getMail(), notify);
			}
		}
	}

}
