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

public class CrawlerGameList extends CrawlerCommon implements Crawler{
	
	private static final String GAME_LIST = "http://lol.sw.game.qq.com/lol/commact/?proj=api&c=Battle&a=matchList&areaId=12&accountId=ACCOUNTID&queueId=70,72,73,75,76,78,96,98,100,300,310,313,317,318,325,400,420,430,450,460,600,610,940,950,960,980,990,420,440,470,83,800,810,820,830,840,850&r1=matchList";
	
	
	public CrawlerGameList(Gameuser user, Header header) {
		super(user, header);
		this.url = GAME_LIST;
		task();
	}
	
	public void task() {
		//获取游戏列表
		Connect gamelistConnect = new Connect(GAME_LIST.replace("ACCOUNTID", user.getAccount()), user.getCookie(), new GameHeader());
		String body = gamelistConnect.content();
		
		JSONObject gamelist = JSONObject.parseObject(body.split("=")[1]);
		response = new Response(gamelist);
		
	}


	
}
