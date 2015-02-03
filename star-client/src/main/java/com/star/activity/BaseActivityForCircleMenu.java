package com.star.activity;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivityForCircleMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setView();
		initView();
		setListener();
	}

	 
	public abstract void setView();

	 
	public abstract void initView();
 
	public abstract void setListener();

}
