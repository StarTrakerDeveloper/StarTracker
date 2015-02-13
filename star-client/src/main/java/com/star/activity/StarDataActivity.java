package com.star.activity;

import com.star.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StarDataActivity extends BaseActivity implements OnClickListener {
	private LinearLayout intoSpace;
	private TextView whosStar, name, signature, age, city, like, work;
	private ImageView touxiang, sex, xingzuo, play;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.star_data);
		initView();
		intoSpace.setOnClickListener(this);
		play.setOnClickListener(this);
	}

	private void initView() {
		// TODO Auto-generated method stub
		intoSpace = (LinearLayout) this.findViewById(R.id.star_data_into_space);
		whosStar = (TextView) this.findViewById(R.id.star_data_who);
		touxiang = (ImageView) this.findViewById(R.id.star_data_touxiang);
		name = (TextView) this.findViewById(R.id.star_data_name);
		sex = (ImageView) this.findViewById(R.id.star_data_sexImg);
		xingzuo = (ImageView) this.findViewById(R.id.star_data_xingzuoImg);
		signature = (TextView) this.findViewById(R.id.star_data_signature);
		play = (ImageView) this.findViewById(R.id.star_data_play);
		age = (TextView) this.findViewById(R.id.star_data_age);
		city = (TextView) this.findViewById(R.id.star_data_city);
		like = (TextView) this.findViewById(R.id.star_data_like);
		work = (TextView) this.findViewById(R.id.star_data_work);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.star_data_into_space:
			Intent intent = new Intent(this, NearMsgActivity.class);
			startActivity(intent);
			break;
		case R.id.star_data_play:
			Toast.makeText(this, "播放", 0).show();
			break;
		}
	}
}
