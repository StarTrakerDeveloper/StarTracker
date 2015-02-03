package com.star.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.star.R;
import com.star.model.Person;
import com.star.utils.PicUtils;

/**
 * 资料卡
 * @ClassName: PersonDetailActivity.java 
 * @Description: 点击通讯录查看资料卡详情，需替换此界面
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:50:37
 */
public class PersonDetailActivity extends BaseActivity {
	private Person person;
	private ImageView person_head_iv;
	private TextView person_name_tv;
	private PicUtils picUtils;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_persondetail);
		getData();
		initView();
	}

	private void getData() {
		// TODO Auto-generated method stub
		person = (Person) getIntent().getSerializableExtra("person");
		picUtils = new PicUtils(PersonDetailActivity.this);
	}

	private void initView() {
		// TODO Auto-generated method stub
		person_head_iv = (ImageView) findViewById(R.id.person_head_iv);
		person_name_tv = (TextView) findViewById(R.id.person_name_tv);
		person_head_iv.setImageBitmap(picUtils.getRoundBitmap(picUtils.getPhoto(person.getPhotoId(), person.getId(), R.drawable.btn_smail_p)));
		person_name_tv.setText(person.getName());
	}

}
