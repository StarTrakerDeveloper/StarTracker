package com.star.activity;

import java.util.ArrayList;
import java.util.List;

import com.star.R;
import com.star.adapter.TimeLineAdapter;
import com.star.layout.view.CircleForImageView;
import com.star.model.TimeLine;
import com.star.utils.LogUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TimeLineActivity extends BaseActivity {
	private CircleForImageView touxiang;
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
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(TimeLineActivity.this,
						PersonalRecordsActivity.class);
				startActivity(intent);
			}
		});
		System.out.println(timelineData.size());
		listView.setAdapter(adapter);

	}

	void initView() {
		touxiang = (CircleForImageView) this.findViewById(R.id.timeline_touxiang);
		LogUtil.i("TimeLineActivity", "init touxiang");
		listView = (ListView) this.findViewById(R.id.timeline_listtview);
		LogUtil.i("TimeLineActivity", "init listview");
	}

	void initTimeLineData() {
		timelineData = new ArrayList<TimeLine>();
		TimeLine tl1 = new TimeLine(getResources()
				.getDrawable(R.drawable.test1), "Today",
				"时光倏然斑驳，所有的人，所有的事，总有一段路，需要一个人走，一个人睡，一个人思索，一个人沉醉。孤独 ，不可悲。");
		TimeLine tl2 = new TimeLine(
				getResources().getDrawable(R.drawable.test2),
				"11-09",
				"很多人常说“随缘”，缘之前，其实是“愿”。不发愿，如何有缘？愿之前，其实是“诚”。心不诚，如何生愿？诚之前，其实是“勇”。没有勇气，如何迈出第一步？想都不敢想，如何有后面一切？");
		TimeLine tl3 = new TimeLine(
				getResources().getDrawable(R.drawable.test3),
				"11-08",
				"遇见，乃是人生路上一道美丽的风景，不要把什么都看得那么重。人生最怕什么都想计较，却又什么都抓不牢。失去的风景，走散的人，等不来的渴望，全都住在缘分的尽头。何必太执着，该来的自然会来，会走的你怎么也留不住。");
		TimeLine tl4 = new TimeLine(getResources()
				.getDrawable(R.drawable.test4), "11-06",
				"人的一生潮起潮落，诀窍在于要学会享受潮起，而潮落时又有足够的勇气面对。");
		TimeLine tl5 = new TimeLine(getResources()
				.getDrawable(R.drawable.test4), "11-03",
				"人的一生潮起潮落，诀窍在于要学会享受潮起，而潮落时又有足够的勇气面对。");
		timelineData.add(tl1);
		timelineData.add(tl2);
		timelineData.add(tl3);
		timelineData.add(tl4);
		timelineData.add(tl5);
	}

	// 圆形头像被点击后跳转到发说说页面
	public void writeTalk(View view) {
		// Toast.makeText(this, "写说说", 0).show();
		LogUtil.i("TimeLineActivity", "写说说");
		Intent intent = new Intent(this, WriteTalkActivity.class);
//		startActivityForResult(intent, 1);
		startActivity(intent);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (requestCode == 1 && resultCode == RESULT_OK) {
            //添加新返回的数据到时间轴中
			
		}
	}
}
