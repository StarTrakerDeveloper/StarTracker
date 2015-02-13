package com.star.model;

public class User {
	private int touxiang;
	private String name;
	// 0-男，1-女
	private int sex;
	private int xingzuo;
	private String signature;

	public User() {

	}

	public User(int touxiang, String name, int sex, int xingzuo,
			String signature) {
		super();
		this.touxiang = touxiang;
		this.name = name;
		this.sex = sex;
		this.xingzuo = xingzuo;
		this.signature = signature;
	}

	public int getTouxiang() {
		return touxiang;
	}

	public void setTouxiang(int touxiang) {
		this.touxiang = touxiang;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getXingzuo() {
		return xingzuo;
	}

	public void setXingzuo(int xingzuo) {
		this.xingzuo = xingzuo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
