package com.star.activity;

import com.star.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegistActivity extends BaseActivity implements OnClickListener {
	private ImageView back;
	private EditText phone, password, confirmPassword;
	private Button regist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registered);
		initView();
		back.setOnClickListener(this);
		regist.setOnClickListener(this);
	}

	void initView() {
		back = (ImageView) this.findViewById(R.id.registered_back);
		phone = (EditText) this.findViewById(R.id.registered_phone);
		password = (EditText) this.findViewById(R.id.registered_password);
		confirmPassword = (EditText) this
				.findViewById(R.id.registered_confirm_psd);
		regist = (Button) this.findViewById(R.id.registered_regist);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.registered_back:
			finish();
			break;

		case R.id.registered_regist:
			if (!isInputEmpty() && isPasswordEquals()) {
				Toast.makeText(this, "注册成功", 1).show();
				Intent intent = new Intent(this,GuideActivity.class);
				startActivity(intent);
			}
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
		if (TextUtils.isEmpty(confirmPassword.getText())) {
			Toast.makeText(this, "确认密码不能为空", 0).show();
			return true;
		}
		return false;
	}

	boolean isPasswordEquals() {
		if (password.getText().toString().trim()
				.equals(confirmPassword.getText().toString().trim())) {
			return true;
		} else {
			Toast.makeText(this, "两次输入的密码不一致", 0).show();
			return false;
		}

	}
}
