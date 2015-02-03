package com.star.activity;

import com.star.R;
import com.star.utils.LogUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FillDetailsActivity extends BaseActivity implements
		OnClickListener {
	private Button save, back, voince;
	private ImageView imageView1, imageView2, imageView3, addImageView;
	private EditText et_language, et_age, et_city;
	private String TAG = "FillDetailsActivity";
	private String language, age, city;
	private LinearLayout voinceLayout, bgLayout;
	private GestureDetector gestureDetector;
	private static final int LARGE_MOVE = 60;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.another_profile_show);
		initView();
		language = et_language.getText().toString().trim();
		age = et_age.getText().toString().trim();
		city = et_city.getText().toString().trim();
		back.setOnClickListener(this);
		save.setOnClickListener(this);
		voince.setOnClickListener(this);
		voinceLayout.setOnClickListener(this);
		// 监听滑动手势，跳转下一页面
		gestureDetector = new GestureDetector(FillDetailsActivity.this,
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
							Intent intent = new Intent(
									FillDetailsActivity.this,
									SearchActivity.class);
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

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}

	public void initView() {
		save = (Button) this.findViewById(R.id.profile_save);
		back = (Button) this.findViewById(R.id.profile_back);
		voince = (Button) this.findViewById(R.id.profile_voince);
		imageView1 = (ImageView) this.findViewById(R.id.profile_image1);
		imageView2 = (ImageView) this.findViewById(R.id.profile_image2);
		imageView3 = (ImageView) this.findViewById(R.id.profile_image3);
		addImageView = (ImageView) this.findViewById(R.id.profile_addimage);
		et_language = (EditText) this.findViewById(R.id.profile_language);
		et_age = (EditText) this.findViewById(R.id.profile_age);
		et_city = (EditText) this.findViewById(R.id.profile_city);
		voinceLayout = (LinearLayout) this
				.findViewById(R.id.profile_voince_lay);
		bgLayout = (LinearLayout) this.findViewById(R.id.profile_background);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, RecordingActivity.class);
		switch (view.getId()) {
		case R.id.profile_back:
			finish();
			break;
		case R.id.profile_save:
			Toast.makeText(this, "保存填好的信息", 1).show();
			LogUtil.i(TAG, "保存信息");
			break;
		case R.id.profile_addimage:
			Toast.makeText(this, "添加新图片", 1).show();
			break;
		case R.id.profile_voince_lay:
			LogUtil.i(TAG, "录制音频");
			startActivity(intent);
			break;
		case R.id.profile_voince:
			LogUtil.i(TAG, "录制音频");
			startActivity(intent);
			break;
		}
	}
}
