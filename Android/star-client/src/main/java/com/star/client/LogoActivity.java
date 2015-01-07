package com.star.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.star.R;

public class LogoActivity extends Activity {

	private Button btn_login = null;
	private EditText et_uname_c = null;
	private EditText et_pwd_c = null;
	InputMethodManager inputMethodManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slipmenu);
		inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		et_uname_c = (EditText) findViewById(R.id.et_uname_c);
		et_pwd_c = (EditText) findViewById(R.id.et_pwd_c);
		setHintContent(et_uname_c, "请输入用户名");
		setHintContent(et_pwd_c, "请输入登录密码");
		
		// 控制键盘打开
		et_uname_c.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View arg0, boolean arg1) {
				// TODO Auto-generated method stub
				inputMethodManager.showSoftInput(et_uname_c,InputMethodManager.SHOW_FORCED);
			}
		});
		et_pwd_c.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View arg0, boolean arg1) {
				// TODO Auto-generated method stub
				inputMethodManager.showSoftInput(et_pwd_c,InputMethodManager.SHOW_FORCED);
			}
		});
		btn_login = (Button) findViewById(R.id.btn_login_c);
		btn_login.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// 控制键盘关闭
				inputMethodManager.hideSoftInputFromWindow(LogoActivity.this.getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
				
				// 判断用户名与密码是否为空
				if(!(et_uname_c.getText() != null && !"".equals(et_uname_c.getText().toString().trim()))){
					Toast.makeText(getApplicationContext(), "请输入用户名", Toast.LENGTH_LONG).show();
					setFocusOnView(et_uname_c);
				} else if(!(et_pwd_c.getText() != null && !"".equals(et_pwd_c.getText().toString().trim()))){
					Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_LONG).show();
					setFocusOnView(et_pwd_c);
				} else {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					intent.setClass(LogoActivity.this, MainActivity.class);
					intent.putExtra("uname", et_uname_c.getText().toString());
					intent.putExtra("pwd", et_pwd_c.getText().toString());
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * 修改 EditText 提示语 hint 的样式
	 * @param editText	编辑框对象
	 * @param content	提示内容
	 * @return
	 */
	private EditText setHintContent(EditText editText, String content) {

		SpannableString ss = new SpannableString(content);

		AbsoluteSizeSpan ass = new AbsoluteSizeSpan(18, true);

		ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		editText.setHint(new SpannedString(ss));
		return editText;
	}
	
	/**
	 * 获取焦点
	 * @param v	获取焦点的对象
	 */
	private void setFocusOnView(View v){
		v.setFocusable(true);
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.requestFocusFromTouch();
	}
}
