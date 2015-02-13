package com.star.activity;

import com.star.R;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPasswordActivity extends BaseActivity implements OnClickListener{
	private EditText oldPassword, newPassword, confirmPassword;
	private Button commit;
	private Button back;
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgetpswd);
		initView();
		back.setOnClickListener(this);
		title.setText("忘记密码");
	}

	public void commit(View view) {
		if (!isInputEmpty() && isPasswordEquals()) {
			Toast.makeText(this, "操作成功", 1).show();
		}
	}

	public void back(View view) {
		finish();
	}

	void initView() {
		back = (Button) this.findViewById(R.id.back);
		title = (TextView) this.findViewById(R.id.title);
		oldPassword = (EditText) this.findViewById(R.id.forget_oldpswd);
		newPassword = (EditText) this.findViewById(R.id.forget_newpswd);
		confirmPassword = (EditText) this.findViewById(R.id.forget_confirmpswd);
		commit = (Button) this.findViewById(R.id.forget_commit);
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
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back:
			finish();
			break;
		}
	}
}
