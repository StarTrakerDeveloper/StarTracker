package com.star.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.EditText;
import android.widget.Toast;

import com.star.R;
import com.star.utils.LogUtil;

public class AddNameActivity extends BaseActivity {
	private GestureDetector gestureDetector;
	private EditText name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addname);
		initView();
		// 监听滑动手势，跳转下一页面
		gestureDetector = new GestureDetector(AddNameActivity.this,
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
							if (!isEmpty()) {
								Intent intent = new Intent(
										AddNameActivity.this,
										CircleMenuMainActivity.class);
								startActivity(intent);
							} else {
								Toast.makeText(AddNameActivity.this, "请输入昵称", 0)
										.show();
							}

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
		name = (EditText) this.findViewById(R.id.addname_name);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}

	boolean isEmpty() {
		String etName = name.getText().toString().trim();
		return TextUtils.isEmpty(etName);
	}
}
