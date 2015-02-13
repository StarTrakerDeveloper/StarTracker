package com.star.activity;

import com.star.R;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPasswordActivity extends BaseActivity implements
		OnClickListener {
	private Button back, finish, send;
	private EditText phone, yzm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forget_password);
		initView();
		back.setOnClickListener(this);
		finish.setOnClickListener(this);
		send.setOnClickListener(this);
	}

	private void initView() {
		// TODO Auto-generated method stub
		back = (Button) this.findViewById(R.id.forget_psd_back);
		finish = (Button) this.findViewById(R.id.forget_psd_finish);
		send = (Button) this.findViewById(R.id.forget_psd_send);
		phone = (EditText) this.findViewById(R.id.forget_psd_phone);
		yzm = (EditText) this.findViewById(R.id.forget_psd_yzm);
	}

	boolean isPhoneEmpty() {
		String phoneString = phone.getText().toString().trim();
		return TextUtils.isEmpty(phoneString);
	}

	boolean isYzmEmpty() {
		String yzmString = yzm.getText().toString().trim();
		return TextUtils.isEmpty(yzmString);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.forget_psd_back:
			finish();
			break;
		case R.id.forget_psd_send:
			if (isPhoneEmpty()) {
				Toast.makeText(this, "请输入手机号码", 0).show();
			} else {
				Toast.makeText(this,
						"已经发送验证码到" + phone.getText().toString().trim(), 0)
						.show();
			}
			break;
		case R.id.forget_psd_finish:
			if (isPhoneEmpty()) {
				Toast.makeText(this, "请输入手机号码", 0).show();
			} else if (isYzmEmpty()) {
				Toast.makeText(this, "请输入验证码", 0).show();
			} else {
				Toast.makeText(this,
						"找回密码信息稍后将会发送到" + phone.getText().toString().trim(), 0)
						.show();
			}
			break;
		}
	}
}
