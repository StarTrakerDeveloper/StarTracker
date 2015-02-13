package com.star.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.star.R;
import com.star.adapter.SettingListAdapter;
import com.star.layout.view.DragLayout;
import com.star.layout.view.DragLayout.DragListener;
import com.star.main.MainActivity;
import com.star.model.Person;
import com.star.utils.Util;

/**
 * 侧滑菜单
 * 
 * @ClassName: LoginActivity.java
 * @Description: 预处理通讯录数据。可以兼容其他界面
 * @author Lee
 * @email lijunlong42@126.com
 * @date 2014-12-24 上午11:49:44
 */
public class SlipMenuActivity extends BaseActivity {

	private DragLayout dl;
	private ListView lv;
	private ImageView iv_user_photo;
	private TextView tv_setting;
	private Button btn_login = null;
	private EditText et_uname_c = null;
	private EditText et_pwd_c = null;
	private InputMethodManager inputMethodManager = null;
	/** 获取库Phon表字段 **/
	private static final String[] PHONES_PROJECTION = new String[] {
			Phone.DISPLAY_NAME, Phone.NUMBER, Photo.PHOTO_ID, Phone.CONTACT_ID };
	/** 联系人显示名称 **/
	private static final int PHONES_DISPLAY_NAME_INDEX = 0;

	/** 电话号码 **/
	private static final int PHONES_NUMBER_INDEX = 1;

	/** 头像ID **/
	private static final int PHONES_PHOTO_ID_INDEX = 2;

	/** 联系人的ID **/
	private static final int PHONES_CONTACT_ID_INDEX = 3;
	// 汉字转拼音的工具类
	private HanyuPinyinOutputFormat format;
	// 存放拼音使用的字符串数组
	private String[] pinyin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slipmenu);
		// 初始化通讯录拼音索引
		format = new HanyuPinyinOutputFormat();
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

		// 初始化策划菜单布局
		initDragLayout();
		// 初始化当前页面布局
		initView();
		et_uname_c = (EditText) findViewById(R.id.et_uname_c);
		et_pwd_c = (EditText) findViewById(R.id.et_pwd_c);
		tv_setting = (TextView) findViewById(R.id.tv_setting_bottom);
		Util.setHintContent(et_uname_c, "请输入用户名");
		Util.setHintContent(et_pwd_c, "请输入登录密码");

		// 通过监听输入框是否获得焦点，来控制输入法是否自动打开
		inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		// 控制键盘打开
		et_uname_c.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if (hasFocus) {
					// inputMethodManager.showSoftInput(et_uname_c,
					// InputMethodManager.SHOW_FORCED);
				}
			}
		});
		et_pwd_c.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if (hasFocus) {
					// inputMethodManager.showSoftInput(et_pwd_c,
					// InputMethodManager.SHOW_FORCED);
				}
			}
		});
		// 策划菜单中的设置按钮监听事件
		tv_setting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//Util.t(getApplicationContext(), "将要跳转到设置页面");
				Intent intent = new Intent(SlipMenuActivity.this, SettingActivity.class);
				startActivity(intent);
			}
		});

		// 登录按钮监听事件
		btn_login = (Button) findViewById(R.id.btn_login_c);
		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 控制键盘关闭
				inputMethodManager.hideSoftInputFromWindow(
						SlipMenuActivity.this.getCurrentFocus()
								.getWindowToken(),
						InputMethodManager.HIDE_NOT_ALWAYS);

				// 判断用户名与密码是否为空
				if (!(et_uname_c.getText() != null && !"".equals(et_uname_c
						.getText().toString().trim()))) {
					Toast.makeText(getApplicationContext(), "请输入用户名",
							Toast.LENGTH_LONG).show();
					Util.setFocusOnView(et_uname_c);
				} else if (!(et_pwd_c.getText() != null && !"".equals(et_pwd_c
						.getText().toString().trim()))) {
					Toast.makeText(getApplicationContext(), "请输入密码",
							Toast.LENGTH_LONG).show();
					Util.setFocusOnView(et_pwd_c);
				} else {
					// 如果输入了用户名和密码则跳转到 主页面
					// 在逻辑开发时，如果输入了用户名和密码，则进行验证，验证通过后跳转到星图页面
					Intent intent = new Intent(SlipMenuActivity.this,
							SearchActivity.class);
					
//					intent.putExtra("uname", et_uname_c.getText().toString());
//					intent.putExtra("pwd", et_pwd_c.getText().toString());
					startActivity(intent);
				}
			}
		});
	}

	private void initDragLayout() {
		dl = (DragLayout) findViewById(R.id.dl);
		dl.setDragListener(new DragListener() {
			@Override
			public void onOpen() {
				lv.smoothScrollToPosition(new Random().nextInt(30));
			}

			@Override
			public void onClose() {

			}

			@Override
			public void onDrag(float percent) {

			}
		});
	}

	private void initView() {
		iv_user_photo = (ImageView) findViewById(R.id.iv_user_photo);
		lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new SettingListAdapter(getApplicationContext(), getData()));
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent(SlipMenuActivity.this,
						AddressListActivity.class);
				switch (position) {
				case 0:
					startActivity(new Intent(SlipMenuActivity.this,
							BubbleActivity.class));
					break;
				case 1:
					startActivity(new Intent(SlipMenuActivity.this,
							RadarActivity.class));
					break;
				case 2:
					Util.t(getApplicationContext(), "正在加载联系人...");
					bundle.putSerializable("persons", getAddressListData());
					intent.putExtras(bundle);
					startActivity(intent);
					break;
				case 3:
					startActivity(new Intent(SlipMenuActivity.this,
							XingzuoYunshiActivity.class));
					break;
				default:
					Util.t(getApplicationContext(), "将要跳转到第 " + (position + 1)
							+ " 项");
					break;
				}
			}
		});
	}

	private List<Map<String, Object>> getData() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("icon", R.drawable.icon_fujin);
		map1.put("text", "附近消息");
		list.add(map1);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("icon", R.drawable.icon_fujinxingxing);
		map2.put("text", "附近星星");
		list.add(map2);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("icon", R.drawable.icon_tongxulu);
		map3.put("text", "通讯录");
		list.add(map3);

		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("icon", R.drawable.icon_xingzuo);
		map4.put("text", "星图");
		list.add(map4);

		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * 获取手机通讯录的人员列表
	 */
	private ArrayList<Person> getAddressListData() {
		ArrayList<Person> persons = new ArrayList<Person>();
		ContentResolver resolver = getContentResolver();
		// 获取手机联系人
		Cursor phoneCursor = resolver.query(Phone.CONTENT_URI,
				PHONES_PROJECTION, null, null, null);

		if (phoneCursor != null) {
			while (phoneCursor.moveToNext()) {
				// 得到手机号码
				String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
				// 当手机号码为空的或者为空字段 跳过当前循环
				if (TextUtils.isEmpty(phoneNumber))
					continue;

				// 得到联系人名称
				String contactName = phoneCursor
						.getString(PHONES_DISPLAY_NAME_INDEX);

				// 得到联系人ID
				Long contactid = phoneCursor.getLong(PHONES_CONTACT_ID_INDEX);

				// 得到联系人头像ID
				Long photoid = phoneCursor.getLong(PHONES_PHOTO_ID_INDEX);

				Person person = new Person();
				// 保存查询数据信息
				person.setPhoneNum(phoneNumber);
				person.setName(contactName);
				person.setId(contactid);
				person.setPinyin(getStringPinYin(contactName));
				if (photoid > 0)
					person.setPhotoId(photoid);
				else
					person.setPhotoId(-1L);
				persons.add(person);
			}
			phoneCursor.close();
		}
		return persons;
	}

	/**
	 * 字符转拼音
	 */
	public String getStringPinYin(String str)

	{
		StringBuilder sb = new StringBuilder();
		String tempPinyin = null;
		for (int i = 0; i < str.length(); ++i) {
			tempPinyin = getCharacterPinYin(str.charAt(i));
			if (tempPinyin == null) {
				sb.append(str.charAt(i));
			} else {
				sb.append(tempPinyin);
			}
		}
		return sb.toString();
	}

	public String getCharacterPinYin(char c) {
		try {
			pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		if (pinyin == null)
			return null;
		return pinyin[0];
	}

}
