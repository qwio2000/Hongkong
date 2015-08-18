package com.jeiglobal.hk.domain.auth;

import lombok.*;

@Data
@AllArgsConstructor
public class LoginInfo {
	private String memberId;
	private String memberPassword;
	private String memberEnabled;
	private String jisaCD;
	private String depid1;
	private String depid2;
	private String empKey;
	private String empName;
	private String empKeyLvCD;
	private String depMngCD;
	private String encodeCookie;
}
