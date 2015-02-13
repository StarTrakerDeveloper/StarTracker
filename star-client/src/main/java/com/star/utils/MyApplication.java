package com.star.utils;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	private static Context context;

	@Override
	public void onCreate() {
		context = getApplicationContext();
	}

	// 获取全局Context
	public static Context getContext() {
		return context;
	}
}
