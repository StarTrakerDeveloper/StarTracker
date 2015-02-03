package com.star.model;

import android.graphics.drawable.Drawable;

public class TimeLine {
	private Drawable drawable;
	private String time;
	private String content;

	public TimeLine() {

	}

	public TimeLine(Drawable drawable, String time, String content) {
		super();
		this.drawable = drawable;
		this.time = time;
		this.content = content;
	}

	public Drawable getDrawable() {
		return drawable;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
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
