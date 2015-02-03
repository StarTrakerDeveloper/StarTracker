package com.star.activity;

import com.star.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
/**
 * 
 * @Description: 辅助设置
 * @author yyl
 * @date 2015-01-20 12:44
 * 
 */
public class FuZhuSettingActivity extends BaseActivity implements
		OnClickListener {
	private Button back;
	//选项开关，分别对应界面上的开关
	private ToggleButton wifi, sougou, lxrszm, zdjs;
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fuzhu_setting);
		initView();
		title.setText("辅助");
		back.setOnClickListener(this);
		//选项开关监听
		OnCheckedChangeListener listener = new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buttonView.getId() == R.id.fuzhu_setting_wifi) {
					if (isChecked) {
						Toast.makeText(FuZhuSettingActivity.this, "wifi打开", 0)
								.show();
					} else {
						Toast.makeText(FuZhuSettingActivity.this, "wifi关闭", 0)
								.show();
					}
				}

				if (buttonView.getId() == R.id.fuzhu_setting_sougou) {
					if (isChecked) {
						Toast.makeText(FuZhuSettingActivity.this, "sougou打开", 0)
								.show();
					} else {
						Toast.makeText(FuZhuSettingActivity.this, "sougou关闭", 0)
								.show();
					}
				}
				if (buttonView.getId() == R.id.fuzhu_setting_lxrszm) {
					if (isChecked) {
						Toast.makeText(FuZhuSettingActivity.this, "lxrszm打开", 0)
								.show();
					} else {
						Toast.makeText(FuZhuSettingActivity.this, "lxrszm关闭", 0)
								.show();
					}
				}
				if (buttonView.getId() == R.id.fuzhu_setting_zdjs) {
					if (isChecked) {
						Toast.makeText(FuZhuSettingActivity.this, "zdjs打开", 0)
								.show();
					} else {
						Toast.makeText(FuZhuSettingActivity.this, "zdjs关闭", 0)
								.show();
					}
				}
			}
		};
		wifi.setOnCheckedChangeListener(listener);
		sougou.setOnCheckedChangeListener(listener);
		lxrszm.setOnCheckedChangeListener(listener);
		zdjs.setOnCheckedChangeListener(listener);
	}

	void initView() {
		back = (Button) this.findViewById(R.id.back);
		title = (TextView) this.findViewById(R.id.title);
		wifi = (ToggleButton) this.findViewById(R.id.fuzhu_setting_wifi);
		sougou = (ToggleButton) this.findViewById(R.id.fuzhu_setting_sougou);
		lxrszm = (ToggleButton) this.findViewById(R.id.fuzhu_setting_lxrszm);
		zdjs = (ToggleButton) this.findViewById(R.id.fuzhu_setting_zdjs);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back:
			finish();
			break;

		}
	}
}
