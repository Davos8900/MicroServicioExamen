package com.socialnet.login.model;

public class LoginInfoDto {
	private String usermail;
	private String password;
	
	public LoginInfoDto(String usermail, String password) {
		super();
		this.usermail = usermail;
		this.password = password;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
