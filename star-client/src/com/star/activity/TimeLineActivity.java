package com.star.activity;

import java.util.ArrayList;
import java.util.List;

import com.star.R;
import com.star.adapter.TimeLineAdapter;
import com.star.client.CircleImageView;
import com.star.model.TimeLine;
import com.star.utils.LogUtil;

import android.os.Bundle;
import android.widget.ListView;

public class TimeLineActivity extends BaseActivity {
	private CircleImageView touxiang;
	private ListView listView;
	private List<TimeLine> timelineData;
	private static final String TAG = "TimeLineActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timeline);
		LogUtil.i("TimeLineActivity", "create activity");
		initView();
		initTimeLineData();
		LogUtil.i(TAG, "init data finished");
		TimeLineAdapter adapter = new TimeLineAdapter(this,
				R.layout.timeline_content_item, timelineData);
		System.out.println(timelineData.size());
		listView.setAdapter(adapter);

	}

	void initView() {
		touxiang = (CircleImageView) this.findViewById(R.id.timeline_touxiang);
		LogUtil.i("TimeLineActivity", "init touxiang");
		listView = (ListView) this.findViewById(R.id.timeline_listtview);
		LogUtil.i("TimeLineActivity", "init listview");
	}

	void initTimeLineData() {
		timelineData = new ArrayList<TimeLine>();
		TimeLine tl1 = new TimeLine(getResources().getDrawable(R.drawable.kn),
				"Today", "no zuo no die");
		TimeLine tl2 = new TimeLine(getResources().getDrawable(R.drawable.kn),
				"11-09", "why you try");
		TimeLine tl3 = new TimeLine(getResources().getDrawable(R.drawable.kn),
				"11-08", "you zuo you die");
		TimeLine tl4 = new TimeLine(getResources().getDrawable(R.drawable.kn),
				"11-07", "don't ask why");
		timelineData.add(tl1);
		timelineData.add(tl2);
		timelineData.add(tl3);
		timelineData.add(tl4);
	}
}
