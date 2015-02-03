package com.star.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

//activity管理类
public class ActivityCollector {
	public static List<Activity> activities = new ArrayList<Activity>();

	public static void addActivity(Activity activity) {
		activities.add(activity);
	}

	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}

	// 销毁所有activity
	public static void finishAll() {
		for (Activity activity : activities) {
			activity.finish();
		}
	}
}
