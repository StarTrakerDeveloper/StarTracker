package com.star.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.star.R;
/**
 * 
 * @Description: 消息设置
 * @author yyl
 * @date 2015-01-20 12:44
 * 
 */
public class MessageSettingActivity extends BaseActivity implements
		OnClickListener {
	private Button back;
	private TextView title;
	//新消息选项开关
	private ToggleButton newNotification, notification;
	//特别关心
	private LinearLayout tbgx;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_setting);
		initView();
		title.setText("消息");
		back.setOnClickListener(this);
		tbgx.setOnClickListener(this);
		//选项状态改变坚挺
		OnCheckedChangeListener listener = new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buttonView.getId() == R.id.message_setting_newNotification) {
					if (isChecked) {
						Toast.makeText(MessageSettingActivity.this, "新消息通知打开",
								0).show();
					} else {
						Toast.makeText(MessageSettingActivity.this, "新消息通知关闭",
								0).show();
					}
				}

				if (buttonView.getId() == R.id.message_setting_notification) {
					if (isChecked) {
						Toast.makeText(MessageSettingActivity.this, "通知打开", 0)
								.show();
					} else {
						Toast.makeText(MessageSettingActivity.this, "通知关闭", 0)
								.show();
					}
				}
			}
		};
		newNotification.setOnCheckedChangeListener(listener);
		notification.setOnCheckedChangeListener(listener);

	}

	void initView() {
		newNotification = (ToggleButton) this
				.findViewById(R.id.message_setting_newNotification);
		notification = (ToggleButton) this
				.findViewById(R.id.message_setting_notification);
		back = (Button) this.findViewById(R.id.back);
		title = (TextView) this.findViewById(R.id.title);
		tbgx = (LinearLayout) this.findViewById(R.id.tbgx);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back:
			finish();
			break;

		case R.id.tbgx:
			Toast.makeText(this, "特别关心", 0).show();
			break;
		}
	}

}
