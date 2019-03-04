package com.uuuuy.lol.crawler.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONObject;
import com.uuuuy.lol.connect.Connect;
import com.uuuuy.lol.connect.header.ChampionHeader;
import com.uuuuy.lol.connect.header.Header;
import com.uuuuy.lol.crawler.CrawlerCommon;
import com.uuuuy.lol.domain.Champion;

public class CrawlerChampion extends CrawlerCommon {
	
	public CrawlerChampion(String url, Header header) {
		super(url, header);
	}

	private static final String CHAMPION_INFO = "http://lol.qq.com/biz/hero/champion.js";

	public Map<String, Champion> task() {
		Connect gameConnect = new Connect(CHAMPION_INFO, new ChampionHeader());
		String res = gameConnect.content();
		res = res.split("LOLherojs.champion=")[1];
		res = res.substring(0, res.length() - 1);
		JSONObject championList = JSONObject.parseObject(res);
		JSONObject data = championList.getJSONObject("data");
		Map<String, Champion> championMap = new HashMap<String, Champion>();
		for (Entry<String, Object> entry : data.entrySet()) {
			JSONObject cj = JSONObject.parseObject(entry.getValue().toString());
			Champion champion = new Champion(cj);
			championMap.put(champion.getKey(), champion);
		}
		return championMap;
	}

}
