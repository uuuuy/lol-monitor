package com.uuuuy.lol.connect.header;

import java.util.Map;

public class GameHeader extends CommonHeader implements Header{
	

	@Override
	public Map<String, String> getHeader() {
		header.put("Host", "lol.sw.game.qq.com");
		return header;
	}

}
