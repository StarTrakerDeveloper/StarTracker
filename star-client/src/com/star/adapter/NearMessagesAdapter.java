package com.star.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.star.R;
import com.star.model.NearMessage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class NearMessagesAdapter extends BaseAdapter {
	private int resourceId;
	private List<NearMessage> nearMessages;
	private Context context;
	// 初始化消息中的图片组
	List<HashMap<String, Object>> data;

	public NearMessagesAdapter(Context context, int viewResourceId,
			List<NearMessage> objects) {
		resourceId = viewResourceId;
		nearMessages = objects;
		this.context = context;
		initImages();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return nearMessages.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return nearMessages.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		NearMessage nearMsg = (NearMessage) getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.touxiang = (ImageView) view
					.findViewById(R.id.image_head);
			viewHolder.name = (TextView) view.findViewById(R.id.nearMsg_name);
			viewHolder.sex = (ImageView) view.findViewById(R.id.image_sex);
			viewHolder.xingzuo = (TextView) view
					.findViewById(R.id.nearMsg_xingzuo);
			viewHolder.refreshTime = (TextView) view
					.findViewById(R.id.refresh_time);
			viewHolder.content = (TextView) view
					.findViewById(R.id.nearMsg_content);
			viewHolder.images = (GridView) view.findViewById(R.id.image_group);
			viewHolder.LBS = (TextView) view.findViewById(R.id.nearMsg_lbs);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.touxiang.setImageDrawable(nearMsg.getTouxiang());
		viewHolder.name.setText(nearMsg.getName());
		if (nearMsg.getSex() == 0) {
			viewHolder.sex.setImageDrawable(context.getResources().getDrawable(
					R.drawable.nan));
		} else if (nearMsg.getSex() == 1) {
			viewHolder.sex.setImageDrawable(context.getResources().getDrawable(
					R.drawable.nv));
		}
		viewHolder.xingzuo.setText(nearMsg.getXingzuo());
		viewHolder.refreshTime.setText(nearMsg.getRefreshTime());
		viewHolder.content.setText(nearMsg.getNearMessage());
		viewHolder.LBS.setText(nearMsg.getNearMsgLBS());

		SimpleAdapter sa = new SimpleAdapter(context, data,
				R.layout.near_message_item_images, new String[] { "image" },
				new int[] { R.id.near_message_item_images });

		viewHolder.images.setAdapter(sa);
		return view;
	}

	void initImages() {
		data = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> hm1 = new HashMap<String, Object>();
		hm1.put("image", R.drawable.test);

		HashMap<String, Object> hm2 = new HashMap<String, Object>();
		hm2.put("image", R.drawable.test);

		HashMap<String, Object> hm3 = new HashMap<String, Object>();
		hm3.put("image", R.drawable.test);

		HashMap<String, Object> hm4 = new HashMap<String, Object>();
		hm4.put("image", R.drawable.test);

		HashMap<String, Object> hm5 = new HashMap<String, Object>();
		hm5.put("image", R.drawable.test);

		data.add(hm1);
		data.add(hm2);
		data.add(hm3);
		data.add(hm4);
		data.add(hm5);
	}

	class ViewHolder {
		ImageView touxiang;
		TextView name;
		ImageView sex;
		TextView xingzuo;
		TextView refreshTime;
		TextView content;
		GridView images;
		TextView LBS;
	}

}
