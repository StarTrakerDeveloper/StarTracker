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
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class NearMsgActivity extends BaseActivity {
	private Button back;
	private ListView msgListView;
	private List<NearMessage> msgList;
	private GestureDetector gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.near_message);
		initView();
		initNearMessages();

		gestureDetector = new GestureDetector(NearMsgActivity.this,
				new SimpleOnGestureListener() {
					@Override
					public boolean onFling(MotionEvent e1, MotionEvent e2,
							float velocityX, float velocityY) {
						System.out.println("----------------滑动---------------");
						// TODO Auto-generated method stub
						final int FLING_MIN_DISTANCE = 120, FLING_MIN_VELOCITY = 200;
						if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
								&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
							// Fling left
							LogUtil.i("MyGesture", "Fling left");
							Intent intent = new Intent(NearMsgActivity.this,
									PersonalRecordsActivity.class);
							startActivity(intent);
						} else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
								&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
							// Fling right
							LogUtil.i("MyGesture", "Fling right");

						}
						return true;
					}
				});
		msgListView.setAdapter(new NearMessagesAdapter(NearMsgActivity.this,
				R.layout.near_message_item, msgList));
	}

	private void initView() {
		back = (Button) this.findViewById(R.id.near_msg_back);
		msgListView = (ListView) this.findViewById(R.id.near_msg_listview);
	}

	public void back(View view) {
		finish();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}

	// 手势触摸转发事件
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		gestureDetector.onTouchEvent(ev);
		return super.dispatchTouchEvent(ev);
	}

	private void initNearMessages() {
		msgList = new ArrayList<NearMessage>();
		NearMessage nm1 = new NearMessage("zhangsan", getResources()
				.getDrawable(R.drawable.test), 0, "tianchen", "2min",
				"no zuo no die", "2km");
		NearMessage nm2 = new NearMessage("lisi", getResources().getDrawable(
				R.drawable.test), 1, "shizi", "6min", "why you try", "1.8km");
		NearMessage nm3 = new NearMessage("wangwu", getResources().getDrawable(
				R.drawable.test), 0, "baiyang", "18min", "you zuo you die",
				"3.6km");
		NearMessage nm4 = new NearMessage("zhangmazi", getResources()
				.getDrawable(R.drawable.test), 1, "baiyang", "40min",
				"don't ask why", "3.8km");
		msgList.add(nm1);
		msgList.add(nm2);
		msgList.add(nm3);
		msgList.add(nm4);
	}
}
