package com.star.activity;

import java.util.ArrayList;
import java.util.List;

import com.star.R;
import com.star.adapter.NearMessagesAdapter;
import com.star.model.NearMessage;
import com.star.utils.LogUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NearMsgActivity extends BaseActivity implements OnClickListener {
	private Button back;
	private TextView title;
	private ListView msgListView;
	private List<NearMessage> msgList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.near_message);
		initView();
		back.setOnClickListener(this);
		title.setText("Near the message");
		initNearMessages();

		msgListView.setAdapter(new NearMessagesAdapter(NearMsgActivity.this,
				R.layout.near_message_item, msgList));
		msgListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				// Toast.makeText(getApplicationContext(), "click", 0).show();
				Intent intent = new Intent(NearMsgActivity.this,
						PersonalRecordsActivity.class);
				startActivity(intent);

			}
		});
	}

	private void initView() {
		back = (Button) this.findViewById(R.id.back);
		title = (TextView) this.findViewById(R.id.title);
		msgListView = (ListView) this.findViewById(R.id.near_msg_listview);
	}

	private void initNearMessages() {
		msgList = new ArrayList<NearMessage>();
		NearMessage nm1 = new NearMessage("zhangsan", getResources()
				.getDrawable(R.drawable.kn), 0, "tianchen", "2min",
				"no zuo no die", "2km");
		NearMessage nm2 = new NearMessage("lisi", getResources().getDrawable(
				R.drawable.kn), 1, "shizi", "6min", "why you try", "1.8km");
		NearMessage nm3 = new NearMessage("wangwu", getResources().getDrawable(
				R.drawable.kn), 0, "baiyang", "18min", "you zuo you die",
				"3.6km");
		NearMessage nm4 = new NearMessage("zhangmazi", getResources()
				.getDrawable(R.drawable.kn), 1, "baiyang", "40min",
				"don't ask why", "3.8km");
		msgList.add(nm1);
		msgList.add(nm2);
		msgList.add(nm3);
		msgList.add(nm4);
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
