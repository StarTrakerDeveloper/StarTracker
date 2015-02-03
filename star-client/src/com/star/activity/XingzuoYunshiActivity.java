package com.star.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.star.R;
import com.star.utils.Util;

/**
 * 星座运势解读
 * 
 * @ClassName: XingzuoYunshiActivity.java
 * @Description: 显示星座运势内容及相关解读信息
 * @author Lee
 * @email lijunlong42@126.com
 * @date 2014-12-24 上午11:51:50
 */
public class XingzuoYunshiActivity extends BaseActivity {

	// 顶部返回按钮（图片）
	private ImageView iv_back_xingzuoyunshi_top;
	// 顶部左侧星座图标
	private ImageView iv_xingzuo_left_top;
	// 顶部右侧切换按钮（图片）
	private ImageView iv_xingzuo_change_right_top;
	// 顶部星座名称及日期
	private TextView tv_xingzuo_name_top, tv_xingzuo_date_top;
	// 星座运势信息
	private TextView tv_xingzuo_yunshi_jiankang_value,
			tv_xingzuo_yunshi_supei_value, tv_xingzuo_yunshi_yanse_value,
			tv_xingzuo_yunshi_shuzi_value;
	// 星运解读信息
	private TextView tv_xingzuo_jiedu_xingyun_value,
			tv_xingzuo_jiedu_aiqing_value, tv_xingzuo_jiedu_gongzuo_value,
			tv_xingzuo_jiedu_licai_value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xingzuo_yunshi);
		initView();
	}

	private void initView() {
		iv_back_xingzuoyunshi_top = (ImageView) findViewById(R.id.iv_back_xingzuoyunshi_top);
		iv_back_xingzuoyunshi_top.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});

		iv_xingzuo_left_top = (ImageView) findViewById(R.id.iv_xingzuo_left_top);
		iv_xingzuo_change_right_top = (ImageView) findViewById(R.id.iv_xingzuo_change_right_top);
		iv_xingzuo_change_right_top.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Util.t(getApplicationContext(), "切换星座");
			}
		});

		tv_xingzuo_name_top = (TextView) findViewById(R.id.tv_xingzuo_name_top);
		tv_xingzuo_name_top.setText("天蝎座");

		tv_xingzuo_date_top = (TextView) findViewById(R.id.tv_xingzuo_date_top);
		tv_xingzuo_date_top.setText("(10/24--11/22)");

		// 星座运势
		tv_xingzuo_yunshi_jiankang_value = (TextView) findViewById(R.id.tv_xingzuo_yunshi_jiankang_value);
		tv_xingzuo_yunshi_jiankang_value.setText("100%");

		tv_xingzuo_yunshi_supei_value = (TextView) findViewById(R.id.tv_xingzuo_yunshi_supei_value);
		tv_xingzuo_yunshi_supei_value.setText("魔蝎座");

		tv_xingzuo_yunshi_yanse_value = (TextView) findViewById(R.id.tv_xingzuo_yunshi_yanse_value);
		tv_xingzuo_yunshi_yanse_value.setText("玫瑰红");

		tv_xingzuo_yunshi_shuzi_value = (TextView) findViewById(R.id.tv_xingzuo_yunshi_shuzi_value);
		tv_xingzuo_yunshi_shuzi_value.setText("7");

		// 星运解读
		tv_xingzuo_jiedu_xingyun_value = (TextView) findViewById(R.id.tv_xingzuo_jiedu_xingyun_value);
		tv_xingzuo_jiedu_xingyun_value
				.setText("给他准备一份精美的礼物吧，小小的惊喜也能让感情生物；今天求职者的运气还不错，多到人才市场"
						+ "或者职业介绍所去看看吧；财运颇好，业务工作者因积极拓展而有机会获得超出预计的收益。");

		tv_xingzuo_jiedu_aiqing_value = (TextView) findViewById(R.id.tv_xingzuo_jiedu_aiqing_value);
		tv_xingzuo_jiedu_aiqing_value
				.setText("从来态度积极，有很好的客观判断，当然皇天不负有心人，天蝎在12月的年终里，一定有新的突破，"
						+ "一定有很不错的收获。而且天蝎不管面对什么事情，自己坚定的观点不能轻易随其他人改变哦，奇迹会因为你的坚持而出现。"
						+ "12月，天蝎社交运也蛮不错的，能接触重量级的人物，新的一年似乎也会有新的面目哦。");

		tv_xingzuo_jiedu_gongzuo_value = (TextView) findViewById(R.id.tv_xingzuo_jiedu_gongzuo_value);
		tv_xingzuo_jiedu_gongzuo_value.setText("很多事情都要你来处理，有些手忙脚乱，但多能坚持、积极应对。");

		tv_xingzuo_jiedu_licai_value = (TextView) findViewById(R.id.tv_xingzuo_jiedu_licai_value);
		tv_xingzuo_jiedu_licai_value
				.setText("在前段时间，天蝎座的运势状态有些不妥，一直处于低迷状态，让你精神不振的，"
						+ "不过最近你们的运势开始上升，会感到轻松很多，之前的问题都能够得到解决，特别是财运方面，金钱有大幅进账，财源滚滚来。");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.xingzuo_yunshi, menu);
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
}
