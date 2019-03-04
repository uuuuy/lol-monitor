package com.uuuuy.lol.crawler.impl;

import com.alibaba.fastjson.JSONObject;
import com.uuuuy.lol.analysis.AnalysisGame;
import com.uuuuy.lol.connect.Connect;
import com.uuuuy.lol.connect.header.GameHeader;
import com.uuuuy.lol.connect.header.Header;
import com.uuuuy.lol.crawler.Crawler;
import com.uuuuy.lol.crawler.CrawlerCommon;
import com.uuuuy.lol.domain.Gameuser;
import com.uuuuy.lol.mail.NotifyByMail;
import com.uuuuy.lol.response.Response;

public class CrawlerGameInfo extends CrawlerCommon implements Crawler {
	
	private String gameId;
	
	private static final String GAME_INFO = "http://lol.sw.game.qq.com/lol/commact/?proj=api&c=Battle&a=combatGains&areaId=12&gameId=GAMEID&r1=combatGains";
	
	
	public CrawlerGameInfo(String gameId, Gameuser user, Header header) {
		super(user, header);
		this.gameId = gameId;
		this.url = GAME_INFO.replace("GAMEID", gameId);
		task();
	}


	private void task() {
		Connect gameConnect = new Connect(GAME_INFO.replace("GAMEID", gameId), user.getCookie(), new GameHeader());
		JSONObject gameInfo = JSONObject.parseObject(gameConnect.content().split(" = ")[1]);
		response = new Response(gameInfo);
	}

}
