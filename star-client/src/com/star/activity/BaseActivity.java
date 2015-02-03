package com.star.activity;

import com.star.utils.LogUtil;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {
	// 每创建一个activity在ActivityCollector的集合中加入
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LogUtil.v("BaseActivity", getClass().getSimpleName());
		ActivityCollector.addActivity(this);
	}

	// 每销毁一个activity在ActivityCollector的集合中移除
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
}
