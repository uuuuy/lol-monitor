package com.uuuuy.lol.crawler;

import com.uuuuy.lol.connect.header.Header;
import com.uuuuy.lol.domain.Gameuser;
import com.uuuuy.lol.response.Response;

public class CrawlerCommon {
	
	protected String url;
	protected Gameuser user;
	protected Header header;
	protected Response response;
	
	
	public CrawlerCommon(Gameuser user, Header header) {
		this.user = user;
		this.header = header;
	}


	public CrawlerCommon(String url, Header header) {
		super();
		this.url = url;
		this.header = header;
	}


	public Response getResponse() {
		return response;
	}


}
