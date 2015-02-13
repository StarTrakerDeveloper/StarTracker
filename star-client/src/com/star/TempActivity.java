package com.star;

import com.star.activity.BaseActivity;
import com.star.activity.ChatActivity;
import com.star.activity.NearMsgActivity;
import com.star.activity.SearchActivity;
import com.star.utils.LogUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;

public class TempActivity extends BaseActivity {
	private GestureDetector gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temp);

		gestureDetector = new GestureDetector(TempActivity.this,
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
							Intent intent = new Intent(TempActivity.this,
									ChatActivity.class);
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

	public void click(View view) {
		Intent intent = new Intent(this, NearMsgActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}
}
