package com.star.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.star.R;
/**
 * 附件的人
 * @ClassName: RadarActivity.java 
 * @Description: 仿雷达扫描效果，动画效果未完成
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:51:11
 */
public class RadarActivity extends BaseActivity {

	private ImageView iv_back_top_left;
	private ImageView im_scan;
	private ImageView im_dian1,im_dian2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radar);
		iv_back_top_left = (ImageView) findViewById(R.id.iv_back_radar_top);
		iv_back_top_left.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		
		im_scan = (ImageView) findViewById(R.id.im_scan);
		im_dian1 = (ImageView) findViewById(R.id.im_dian1);
		im_dian2 = (ImageView) findViewById(R.id.im_dian2);
		RotateAnimation animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
				0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		animation.setDuration(2000);
		animation.setRepeatCount(Animation.INFINITE);
		im_scan.startAnimation(animation);
		
		AlphaAnimation animation2 = new AlphaAnimation(0.0f, 1.0f);
		animation2.setDuration(3000);
		animation2.setRepeatCount(Animation.INFINITE);
		im_dian1.startAnimation(animation2);
		im_dian2.startAnimation(animation2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.radar, menu);
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
}
