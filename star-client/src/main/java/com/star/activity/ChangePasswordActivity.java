package com.star.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.star.R;

public class ChangePasswordActivity extends BaseActivity implements
		OnClickListener {
	private EditText oldPassword, newPassword, confirmPassword;
	private Button commit, back;
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_password);
		initView();
		title.setText("修改密码");
		back.setOnClickListener(this);
		commit.setOnClickListener(this);
	}

	void initView() {
		oldPassword = (EditText) this.findViewById(R.id.change_psd_oldpswd);
		newPassword = (EditText) this.findViewById(R.id.change_psd_newpswd);
		confirmPassword = (EditText) this
				.findViewById(R.id.change_psd_confirmpswd);
		commit = (Button) this.findViewById(R.id.change_psd_commit);
		title = (TextView) this.findViewById(R.id.title);
		back = (Button) this.findViewById(R.id.back);
	}

	boolean isInputEmpty() {
		if (TextUtils.isEmpty(oldPassword.getText())) {
			Toast.makeText(this, "旧密码为空", 0).show();
			return true;
		}
		if (TextUtils.isEmpty(newPassword.getText())) {
			Toast.makeText(this, "新密码不能为空", 0).show();
			return true;
		}
		if (TextUtils.isEmpty(confirmPassword.getText())) {
			Toast.makeText(this, "确认密码不能为空", 0).show();
			return true;
		}
		return false;
	}

	boolean isPasswordEquals() {
		if (newPassword.getText().toString().trim()
				.equals(confirmPassword.getText().toString().trim())) {
			return true;
		} else {
			Toast.makeText(this, "两次输入的密码不一致", 0).show();
			return false;
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back:
			finish();
			break;
		case R.id.change_psd_commit:
			if (!isInputEmpty() && isPasswordEquals()) {
				Toast.makeText(this, "操作成功", 1).show();
			}
			break;

		}
	}
}
