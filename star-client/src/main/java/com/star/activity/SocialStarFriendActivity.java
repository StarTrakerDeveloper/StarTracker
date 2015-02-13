package com.star.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.star.R;
import com.star.layout.view.CircleLayout;
import com.star.layout.view.CircleLayout.OnItemClickListener;
import com.star.layout.view.CircleLayout.OnItemSelectedListener;
import com.star.utils.LogUtil;

public class SocialStarFriendActivity extends BaseActivityForCircleMenu
		implements OnItemSelectedListener, OnItemClickListener, OnClickListener {
	private RelativeLayout relbtn;
	private CircleLayout circleMenu;
	private TextView name;
	private ImageView resultImageView, sexImageView, chatImageView,
			careImageView, addImageView;

	@Override
	public void setView() {
		setContentView(R.layout.social_starfriend);
	}

	@Override
	public void initView() {
		circleMenu = (CircleLayout) findViewById(R.id.main_circle_layout);
		relbtn = (RelativeLayout) findViewById(R.id.relbtn);
		name = (TextView) this.findViewById(R.id.social_starfriend_name);
		resultImageView = (ImageView) this
				.findViewById(R.id.social_starfriend_result_touxiang);
		sexImageView = (ImageView) this
				.findViewById(R.id.social_starfriend_sex);
		chatImageView = (ImageView) this
				.findViewById(R.id.social_starfriend_chat);
		careImageView = (ImageView) this
				.findViewById(R.id.social_starfriend_care);
		addImageView = (ImageView) this
				.findViewById(R.id.social_starfriend_add);
	}

	@Override
	public void setListener() {
		circleMenu.setOnItemSelectedListener(this);
		circleMenu.setOnItemClickListener(this);
		relbtn.setOnClickListener(this);
		chatImageView.setOnClickListener(this);
		careImageView.setOnClickListener(this);
		addImageView.setOnClickListener(this);
	}

	@Override
	public void onItemSelected(View view, int position, long id, String name) {
		// selectedTextView.setText(name);
	}

	@Override
	public void onItemClick(View view, int position, long id, String name) {

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.relbtn:
			// Toast.makeText(getApplicationContext(), "跳转到页面14",
			// Toast.LENGTH_SHORT).show();
			LogUtil.i("SocialStarFriendActivity", "附近消息");
			Intent intent = new Intent(this, StarDataActivity.class);
			startActivity(intent);
			break;
		case R.id.social_starfriend_chat:
			// Toast.makeText(getApplicationContext(), "对话聊天",
			// Toast.LENGTH_SHORT)
			// .show();
			LogUtil.i("SocialStarFriendActivity", "对话聊天");
			Intent chatIntent = new Intent(SocialStarFriendActivity.this,
					ChatActivity.class);
			startActivity(chatIntent);
			break;
		case R.id.social_starfriend_care:
			Toast.makeText(getApplicationContext(), "特别关心", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.social_starfriend_add:
			// Toast.makeText(getApplicationContext(), "添加好友",
			// Toast.LENGTH_SHORT)
			// .show();
			LogUtil.i("SocialStarFriendActivity", "添加好友");
			String name = "张三";
			Bitmap bm = BitmapFactory.decodeResource(getResources(),
					R.drawable.kn);
			addFriend(name, bm);
			break;
		}
	}

	private void addFriend(String name, Bitmap bm) {
		// TODO Auto-generated method stub
		LinearLayout ll = (LinearLayout) getLayoutInflater().inflate(
				R.layout.add_friend_dialog, null);
		ImageView iv = (ImageView) ll
				.findViewById(R.id.add_friend_dialog_touxiang);
		TextView tv = (TextView) ll.findViewById(R.id.add_friend_dialog_name);
		final EditText et = (EditText) ll
				.findViewById(R.id.add_friend_dialog_yzxx);
		iv.setImageBitmap(bm);
		tv.setText(name);
		new AlertDialog.Builder(this)
				.setView(ll)
				.setPositiveButton("发送", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// 联网发送加好友验证请求
						Toast.makeText(SocialStarFriendActivity.this, "请求已发送",
								0).show();
						String content = et.getText().toString().trim();
						LogUtil.i("SocialStarFriendActivity", "验证信息内容为:"
								+ content);
					}

				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				}).create().show();
	}
}
