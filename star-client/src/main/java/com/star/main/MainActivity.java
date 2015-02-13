package com.star.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.star.R;
import com.star.activity.AddressListActivity;
import com.star.activity.LoginActivity;
import com.star.activity.SlipMenuActivity;

/**
 * 主界面
 * @ClassName: MainActivity.java 
 * @Description: 渐现logo，点击logo进行跳转
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:58:26
 */
public class MainActivity extends Activity implements OnClickListener {

	private ImageView im_logo_c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		im_logo_c = (ImageView) findViewById(R.id.logo);

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			setShowAnimation(im_logo_c, 2000);
			String uname = bundle.getString("uname");
			String pwd = bundle.getString("pwd");
			Toast.makeText(getApplicationContext(),
					"您输入的用户名为：" + uname + "，密码为：" + pwd, Toast.LENGTH_LONG)
					.show();
		} else {
			setShowAnimation(im_logo_c, 4000);
		}

		im_logo_c.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, LoginActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private AlphaAnimation mHideAnimation = null;
	private AlphaAnimation mShowAnimation = null;

	/**
	 * View渐隐动画效果
	 * 
	 */
	private void setHideAnimation(View view, int duration) {
		if (null == view || duration < 0) {
			return;
		}
		if (null != mHideAnimation) {
			mHideAnimation.cancel();
		}
		mHideAnimation = new AlphaAnimation(1.0f, 0.0f);
		mHideAnimation.setDuration(duration);
		mHideAnimation.setFillAfter(true);
		view.startAnimation(mHideAnimation);
	}

	/**
	 * View渐现动画效果
	 * 
	 */
	private void setShowAnimation(View view, int duration) {
		if (null == view || duration < 0) {
			return;
		}
		if (null != mShowAnimation) {
			mShowAnimation.cancel();
		}
		mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
		mShowAnimation.setDuration(duration);
		mShowAnimation.setFillAfter(true);
		view.startAnimation(mShowAnimation);
	}

	
	/**
	 * 控件点击的监听方法
	 */
	@Override
	public void onClick(View v) {
		Bundle bundle = new Bundle();
		Intent intent = new Intent(MainActivity.this, AddressListActivity.class);
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.logo:
			intent.setClass(MainActivity.this, SlipMenuActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
