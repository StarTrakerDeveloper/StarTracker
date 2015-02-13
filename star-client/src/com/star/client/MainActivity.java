package com.star.client;

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

/**
 * 主Activity 显示logo
 * 		点击logo跳转到loginactivity
 * @author wx
 *
 */
public class MainActivity extends Activity {

	private ImageView im_logo_c = null;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im_logo_c = (ImageView) findViewById(R.id.logo);
        
        Intent intent = getIntent();
	    Bundle bundle = intent.getExtras();
	    if(bundle != null){
	    	setShowAnimation(im_logo_c, 2000);
	    	String uname = bundle.getString("uname");
	    	String pwd = bundle.getString("pwd");
	    	Toast.makeText(getApplicationContext(), "您输入的用户名为：" + uname + "，密码为：" + pwd, Toast.LENGTH_LONG).show();
	    } else {
	    	setShowAnimation(im_logo_c, 4000);
	    }
	    
        im_logo_c.setOnClickListener(new OnClickListener() {
		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
                intent.setClass(MainActivity.this, LogoActivity.class);
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
	
	private AlphaAnimation mHideAnimation= null;
	private AlphaAnimation mShowAnimation= null;
	/**
	 * View渐隐动画效果
	 *
	 */
	private void setHideAnimation( View view, int duration ){
		if( null == view || duration < 0 ){
			return;
		}
		if( null != mHideAnimation ){
			mHideAnimation.cancel( );
		}
		mHideAnimation = new AlphaAnimation(1.0f, 0.0f);
		mHideAnimation.setDuration( duration );
		mHideAnimation.setFillAfter( true );
		view.startAnimation( mHideAnimation );
	}
	/**
	 * View渐现动画效果
	 *
	 */
	private void setShowAnimation( View view, int duration ){
		if( null == view || duration < 0 ){
			return;
		}
		if( null != mShowAnimation ){
			mShowAnimation.cancel( );
		}
		mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
		mShowAnimation.setDuration( duration );
		mShowAnimation.setFillAfter( true );
		view.startAnimation( mShowAnimation );
	} 
}
