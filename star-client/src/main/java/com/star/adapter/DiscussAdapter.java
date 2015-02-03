package com.star.adapter;

import java.util.List;
import com.star.R;
import com.star.layout.view.CircleForImageView;
import com.star.model.Discuss;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DiscussAdapter extends BaseAdapter {
	private int resourceId;
	private Context context;
	private List<Discuss> discussList;

	public DiscussAdapter(Context context, int viewResourceId,
			List<Discuss> objects) {

		// TODO Auto-generated constructor stub
		resourceId = viewResourceId;
		this.context = context;
		discussList = objects;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return discussList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return discussList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Discuss discuss = (Discuss) getItem(position);

		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.discussTouXiang = (CircleForImageView) view
					.findViewById(R.id.discuss_touxiang);
			viewHolder.discussName = (TextView) view
					.findViewById(R.id.discuss_name);
			viewHolder.discussTime = (TextView) view
					.findViewById(R.id.discuss_time);
			viewHolder.discussContent = (TextView) view
					.findViewById(R.id.discuss_content);
			view.setTag(viewHolder);

		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.discussTouXiang.setImageResource(discuss.getTouxiang());
		viewHolder.discussName.setText(discuss.getName());
		viewHolder.discussTime.setText(discuss.getTime());
		viewHolder.discussContent.setText(discuss.getContent());
		return view;
	}

	class ViewHolder {
		CircleForImageView discussTouXiang;
		TextView discussName;
		TextView discussTime;
		TextView discussContent;
	}
}
