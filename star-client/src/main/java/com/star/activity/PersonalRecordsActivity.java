package com.star.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.star.R;
import com.star.adapter.DiscussAdapter;
import com.star.model.Discuss;
import com.star.utils.LogUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;
import android.view.GestureDetector.SimpleOnGestureListener;

public class PersonalRecordsActivity extends BaseActivity implements
		OnClickListener {
	private Button back, send;
	private ImageView touxiang, sex, xingzuo, biaoqing, add;
	private TextView name;
	private EditText imputMessage;
	private ImageSwitcher switcher;
	// 滑动图片的资源列表,评论列表
	private List imagesList;
	private List<Discuss> discussesList;
	private int index = 0;
	private ListView discussesListView;
	private DiscussAdapter da;
	private int downX, upX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal_records);
		initView();
		initImages();
		initDiscuss();
		back.setOnClickListener(this);
		biaoqing.setOnClickListener(this);
		add.setOnClickListener(this);
		send.setOnClickListener(this);
		// 通过代码设定从左缓进，从右换出的效果
		switcher.setInAnimation(AnimationUtils.loadAnimation(
				PersonalRecordsActivity.this, android.R.anim.fade_in));
		switcher.setOutAnimation(AnimationUtils.loadAnimation(
				PersonalRecordsActivity.this, android.R.anim.fade_out));
		switcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				// makeView返回的是当前需要显示的ImageView控件，用于填充进ImageSwitcher中。
				ImageView imageView = new ImageView(
						PersonalRecordsActivity.this);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
				return imageView;
			}
		});
		switcher.setImageResource((Integer) imagesList.get(0));
		// 设置图片组的滑动事件
		switcher.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					downX = (int) event.getX();// 取得按下时的坐标
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					upX = (int) event.getX();// 取得松开时的坐标
					if (upX - downX > 100) {
						index++;
						if (index >= imagesList.size()) {
							index = 0;
						}
						switcher.setImageResource((Integer) imagesList
								.get(index));
					} else if (downX - upX > 100) {
						index--;
						if (index < 0) {
							index = imagesList.size() - 1;
						}
						switcher.setImageResource((Integer) imagesList
								.get(index));
					}
					return true;
				}
				return false;
			}
		});
		da = new DiscussAdapter(this, R.layout.personal_records_item,
				discussesList);
		discussesListView.setAdapter(da);
		discussesListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Discuss ds = discussesList.get(position);
				CharSequence text = "@" + ds.getName() + ":";
				imputMessage.setTextColor(Color.WHITE);
				imputMessage.setHint(text);
				imputMessage.setHintTextColor(Color.WHITE);
				Boolean f = imputMessage.requestFocus();
				LogUtil.i("focus", f.toString());
			}
		});
	}

	private void initDiscuss() {
		// TODO Auto-generated method stub
		discussesList = new ArrayList<Discuss>();
		Discuss ds1 = new Discuss(R.drawable.test1, "张三", "01月23日10:08",
				"佛在灵山，众人问法，佛不说话，只拿起一朵花，示之。");
		Discuss ds2 = new Discuss(R.drawable.test2, "李四", "01月23日15:24",
				"众弟子不解，唯迦叶尊者破颜微笑，只有他悟出道来了。");
		Discuss ds3 = new Discuss(R.drawable.test3, "王五", "01月24日06:25",
				"宇宙间的奥秘，不过在一朵寻常的花中，这就是佛家常说的：");
		Discuss ds4 = new Discuss(R.drawable.test4, "赵六", "01月25日17:19",
				"一花一世界，一叶一菩提！");
		discussesList.add(ds1);
		discussesList.add(ds2);
		discussesList.add(ds3);
		discussesList.add(ds4);
	}

	private void initImages() {
		// TODO Auto-generated method stub
		imagesList = new ArrayList();
		imagesList.add(R.drawable.test1);
		imagesList.add(R.drawable.test2);
		imagesList.add(R.drawable.test3);
		imagesList.add(R.drawable.test4);
		imagesList.add(R.drawable.testanother);
	}

	void initView() {
		back = (Button) this.findViewById(R.id.personal_records_back);
		touxiang = (ImageView) this
				.findViewById(R.id.personal_records_touxiang);
		name = (TextView) this.findViewById(R.id.personal_records_name);
		sex = (ImageView) this.findViewById(R.id.personal_records_sexImg);
		xingzuo = (ImageView) this
				.findViewById(R.id.personal_records_xingzuoImg);
		biaoqing = (ImageView) this.findViewById(R.id.biaoqing);
		add = (ImageView) this.findViewById(R.id.add);
		imputMessage = (EditText) this.findViewById(R.id.message);
		send = (Button) this.findViewById(R.id.send);
		switcher = (ImageSwitcher) this
				.findViewById(R.id.personale_records_imgSwitcher);
		discussesListView = (ListView) this
				.findViewById(R.id.personal_records_discusses);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.personal_records_back:
			finish();
			break;
		case R.id.biaoqing:
			Toast.makeText(this, "表情", 0).show();
			break;
		case R.id.add:
			Toast.makeText(this, "添加", 0).show();
			break;
		case R.id.send:
			// Toast.makeText(this, "发送消息", 0).show();
			Calendar now = Calendar.getInstance();
			// System.out.println("年: " + now.get(Calendar.YEAR));
			// System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");
			// System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
			// System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
			// System.out.println("分: " + now.get(Calendar.MINUTE));
			// System.out.println("秒: " + now.get(Calendar.SECOND));
			String content = imputMessage.getText().toString().trim();

			if (TextUtils.isEmpty(content)) {
				Toast.makeText(this, "请输入内容!", 0).show();
			} else {
				String currentTime = now.get(Calendar.MONTH) + 1 + "月"
						+ now.get(Calendar.DAY_OF_MONTH) + "日"
						+ now.get(Calendar.HOUR_OF_DAY) + ":"
						+ now.get(Calendar.MINUTE);
				String hint;
				try {
					hint = imputMessage.getHint().toString().trim();
				} catch (Exception e) {
					// TODO: handle exception
					LogUtil.i("PersonalRecordsActivity", "hint不存在，直接评论楼主");
					hint = "";
				}

				Discuss ds = new Discuss(R.drawable.kn, "test", currentTime,
						hint + content);
				discussesList.add(ds);
				da.notifyDataSetChanged();
				discussesListView.setSelection(discussesList.size());
				imputMessage.setText("");
				imputMessage.setHint("");
			}
			break;

		}
	}

}
