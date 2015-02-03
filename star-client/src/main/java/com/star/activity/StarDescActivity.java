package com.star.activity;

import com.star.R;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 
 * @Description: 星星描述
 * @author yyl
 * @date 2015-01-20 12:44
 * 
 */
public class StarDescActivity extends BaseActivity {
	private ImageView starImg;
	private TextView starOwner, starContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.star_desc);
		initView();
	}

	void initView() {
		starImg = (ImageView) this.findViewById(R.id.star_desc_starImg);
		starOwner = (TextView) this.findViewById(R.id.star_desc_starOwner);
		starContent = (TextView) this.findViewById(R.id.star_desc_content);
	}
}
