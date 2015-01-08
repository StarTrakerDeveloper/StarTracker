package com.star.activity;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.star.R;
import com.star.dialog.Effectstype;
import com.star.dialog.NiftyDialogBuilder;
import com.star.layout.view.BubbleView;
import com.star.utils.Util;

/**
 * 星空留言板内容
 * @ClassName: BubbleActivity.java 
 * @Description: 气泡位置随机出现，点击气泡在弹出框中显示留言详情
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:48:43
 */
public class BubbleActivity extends Activity implements OnClickListener {
	// 顶部的返回按钮（图片）
	private ImageView iv_back_top_left;
	// 自定义的随机气泡布局页面
	private BubbleView bubble_random_view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bubble);
		initView();
	}

	/**
	 * 初始化view
	 */
	private void initView() {
		// TODO Auto-generated method stub
		iv_back_top_left = (ImageView) findViewById(R.id.iv_back_tongxunlu_top);
		iv_back_top_left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		bubble_random_view = (BubbleView) findViewById(R.id.bubble_random_view);
		bubble_random_view.setOnClickListener(this);
		bubble_random_view.LoadFlowerImage();

		// 获取当前屏幕的高和宽
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		bubble_random_view.SetView(dm.heightPixels, dm.widthPixels);

		// 更新当前花
		update();
	}

	/*
	 * 负责做界面更新工作 ，实现散花
	 */
	private RefreshHandler mRedrawHandler = new RefreshHandler();

	class RefreshHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {

			bubble_random_view.addRandomFlower();

			bubble_random_view.invalidate();
			sleep(5000);
		}

		public void sleep(long delayMillis) {
			this.removeMessages(0);
			sendMessageDelayed(obtainMessage(0), delayMillis);
		}
	};

	public void update() {
		bubble_random_view.addRandomFlower();
		mRedrawHandler.sleep(5000);
	}

	/**
	 * 控件监听方法
	 */
	@Override
	public void onClick(View v) {
		// TODO 用于监听气泡的点击事件，将当前点击的气泡信息传递给弹出框
		
		Effectstype[] effects = new Effectstype[]{
				Effectstype.Fadein,
				Effectstype.Fall,
				Effectstype.Fliph,
				Effectstype.Flipv,
				Effectstype.Newspager,
				Effectstype.RotateBottom,
				Effectstype.RotateLeft,
				Effectstype.Shake,
				Effectstype.Sidefill,
				Effectstype.SlideBottom,
				Effectstype.Slideleft,
				Effectstype.Slideright,
				Effectstype.Slidetop,
				Effectstype.Slit
		};
		
		int index = new Random().nextInt(effects.length);
		
		NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(this);
		
		dialogBuilder
        .withTitle("留言用户")                                  		//.withTitle(null)  no title
        .withTitleColor("#FFFFFF")                                  //def
        .withDividerColor("#e0000000")                              //def
        .withMessage("此处用于显示留言的图文信息")                     	//.withMessage(null)  no Msg
        .withMessageColor("#FFFFFF")                                //def
        .withIcon(getResources().getDrawable(R.drawable.logo))
        .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
        .withDuration(700)                                          //def
        .withEffect(effects[index])                                         //def Effectstype.Slidetop
        .withButton1Text("回复")                                    	//def gone
        .withButton2Text("取消")                                  	//def gone
        //.setCustomView(R.layout.custom_view,v.getContext())      	//.setCustomView(View or ResId,context)
        .setButton1Click(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "发表回复", Toast.LENGTH_SHORT).show();
            }
        })
        .setButton2Click(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "关闭弹出框", Toast.LENGTH_SHORT).show();
            }
        });
		switch (v.getId()) {

		default:
			Util.log("点击事件");
			dialogBuilder.show();
			break;
		}
	}

	/**
	 * 初始化Menu
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Menu中item的点击监听
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
