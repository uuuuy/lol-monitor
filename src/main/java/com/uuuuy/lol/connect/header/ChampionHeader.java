package com.uuuuy.lol.connect.header;

import java.util.Map;

public class ChampionHeader extends CommonHeader implements Header {

	@Override
	public Map<String, String> getHeader() {
		header.put("Host", "lol.qq.com");
		return header;
	}

}
