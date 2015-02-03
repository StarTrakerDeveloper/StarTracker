package com.star.adapter;

import java.util.List;

import com.star.R;
import com.star.adapter.MsgAdapter.ViewHolder;
import com.star.model.Message;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImagesAdapter extends BaseAdapter {
	private int resourceId;
	private Context context;
	private List<Bitmap> imagesList;

	public ImagesAdapter(Context context, int viewResourceId,
			List<Bitmap> objects) {

		// TODO Auto-generated constructor stub
		resourceId = viewResourceId;
		this.context = context;
		imagesList = objects;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imagesList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return imagesList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Bitmap bm = (Bitmap) getItem(position);

		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.imageView = (ImageView) view
					.findViewById(R.id.near_message_item_images);
			view.setTag(viewHolder);

		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.imageView.setImageBitmap(bm);
		viewHolder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		return view;
	}

	class ViewHolder {
		ImageView imageView;
	}
}
