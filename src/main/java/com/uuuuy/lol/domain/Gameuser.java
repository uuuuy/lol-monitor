package com.uuuuy.lol.domain;

public enum Gameuser {
	
	HUODA("4006361999", "eas_sid=I1W5O5E1x3o2P6r3H1E0M934J6; pgv_pvid=4861504370; pgv_pvi=2438664192; RK=Woo8yp+sUo; ptcz=6effb42a4324ede6aad726a4bf61b05dbc20c1922b71ea83ef3e9175abc6b5e3; tvfe_boss_uuid=2eb10a3225ef768c; LW_uid=O1B5T5E1f8w6p4A4i5U7S4D1l5; LW_sid=k1f5M5T5C320h5x4G5t2l4d2f2; o_cookie=86838622; pac_uid=1_86838622; pgv_info=ssid=s3623547644; _qpsvr_localtk=0.8823965023671785; pgv_si=s8292517888; ptisp=ctc; ptui_loginuin=1109061266; uin=o1109061266; skey=@LcpwtMTH3; p_uin=o1109061266; pt4_token=opOp1GDIU9piFdEVUyK0bvH0i6eUcapE7pfgsmh1q5Y_; p_skey=xu-cauOWHdQxytV9qE*QguFHIARDrh8n63G6u4hqt50_; IED_LOG_INFO2=userUin%3D1109061266%26nickName%3D%26userLoginTime%3D1557456377; uin_cookie=o1109061266; ied_qq=o1109061266");
	
	private Gameuser(String account, String cookie) {
		this.account = account;
		this.cookie = cookie;
	}
	private String account;
	private String cookie;
	
	
	public String getAccount() {
		return account;
	}
	public String getCookie() {
		return cookie;
	}

}
