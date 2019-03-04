package com.uuuuy.lol.connect.header;

import java.util.HashMap;
import java.util.Map;

public class CommonHeader {
	
	protected Map<String, String> header = new HashMap<String, String>();
	
	public CommonHeader() {
		header.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		header.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		header.put("Accept-Encoding", "gzip, deflate");
		header.put("Accept-Language", "zh-CN,zh;q=0.9");
		header.put("Cache-Control", "max-age=0");
		header.put("Connection", "keep-alive");
	}

}
