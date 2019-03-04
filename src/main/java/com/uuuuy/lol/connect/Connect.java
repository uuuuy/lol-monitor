package com.uuuuy.lol.connect;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;

import com.uuuuy.lol.connect.header.Header;

public class Connect {
	
	private String url;
	private String cookie;
	private Header header;
	


	public Connect(String url, String cookie, Header header) {
		super();
		this.url = url;
		this.cookie = cookie;
		this.header = header;
	}
	
	public Connect(String url, Header header) {
		super();
		this.url = url;
		this.cookie = null;
		this.header = null;
	}

	public String content() {
		Connection connect = Jsoup.connect(url);
		if (cookie != null) {
			connect.cookies(cookie());
		}
		if (header != null) {
			connect.headers(header.getHeader());
		}
		Response res;
		try {
			res = connect.ignoreContentType(true).execute();
		} catch (IOException e) {
			System.out.println("游戏列表链接失败");
			e.printStackTrace();
			return "";
		}
		return res.body();
	}
	

	public HashMap<String, String> cookie() {
		String c = cookie.replaceAll(" ", "");
		String[] cookieArr = c.split(";");
		HashMap<String, String> cookies = new HashMap<String,String>();
		for (int i = 0, u = cookieArr.length; i < u; i++) {
			if (!"".equals(cookieArr[i])) {
				String[] cookiekv = cookieArr[i].split("=");
				cookies.put(cookiekv[0], cookiekv[1]);
			}
		}
		return cookies;
	}

}
