package com.star.activity;

import java.util.ArrayList;

import com.star.R;
import com.star.adapter.UserResultAdapter;
import com.star.model.Discuss;
import com.star.model.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SearchResultActivity extends BaseActivity implements
		OnClickListener {
	private Button back;
	private TextView title;
	private ListView listView;
	private ArrayList<User> users;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_result);
		initView();
		initUsers();
		title.setText("搜索结果");
		back.setOnClickListener(this);
		UserResultAdapter userAdapter = new UserResultAdapter(this,
				R.layout.search_result_item, users);
		listView.setAdapter(userAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SearchResultActivity.this,
						SocialStarFriendActivity.class);
				startActivity(intent);
			}
		});
	}

	private void initUsers() {
		// TODO Auto-generated method stub
		users = new ArrayList<User>();
		User u1 = new User(R.drawable.test1, "张三", 0, R.drawable.baiyang,
				"no zuo no die");
		User u2 = new User(R.drawable.test2, "李四", 1, R.drawable.shizi,
				"why you try");
		User u3 = new User(R.drawable.test3, "王五", 1, R.drawable.tianping,
				"you zuo you die");
		User u4 = new User(R.drawable.test4, "赵六", 0, R.drawable.tianxie,
				"don't ask why");
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
	}

	private void initView() {
		// TODO Auto-generated method stub
		back = (Button) this.findViewById(R.id.back);
		title = (TextView) this.findViewById(R.id.title);
		listView = (ListView) this.findViewById(R.id.search_result_listview);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back:
			finish();
			break;
		}
	}
}
