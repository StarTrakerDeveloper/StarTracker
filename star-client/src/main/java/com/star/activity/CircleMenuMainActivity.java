package com.star.activity;

 
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.star.R;
import com.star.layout.view.CircleLayout;
import com.star.layout.view.CircleLayout.OnItemClickListener;
import com.star.layout.view.CircleLayout.OnItemSelectedListener;


public class CircleMenuMainActivity extends BaseActivity implements
		OnItemSelectedListener, OnItemClickListener, OnClickListener {
	private RelativeLayout relbtn;
	private CircleLayout circleMenu;

	@Override
	public void setView() {
		setContentView(R.layout.construction_bank_main);

	}

	@Override
	public void initView() {
		circleMenu = (CircleLayout) findViewById(R.id.main_circle_layout);
		relbtn = (RelativeLayout) findViewById(R.id.relbtn);
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
		Toast.makeText(getApplicationContext(), " " + name, Toast.LENGTH_SHORT)
				.show();
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
