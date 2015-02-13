package com.star.adapter;

import java.util.List;
import com.star.R;
import com.star.model.User;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserResultAdapter extends BaseAdapter {
	private int resourceId;
	private List<User> users;
	private Context context;

	public UserResultAdapter(Context context, int viewResourceId,
			List<User> objects) {
		resourceId = viewResourceId;
		users = objects;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return users.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return users.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		User user = (User) getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.touxiang = (ImageView) view
					.findViewById(R.id.search_result_item_touxiang);
			viewHolder.name = (TextView) view
					.findViewById(R.id.search_result_item_name);
			viewHolder.sex = (ImageView) view
					.findViewById(R.id.search_result_item_sexImg);
			viewHolder.xingzuo = (ImageView) view
					.findViewById(R.id.search_result_item_xingzuoImg);
			viewHolder.signature = (TextView) view
					.findViewById(R.id.search_result_item_signature);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.touxiang.setImageDrawable(context.getResources()
				.getDrawable(user.getTouxiang()));
		viewHolder.name.setText(user.getName());
		if (user.getSex() == 0) {
			viewHolder.sex.setImageDrawable(context.getResources().getDrawable(
					R.drawable.nan));
		} else if (user.getSex() == 1) {
			viewHolder.sex.setImageDrawable(context.getResources().getDrawable(
					R.drawable.nv));
		}
		viewHolder.xingzuo.setImageResource(user.getXingzuo());
		viewHolder.signature.setText(user.getSignature());
		return view;
	}

	class ViewHolder {
		ImageView touxiang;
		TextView name;
		ImageView sex;
		ImageView xingzuo;
		TextView signature;
	}
}
