package com.star.activity;

import com.star.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 
 * @Description: 账号设置
 * @author yyl
 * @date 2015-01-20 12:44
 * 
 */
public class ZhangHaoSettingActivity extends BaseActivity implements
		OnClickListener {
	private LinearLayout online, yinshen;
	//在线，隐身状态图标
	private ImageView onlineImage, yinshenImage;
	private TextView title;
	private Button back, exit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhanghao_setting);
		initView();
		title.setText("设置");
		online.setOnClickListener(this);
		yinshen.setOnClickListener(this);
		back.setOnClickListener(this);
		exit.setOnClickListener(this);
	}

	void initView() {
		online = (LinearLayout) this.findViewById(R.id.zhanghao_setting_online);
		yinshen = (LinearLayout) this
				.findViewById(R.id.zhanghao_setting_yinshen);
		onlineImage = (ImageView) this
				.findViewById(R.id.zhanghao_setting_onlineImg);
		yinshenImage = (ImageView) this
				.findViewById(R.id.zhanghao_setting_yinshenImg);
		back = (Button) this.findViewById(R.id.back);
		title = (TextView) this.findViewById(R.id.title);
		exit = (Button) this.findViewById(R.id.zhanghao_setting_exit);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.zhanghao_setting_yinshen:
			onlineImage.setVisibility(View.INVISIBLE);
			yinshenImage.setVisibility(View.VISIBLE);
			break;

		case R.id.zhanghao_setting_online:
			onlineImage.setVisibility(View.VISIBLE);
			yinshenImage.setVisibility(View.INVISIBLE);
			break;
		case R.id.back:
			finish();
			break;
		case R.id.zhanghao_setting_exit:
			ActivityCollector.finishAll();
			break;
		}
	}
}
