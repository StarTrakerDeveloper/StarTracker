package com.star.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.star.R;

/**
 * 侧滑菜单适配器
 * @ClassName: SettingListAdapter.java 
 * @Description: 处理菜单项中的文字与图标混排
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:52:57
 */
public class SettingListAdapter extends BaseAdapter {
	// 上下文对象
	private Context context;
	// 人员数据源
	private List<Map<String, Object>> datas;

	/**
	 * 无参构造器
	 */
	public SettingListAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 自定义构造器
	 * @param context
	 * @param datas
	 */
	public SettingListAdapter(Context context,
			List<Map<String, Object>> datas) {
		super();
		this.context = context;
		this.datas = datas;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datas != null ? datas.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return datas != null ? datas.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Map<String, Object> map = datas.get(position);
		final ViewHolder holder;
		if(convertView == null){
	        convertView = LayoutInflater.from(context).inflate(
					R.layout.layout_slipmenu_item, null);
			holder = new ViewHolder();
			convertView.setTag(holder);
			holder.listview_tv_item = (TextView) convertView
					.findViewById(R.id.tv_lv_item_text);
	    } else {
	    	holder = (ViewHolder) convertView.getTag();
	    }
	    holder.listview_tv_item.setText(String.valueOf(map.get("text")));
	    System.out.println(Integer.valueOf(String.valueOf(map.get("icon"))) + " , " + R.drawable.icon_fujin);
	    Drawable drawable= context.getResources().getDrawable(Integer.valueOf(String.valueOf(map.get("icon"))));
	    // 这一步必须要做,否则不会显示.
	    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
	    holder.listview_tv_item.setCompoundDrawables(drawable,null,null,null);
	    return convertView;
	}
	public class ViewHolder {
		TextView listview_tv_item;
		
	}
}
