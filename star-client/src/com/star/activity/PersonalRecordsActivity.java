package com.star.activity;

import com.star.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalRecordsActivity extends BaseActivity implements
		OnClickListener {
	private Button back;
	private ImageView touxiang, sex, xingzuo, biaoqing, chatAdd;
	private TextView name;
	private EditText imputMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal_records);
		initView();
		back.setOnClickListener(this);
		biaoqing.setOnClickListener(this);
		chatAdd.setOnClickListener(this);
	}

	void initView() {
		back = (Button) this.findViewById(R.id.personal_records_back);
		touxiang = (ImageView) this
				.findViewById(R.id.personal_records_touxiang);
		name = (TextView) this.findViewById(R.id.personal_records_name);
		sex = (ImageView) this.findViewById(R.id.personal_records_sexImg);
		xingzuo = (ImageView) this
				.findViewById(R.id.personal_records_xingzuoImg);
		biaoqing = (ImageView) this.findViewById(R.id.chat_biaoqing);
		chatAdd = (ImageView) this.findViewById(R.id.chat_add);
		imputMessage = (EditText) this.findViewById(R.id.chat_message);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.personal_records_back:
			finish();
			break;
		case R.id.chat_biaoqing:
			Toast.makeText(this, "表情", 1).show();
			break;
		case R.id.chat_add:
			Toast.makeText(this, "添加", 1).show();
			break;

		}
	}
}
