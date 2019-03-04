package com.uuuuy.lol.response;

import com.alibaba.fastjson.JSONObject;

public class Response {
	
	private int code;
	private JSONObject msg;
	private String errMsg;
	
	
	public Response(JSONObject res) {
		this.code = res.getInteger("status");
		if (code != 0) {
			this.errMsg = res.getString("msg");
			System.out.println("获取比赛列表失败,msg=====" + res);
		} else {
			this.msg = res.getJSONObject("msg");
		}
	}
	
	
	public int getCode() {
		return code;
	}
	public JSONObject getMsg() {
		return msg;
	}
	public String getErrMsg() {
		return errMsg;
	}

}
