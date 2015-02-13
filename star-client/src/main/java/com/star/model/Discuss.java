package com.star.model;

public class Discuss {
	private int touxiang;
	private String name;
	private String time;
	private String content;

	public Discuss() {

	}

	public Discuss(int touxiang, String name, String time, String content) {
		super();
		this.touxiang = touxiang;
		this.name = name;
		this.time = time;
		this.content = content;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
