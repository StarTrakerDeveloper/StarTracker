package com.star.activity;

import com.star.R;
import com.star.client.CircleImageView;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ZhangHaoActivity extends BaseActivity implements OnClickListener {
	private CircleImageView touxiang;
	private Button back;
	private TextView name, id, starOner;
	private LinearLayout star, starLevel, chatHistory, heimindan;
	private ImageView starImg, starLevelImg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhanghao);
		initView();
		star.setOnClickListener(this);
		starLevel.setOnClickListener(this);
		heimindan.setOnClickListener(this);
		chatHistory.setOnClickListener(this);
		back.setOnClickListener(this);
	}

	void initView() {
		touxiang = (CircleImageView) this.findViewById(R.id.zhanghao_touxiang);
		back = (Button) this.findViewById(R.id.zhanghao_back);
		name = (TextView) this.findViewById(R.id.zhanghao_name);
		id = (TextView) this.findViewById(R.id.zhanghao_id);
		star = (LinearLayout) this.findViewById(R.id.zhanghao_star);
		starImg = (ImageView) this.findViewById(R.id.zhanghao_starImg);
		starOner = (TextView) this.findViewById(R.id.zhanghao_starOner);
		starLevel = (LinearLayout) this.findViewById(R.id.zhanghao_starLevel);
		starLevelImg = (ImageView) this
				.findViewById(R.id.zhanghao_starLevelImg);
		chatHistory = (LinearLayout) this
				.findViewById(R.id.zhanghao_chatHistory);
		heimindan = (LinearLayout) this.findViewById(R.id.zhanghao_heimindan);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.zhanghao_star:
			Toast.makeText(this, "星星", 0).show();
			break;
		case R.id.zhanghao_starLevel:
			Toast.makeText(this, "个人星级", 0).show();
			break;
		case R.id.zhanghao_chatHistory:
			Toast.makeText(this, "聊天记录", 0).show();
			break;
		case R.id.zhanghao_heimindan:
			Toast.makeText(this, "黑名单", 0).show();
			break;
		case R.id.zhanghao_back:
			finish();
			break;

		}
	}
}
