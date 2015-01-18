package com.star.adapter;

import java.util.List;

import com.star.R;
import com.star.adapter.MsgAdapter.ViewHolder;
import com.star.model.Message;
import com.star.model.TimeLine;
import com.star.utils.LogUtil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TimeLineAdapter extends BaseAdapter {
	private int resourceId;
	private Context context;
	private List<TimeLine> dataList;

	public TimeLineAdapter(Context context, int viewResourceId,
			List<TimeLine> objects) {

		// TODO Auto-generated constructor stub
		resourceId = viewResourceId;
		this.context = context;
		dataList = objects;

	}

	@Override
	public TimeLine getItem(int position) {
		// TODO Auto-generated method stub
		return dataList.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TimeLine timeLine = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.leftLayout = (LinearLayout) view
					.findViewById(R.id.left_layout);
			viewHolder.rightLayout = (LinearLayout) view
					.findViewById(R.id.right_layout);
			viewHolder.leftImage = (ImageView) view
					.findViewById(R.id.left_image);
			viewHolder.leftTime = (TextView) view.findViewById(R.id.left_time);
			viewHolder.leftContent = (TextView) view
					.findViewById(R.id.left_content);
			viewHolder.rightImage = (ImageView) view
					.findViewById(R.id.right_image);
			viewHolder.rightTime = (TextView) view
					.findViewById(R.id.right_time);
			viewHolder.rightContent = (TextView) view
					.findViewById(R.id.right_content);
			view.setTag(viewHolder);

		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		LogUtil.i("timeline", "position=" + position);
		LogUtil.i("timeline", "position%2=" + position % 2);
		if (position % 2 == 0) {
			viewHolder.leftLayout.setVisibility(View.INVISIBLE);
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
			viewHolder.rightImage.setImageDrawable(timeLine.getDrawable());
			viewHolder.rightTime.setText(timeLine.getTime());
			viewHolder.rightContent.setText(timeLine.getContent());

		} else if (position % 2 != 0) {
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLayout.setVisibility(View.INVISIBLE);
			viewHolder.leftImage.setImageDrawable(timeLine.getDrawable());
			viewHolder.leftTime.setText(timeLine.getTime());
			viewHolder.leftContent.setText(timeLine.getContent());
		}
		return view;

	}

	class ViewHolder {
		LinearLayout leftLayout;
		LinearLayout rightLayout;
		ImageView leftImage;
		ImageView rightImage;
		TextView leftTime;
		TextView rightTime;
		TextView leftContent;
		TextView rightContent;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

}
