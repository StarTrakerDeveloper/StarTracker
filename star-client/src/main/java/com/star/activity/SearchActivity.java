package com.star.activity;

import com.star.R;
import com.star.activity.TempActivity;
import com.star.client.CircleImageView;
import com.star.utils.LogUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.FrameLayout;
import android.widget.Toast;

public class SearchActivity extends BaseActivity {
	private CircleImageView touxiang;
	private FrameLayout searchLayout;
	private GestureDetector gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find_other_stafriend);
		initView();
		gestureDetector = new GestureDetector(SearchActivity.this,
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
							Intent intent = new Intent(SearchActivity.this,
									TempActivity.class);
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

	public void search(View view) {
		Toast.makeText(this, "搜索", 1).show();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}

	private void initView() {
		touxiang = (CircleImageView) this.findViewById(R.id.touxiang);
		searchLayout = (FrameLayout) this.findViewById(R.id.search_layout);
	}
}
