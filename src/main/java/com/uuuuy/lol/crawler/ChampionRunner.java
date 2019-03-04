package com.uuuuy.lol.crawler;

import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.uuuuy.lol.connect.header.ChampionHeader;
import com.uuuuy.lol.crawler.impl.CrawlerChampion;
import com.uuuuy.lol.domain.Champion;

@Component
@Order(value = 1)
public class ChampionRunner implements ApplicationRunner{
	
	private static final String CHAMPION = "http://lol.qq.com/biz/hero/champion.js";
	
	public static Map<String, Champion> championMap;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		CrawlerChampion crawlerChampion = new CrawlerChampion(CHAMPION, new ChampionHeader());
		championMap = crawlerChampion.task();
	}


}
