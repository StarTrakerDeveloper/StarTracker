package com.star.model;

import android.graphics.drawable.Drawable;

public class NearMessage {
	private String name;
	private Drawable touxiang;
	private int sex;
	private String xingzuo;
	private String refreshTime;
	private String nearMessage;
	private String nearMsgLBS;

	public NearMessage() {

	}

	public NearMessage(String name, Drawable touxiang, int sex, String xingzuo,
			String refreshTime, String nearMessage, String nearMsgLBS) {
		super();
		this.name = name;
		this.touxiang = touxiang;
		this.sex = sex;
		this.xingzuo = xingzuo;
		this.refreshTime = refreshTime;
		this.nearMessage = nearMessage;
		this.nearMsgLBS = nearMsgLBS;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Drawable getTouxiang() {
		return touxiang;
	}

	public void setTouxiang(Drawable touxiang) {
		this.touxiang = touxiang;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getXingzuo() {
		return xingzuo;
	}

	public void setXingzuo(String xingzuo) {
		this.xingzuo = xingzuo;
	}

	public String getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(String refreshTime) {
		this.refreshTime = refreshTime;
	}

	public String getNearMessage() {
		return nearMessage;
	}

	public void setNearMessage(String nearMessage) {
		this.nearMessage = nearMessage;
	}

	public String getNearMsgLBS() {
		return nearMsgLBS;
	}

	public void setNearMsgLBS(String nearMsgLBS) {
		this.nearMsgLBS = nearMsgLBS;
	}

}
