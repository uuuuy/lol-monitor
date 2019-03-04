package com.uuuuy.lol.domain;

import com.alibaba.fastjson.JSONObject;

public class Champion {
	
	private String id;
	private String key;
	private String name;
	private String title;
	private String image;
	
	private static final String PRE_IMG = "http://ossweb-img.qq.com/images/lol/img/champion/";
	
	public Champion(JSONObject cj) {
		this.id = cj.getString("id");
		this.key = cj.getString("key");
		this.name = cj.getString("name");
		this.title = cj.getString("title");
		this.image = PRE_IMG + cj.getJSONObject("image").getString("full");
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
