package com.star.activity;

import com.star.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ZhangHaoSettingActivity extends BaseActivity implements
		OnClickListener {
	private LinearLayout online, yinshen, add;
	private ImageView onlineImage, yinshenImage;
	private Button back, exit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhanghao_setting);
		initView();
		online.setOnClickListener(this);
		yinshen.setOnClickListener(this);
		add.setOnClickListener(this);
		back.setOnClickListener(this);
		exit.setOnClickListener(this);
	}

	void initView() {
		online = (LinearLayout) this.findViewById(R.id.zhanghao_setting_online);
		yinshen = (LinearLayout) this
				.findViewById(R.id.zhanghao_setting_yinshen);
		add = (LinearLayout) this.findViewById(R.id.zhanghao_setting_add);
		onlineImage = (ImageView) this
				.findViewById(R.id.zhanghao_setting_onlineImg);
		yinshenImage = (ImageView) this
				.findViewById(R.id.zhanghao_setting_yinshenImg);
		back = (Button) this.findViewById(R.id.zhanghao_setting_back);
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
		case R.id.zhanghao_setting_add:
			Toast.makeText(this, "添加账号", 0).show();
			break;
		case R.id.zhanghao_setting_back:
			finish();
			break;
		case R.id.zhanghao_setting_exit:
			ActivityCollector.finishAll();
			break;
		}
	}
}
