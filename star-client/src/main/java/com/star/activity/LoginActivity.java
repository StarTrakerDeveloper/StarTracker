package com.star.activity;

import com.star.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements OnClickListener {
	private EditText phone, password;
	private Button login, forgetpsd, regist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
		login.setOnClickListener(this);
		forgetpsd.setOnClickListener(this);
		regist.setOnClickListener(this);
	}

	void initView() {
		phone = (EditText) this.findViewById(R.id.login_phone);
		password = (EditText) this.findViewById(R.id.login_pswd);
		login = (Button) this.findViewById(R.id.login_login);
		forgetpsd = (Button) this.findViewById(R.id.login_forgetpassword);
		regist = (Button) this.findViewById(R.id.login_register);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_login:
			if (!isInputEmpty()) {
				Intent intent = new Intent(this, SlipMenuActivity.class);
				startActivity(intent);
			}
			break;

		case R.id.login_forgetpassword:
			Intent forget = new Intent(this, ForgetPasswordActivity.class);
			startActivity(forget);
			break;

		case R.id.login_register:
			Intent regist = new Intent(this, RegistActivity.class);
			startActivity(regist);
			break;
		}
	}

	boolean isInputEmpty() {
		if (TextUtils.isEmpty(phone.getText())) {
			Toast.makeText(this, "手机号码为空", 0).show();
			return true;
		}
		if (TextUtils.isEmpty(password.getText())) {
			Toast.makeText(this, "密码不能为空", 0).show();
			return true;
		}
		return false;
	}
}
