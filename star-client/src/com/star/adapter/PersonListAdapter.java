package com.star.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.star.R;
import com.star.model.Person;
import com.star.utils.PicUtils;

/**
 * 人员列表适配器
 * @ClassName: PersonListAdapter.java 
 * @Description: 根据人员list填充相关布局信息
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:52:26
 */
public class PersonListAdapter extends BaseAdapter {
	// 上下文对象
	private Context context;
	// 人员数据源
	private ArrayList<Person> persons;
	// 选择人员的存放列表
	private ArrayList<Person> selectpersons;
	// 图片工具类
	private PicUtils utils;
	// 控制滑动条滑动的handler
	private Handler handler;

	/**
	 * 适配器构造方法
	 * 
	 * @param context
	 * @param persons
	 * @param checkmode
	 */
	public PersonListAdapter(Context context, ArrayList<Person> persons,
			boolean checkmode) {
		super();
		this.context = context;
		this.persons = persons;
		utils = new PicUtils(context);
		handler = new Handler();
		selectpersons = new ArrayList<Person>();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return persons.size();
	}

	public ArrayList<Person> getList() {
		return persons;
	}

	public ArrayList<Person> getSelectList() {
		return selectpersons;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return persons.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Person person = persons.get(position);
		final ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.layout_tongxunlu_itme, null);
			holder = new ViewHolder();
			convertView.setTag(holder);
			holder.listview_tv_catlog = (TextView) convertView
					.findViewById(R.id.listview_tv_catlog);
			holder.listview_iv_pic = (ImageView) convertView
					.findViewById(R.id.listview_iv_pic);
			holder.listview_tv_name = (TextView) convertView
					.findViewById(R.id.listview_tv_name_up);
			holder.listview_tv_remarks = (TextView) convertView
					.findViewById(R.id.listview_tv_remarks_down);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		int section = getSectionForPosition(position);
		if (position == getPositionForSection(section)) {
			holder.listview_tv_catlog.setVisibility(View.GONE);
			holder.listview_tv_catlog.setText(person.getSortletter());
		} else {
			holder.listview_tv_catlog.setVisibility(View.GONE);
		}
		holder.listview_iv_pic.setTag(person.getId());
		if (holder.listview_iv_pic.getTag() == person.getId()) {
			holder.listview_iv_pic.setImageBitmap(utils.getRoundBitmap(utils.getPhoto(person
					.getPhotoId(), person.getId(), R.drawable.btn_smail_p)));
		}
		holder.listview_tv_name.setText(person.getName());
		holder.listview_tv_remarks.setText(person.getPhoneNum());
		return convertView;
	}

	public ArrayList<Person> geList() {
		return persons;
	}

	public int getSectionForPosition(int position) {
		return persons.get(position).getSortletter().charAt(0);
	}

	public int getPositionForSection(int section) {
		for (int i = 0; i < getCount(); i++) {
			String sortStr = persons.get(i).getSortletter();
			char firstChar = sortStr.charAt(0);
			if (firstChar == section) {
				return i;
			}
		}
		return -1;
	}

	public class ViewHolder {
		TextView listview_tv_catlog;
		ImageView listview_iv_pic;
		TextView listview_tv_name;
		TextView listview_tv_remarks;
		
	}
}
