package com.uuuuy.lol.domain;

public enum Gameuser {
	
	HUODA("4006361999", "eas_sid=I1W5O5E1x3o2P6r3H1E0M934J6; pgv_info=ssid=s6040911555; pgv_pvid=4861504370; _qpsvr_localtk=0.33880715706942555; pgv_pvi=2438664192; pgv_si=s4508770304; ptisp=ctc; ptui_loginuin=1109061266; uin=o1109061266; RK=Woo8yp+sUo; ptcz=6effb42a4324ede6aad726a4bf61b05dbc20c1922b71ea83ef3e9175abc6b5e3; p_uin=o1109061266; skey=@xc8myqrAt; pt4_token=riRV77XNeTc5IGUEQi0NCYUodDrjuhzjqv6rs4RQ0Io_; p_skey=Hg8rJDB6zgTIZ9iIsnRi8609Bm5F2WRGE5XvW2iVEgY_; IED_LOG_INFO2=userUin%3D1109061266%26nickName%3D%26userLoginTime%3D1551341680");
	
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
