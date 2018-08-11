package com.py.vo;

public class Member {
	private String account;//会员账号
	private String password;//会员密码
	private String reallyName;//真实姓名
	private String email;//邮箱
	private String tel;//手机
	private String idCard;//身份证
	private int intergrate;//积分 
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReallyName() {
		return reallyName;
	}
	public void setReallyName(String reallyName) {
		this.reallyName = reallyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public int getIntergrate() {
		return intergrate;
	}
	public void setIntergrate(int intergrate) {
		this.intergrate = intergrate;
	}
}
