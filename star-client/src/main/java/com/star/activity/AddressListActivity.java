package com.star.activity;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.star.R;
import com.star.adapter.PersonListAdapter;
import com.star.layout.view.MyListview;
import com.star.layout.view.MyListview.OnRefreshListener;
import com.star.layout.view.SideBar;
import com.star.layout.view.SideBar.OnTouchingLetterChangedListener;
import com.star.model.Person;
import com.star.model.PinyinComparator;

/**
 * 通讯录内容
 * @ClassName: AddressListActivity.java 
 * @Description: 读取联系人列表，并将头像转换为圆角头像，且提供按拼音筛选功能
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:47:30
 */
public class AddressListActivity extends BaseActivity implements OnClickListener,
		OnItemClickListener {
	// 顶部的返回按钮（图片）
	private ImageView iv_back_top_left;
	// 自定义的listview
	private MyListview addresslist_listview;
	// 搜索输入框
	private EditText addresslist_search_et;
	// 首字母提示框
	private TextView addresslist_dialog;
	// A-Z字幕条
	private SideBar addresslist_sidebar;
	// 人员源数据
	private ArrayList<Person> personsSource;
	// 用户列表展现的数据
	private ArrayList<Person> persons;
	// 拼音比较器
	private PinyinComparator comparator;
	// 人员列表适配器
	private PersonListAdapter adapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address_book);
		getData();
		initView();
	}

	/**
	 * 获取数据源
	 */
	@SuppressWarnings("unchecked")
	private void getData() {
		// TODO Auto-generated method stub
		persons = new ArrayList<Person>();
		comparator = new PinyinComparator();
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		personsSource = filledData((ArrayList<Person>) bundle
				.getSerializable("persons"));
		persons.addAll(personsSource);
		Collections.sort(persons, comparator);
	}

	/**
	 * 初始化view
	 */
	private void initView() {
		// TODO Auto-generated method stub
		iv_back_top_left = (ImageView) findViewById(R.id.iv_back_tongxunlu_top);
		iv_back_top_left.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		addresslist_listview = (MyListview) findViewById(R.id.addresslist_listview);
		addresslist_search_et = (EditText) findViewById(R.id.addresslist_search_et);
		adapter = new PersonListAdapter(this, persons, false);
		addresslist_listview.setAdapter(adapter);
		addresslist_listview.setOnItemClickListener(this);
		addresslist_listview.hiddenMore();
		addresslist_listview.setonRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				addresslist_listview.onRefreshComplete("");
			}
		});
		addresslist_dialog = (TextView) findViewById(R.id.addresslist_dialog);
		addresslist_sidebar = (SideBar) findViewById(R.id.addresslist_sidebar);
		addresslist_sidebar.setTextView(addresslist_dialog);
		// 字母滑动条的触摸监听
		addresslist_sidebar
				.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {
					@Override
					public void onTouchingLetterChanged(String s) {
						int position = adapter.getPositionForSection(s
								.charAt(0));
						if (position != -1) {
							addresslist_listview.setSelection(position + 1);
						}
					}
				});
		// 输入框对内部文字变化进行监听
		addresslist_search_et.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				filterData(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}
		});
	}

	/**
	 * 控件监听方法
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		default:
			break;
		}
	}

	/**
	 * 过滤数据的方法
	 * 
	 * @param key
	 */
	private void filterData(String key) {
		// 如果内容为空字符，将数据源添加到显示数据中
		if (key.equals("")) {
			persons.clear();
			persons.addAll(personsSource);
			Collections.sort(persons, comparator);
			adapter.notifyDataSetChanged();
		}
		// 数据不为空时，按找姓名中的汉字或拼音字母进行筛选
		else {
			ArrayList<Person> list = new ArrayList<Person>();
			for (int i = 0; i < personsSource.size(); i++) {
				if (personsSource.get(i).getPinyin()
						.startsWith(key.toLowerCase())
						|| personsSource.get(i).getName().contains(key)) {
					list.add(personsSource.get(i));
				}
			}
			persons.clear();
			persons.addAll(list);
			Collections.sort(persons, comparator);
			adapter.notifyDataSetChanged();
		}
	}

	/**
	 * 数据按字母进行排序
	 * 
	 * @param list
	 * @return
	 */
	private ArrayList<Person> filledData(ArrayList<Person> list) {
		for (int i = 0; i < list.size(); i++) {
			String pinyin = list.get(i).getPinyin();
			String sortString = pinyin.substring(0, 1).toUpperCase();
			if (sortString.matches("[A-Z]")) {
				list.get(i).setSortletter(sortString.toUpperCase());
			} else {
				list.get(i).setSortletter("#");
			}
		}
		return list;
	}

	/**
	 * listview 监听
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(AddressListActivity.this,
				PersonDetailActivity.class);
		// 此处自定义的listview有headview，所以Position应该减1
		intent.putExtra("person", persons.get(position - 1));
		startActivity(intent);
	}

	/**
	 * 初始化Menu
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/**
	 * Menu中item的点击监听
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
