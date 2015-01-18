package com.star.activity;

import com.star.R;
import com.star.client.CircleImageView;
import com.star.utils.LogUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SettingActivity extends BaseActivity implements OnClickListener {

	private Button back;
	private LinearLayout zhanghao, xxtz, huancun, fuzhu, about;
	private CircleImageView touxiang;
	private GestureDetector gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		initView();
		back.setOnClickListener(this);
		zhanghao.setOnClickListener(this);
		xxtz.setOnClickListener(this);
		huancun.setOnClickListener(this);
		fuzhu.setOnClickListener(this);
		about.setOnClickListener(this);
		gestureDetector = new GestureDetector(SettingActivity.this,
				new SimpleOnGestureListener() {
					@Override
					public boolean onFling(MotionEvent e1, MotionEvent e2,
							float velocityX, float velocityY) {
						System.out.println("----------------滑动---------------");
						// TODO Auto-generated method stub
						final int FLING_MIN_DISTANCE = 60, FLING_MIN_VELOCITY = 120;
						if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
								&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
							// Fling left
							LogUtil.i("MyGesture", "Fling left");
							Intent intent = new Intent(SettingActivity.this,
									ZhangHaoSettingActivity.class);
							startActivity(intent);
						} else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
								&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
							// Fling right
							LogUtil.i("MyGesture", "Fling right");

						}
						return true;
					}
				});
	}

	void initView() {
		back = (Button) this.findViewById(R.id.setting_back);
		zhanghao = (LinearLayout) this.findViewById(R.id.setting_zhanghao);
		touxiang = (CircleImageView) this.findViewById(R.id.setting_touxiang);
		xxtz = (LinearLayout) this.findViewById(R.id.xxtz);
		huancun = (LinearLayout) this.findViewById(R.id.huancun);
		fuzhu = (LinearLayout) this.findViewById(R.id.fuzhu);
		about = (LinearLayout) this.findViewById(R.id.about);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.setting_back:
			finish();
			break;
		case R.id.setting_zhanghao:
			Intent intent = new Intent(this, ZhangHaoActivity.class);
			startActivity(intent);
			break;
		case R.id.xxtz:
			Toast.makeText(this, "消息通知", 0).show();
			break;
		case R.id.huancun:
			Toast.makeText(this, "缓存", 0).show();
			break;
		case R.id.fuzhu:
			Toast.makeText(this, "辅助", 0).show();
			break;
		case R.id.about:
			Toast.makeText(this, "关于", 0).show();
			break;

		}
	}
}
