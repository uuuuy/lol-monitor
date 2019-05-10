package com.uuuuy.lol.domain;

public enum Mailuser {
	
	LI("李释哲", "86838622@qq.com"),
	HUO("霍达", "479941880@qq.com"),
//	ZHANG("张佳琪", "812362113@qq.com"),
	LIU("刘寿海", "1483818542@qq.com");
	
	private String user;
	private String mail;
	
	
	private Mailuser(String user, String mail) {
		this.user = user;
		this.mail = mail;
	}
	
	public String getUser() {
		return user;
	}
	public String getMail() {
		return mail;
	}

}
