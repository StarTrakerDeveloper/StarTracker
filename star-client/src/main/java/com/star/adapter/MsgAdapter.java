package com.star.adapter;

import java.util.List;

import com.star.R;
import com.star.activity.StarDataActivity;
import com.star.model.Message;
import com.star.utils.LogUtil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends BaseAdapter {
	private int resourceId;
	private Context context;
	private List<Message> msgList;

	public MsgAdapter(Context context, int viewResourceId, List<Message> objects) {

		// TODO Auto-generated constructor stub
		resourceId = viewResourceId;
		this.context = context;
		msgList = objects;

	}

	@Override
	public Message getItem(int position) {
		// TODO Auto-generated method stub
		return msgList.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return msgList.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Message msg = getItem(position);

		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.leftLayout = (LinearLayout) view
					.findViewById(R.id.left_layout);
			viewHolder.rightLayout = (LinearLayout) view
					.findViewById(R.id.right_layout);
			viewHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg);
			viewHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg);
			viewHolder.leftTouXiang = (ImageView) view
					.findViewById(R.id.image_left);
			viewHolder.rightTouXiang = (ImageView) view
					.findViewById(R.id.image_right);
			view.setTag(viewHolder);

		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		if (msg.getType() == 0) {
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLayout.setVisibility(View.GONE);
			viewHolder.leftMsg.setText(msg.getContent());

			viewHolder.leftTouXiang.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LogUtil.i("tttttttt", "对话处，点击了左头像");
					Intent intent = new Intent(context, StarDataActivity.class);
					context.startActivity(intent);
				}
			});
		} else if (msg.getType() == 1) {
			viewHolder.leftLayout.setVisibility(View.GONE);
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
			viewHolder.rightMsg.setText(msg.getContent());
			viewHolder.rightTouXiang.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LogUtil.i("tttttttt", "对话处，点击了右头像");
					Intent intent = new Intent(context, StarDataActivity.class);
					context.startActivity(intent);
				}
			});
		}
		return view;

	}

	class ViewHolder {
		LinearLayout leftLayout;
		LinearLayout rightLayout;
		ImageView leftTouXiang;
		ImageView rightTouXiang;
		TextView leftMsg;
		TextView rightMsg;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

}
