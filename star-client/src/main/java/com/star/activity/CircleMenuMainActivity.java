package com.star.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.star.R;
import com.star.layout.view.CircleLayout;
import com.star.layout.view.CircleLayout.OnItemClickListener;
import com.star.layout.view.CircleLayout.OnItemSelectedListener;
import com.star.utils.LogUtil;

public class CircleMenuMainActivity extends BaseActivityForCircleMenu implements
		OnItemSelectedListener, OnItemClickListener, OnClickListener {
	private RelativeLayout relbtn;
	private CircleLayout circleMenu;
	private TextView name;

	@Override
	public void setView() {
		setContentView(R.layout.choose_constellation);

	}

	@Override
	public void initView() {
		circleMenu = (CircleLayout) findViewById(R.id.main_circle_layout);
		relbtn = (RelativeLayout) findViewById(R.id.relbtn);
		name = (TextView) this.findViewById(R.id.choose_onstellation_name);
		setWelcomeName();
	}

	private void setWelcomeName() {
		Bundle bundle = this.getIntent().getExtras();
		String userName = bundle.getString("name");
		name.setText("Hi," + userName);
	}

	@Override
	public void setListener() {
		circleMenu.setOnItemSelectedListener(this);
		circleMenu.setOnItemClickListener(this);
		relbtn.setOnClickListener(this);
	}

	@Override
	public void onItemSelected(View view, int position, long id, String name) {
		// selectedTextView.setText(name);
	}

	@Override
	public void onItemClick(View view, int position, long id, String name) {
		int[] location = new int[2];
		view.getLocationInWindow(location);
		LogUtil.i("位置", "x:" + location[0] + "y:" + location[1]);
		if (location[1] < 450) {
			Toast.makeText(getApplicationContext(), " 您已选择" + name + "作为您的星座",
					Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, FillDetailsActivity.class);
			startActivity(intent);
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.relbtn:
			Toast.makeText(getApplicationContext(), "更换头像", Toast.LENGTH_SHORT)
					.show();
			break;
		default:
			break;
		}
	}

}
