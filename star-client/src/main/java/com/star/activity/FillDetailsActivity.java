package com.star.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.star.R;
import com.star.client.CircleImageView;
import com.star.utils.LogUtil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FillDetailsActivity extends BaseActivity implements
		OnClickListener {
	private Button save, back, voince;
	private CircleImageView imageView1, imageView2, imageView3, addImageView;
	private EditText et_language, et_age, et_city;
	private String TAG = "FillDetailsActivity";
	private String language, age, city;
	private LinearLayout voinceLayout, bgLayout;
	private GestureDetector gestureDetector;
	private static final int LARGE_MOVE = 60;
	private Uri uri;
	static int ONCLICKED = 0;
	static int DO_WHAT = 7, TAKE_PHOTO = 6, PICK_PICTURE = 7;
	private File outputImage;
	private Uri imageUri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.another_profile_show);
		initView();
		language = et_language.getText().toString().trim();
		age = et_age.getText().toString().trim();
		city = et_city.getText().toString().trim();
		back.setOnClickListener(this);
		save.setOnClickListener(this);
		voince.setOnClickListener(this);
		voinceLayout.setOnClickListener(this);
		imageView1.setOnClickListener(this);
		imageView2.setOnClickListener(this);
		imageView3.setOnClickListener(this);
		addImageView.setOnClickListener(this);
		// 监听滑动手势，跳转下一页面
		gestureDetector = new GestureDetector(FillDetailsActivity.this,
				new SimpleOnGestureListener() {
					@Override
					public boolean onFling(MotionEvent e1, MotionEvent e2,
							float velocityX, float velocityY) {
						System.out.println("----------------滑动---------------");
						// TODO Auto-generated method stub
						final int FLING_MIN_DISTANCE = 60, FLING_MIN_VELOCITY = 120;
						if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
								&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
							// Fling left
							LogUtil.i("MyGesture", "Fling left");
							Intent intent = new Intent(
									FillDetailsActivity.this,
									SearchActivity.class);
							startActivity(intent);
						} else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
								&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
							// Fling right
							LogUtil.i("MyGesture", "Fling right");

						}
						return true;
					}
				});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}

	public void initView() {
		save = (Button) this.findViewById(R.id.profile_save);
		back = (Button) this.findViewById(R.id.profile_back);
		voince = (Button) this.findViewById(R.id.profile_voince);
		imageView1 = (CircleImageView) this.findViewById(R.id.profile_image1);
		imageView2 = (CircleImageView) this.findViewById(R.id.profile_image2);
		imageView3 = (CircleImageView) this.findViewById(R.id.profile_image3);
		addImageView = (CircleImageView) this
				.findViewById(R.id.profile_addimage);
		et_language = (EditText) this.findViewById(R.id.profile_language);
		et_age = (EditText) this.findViewById(R.id.profile_age);
		et_city = (EditText) this.findViewById(R.id.profile_city);
		voinceLayout = (LinearLayout) this
				.findViewById(R.id.profile_voince_lay);
		bgLayout = (LinearLayout) this.findViewById(R.id.profile_background);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, RecordingActivity.class);
		switch (view.getId()) {
		case R.id.profile_back:
			finish();
			break;
		case R.id.profile_save:
			Toast.makeText(this, "保存填好的信息", 1).show();
			LogUtil.i(TAG, "保存信息");
			break;
		case R.id.profile_image1:
			ONCLICKED = 1;
			openOptionsMenu();
			break;
		case R.id.profile_image2:
			ONCLICKED = 2;
			openOptionsMenu();
			break;
		case R.id.profile_image3:
			ONCLICKED = 3;
			openOptionsMenu();
			break;
		case R.id.profile_addimage:
			ONCLICKED = 4;
			openOptionsMenu();
			break;
		case R.id.profile_voince_lay:
			LogUtil.i(TAG, "录制音频");
			startActivity(intent);
			break;
		case R.id.profile_voince:
			LogUtil.i(TAG, "录制音频");
			startActivity(intent);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.takephoto_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		switch (item.getItemId()) {
		case R.id.pickphoto:
			DO_WHAT = PICK_PICTURE;
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_PICK);
			intent.setType("image/*");
			startActivityForResult(intent, ONCLICKED);
			break;
		case R.id.takephoto:
			DO_WHAT = TAKE_PHOTO;
			Intent openCameraIntent = new Intent(
					MediaStore.ACTION_IMAGE_CAPTURE);

			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date(System.currentTimeMillis());
			String filename = format.format(date);
			// 创建File对象用于存储拍照的图片 SD卡根目录
			// File outputImage = new
			// File(Environment.getExternalStorageDirectory(),"test.jpg");
			// 存储至DCIM文件夹
			File path = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
			outputImage = new File(path, filename + ".jpg");
			try {
				if (outputImage.exists()) {
					outputImage.delete();
				}
				outputImage.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 将File对象转换为Uri并启动照相程序
			imageUri = Uri.fromFile(outputImage);

			openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri); // 指定图片输出地址

			startActivityForResult(openCameraIntent, ONCLICKED);
			break;
		case R.id.cancle:
			break;

		}
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		LogUtil.i("take photo", "--------------------take photo-----------");
		switch (requestCode) {
		case 1:
			uri = data.getData();
			if (data != null && DO_WHAT == PICK_PICTURE) {

				imageView1.setImageURI(uri);
			} else if (data != null && DO_WHAT == TAKE_PHOTO) {
				// 处理图片过大的内存溢出问题
				imageView1.setImageURI(imageUri);
			}

			break;

		case 2:
			if (data != null && DO_WHAT == PICK_PICTURE) {
				uri = data.getData();
				imageView2.setImageURI(uri);
			}
			break;
		case 3:
			if (data != null && DO_WHAT == PICK_PICTURE) {
				uri = data.getData();
				imageView3.setImageURI(uri);
			}
			break;
		case 4:
			LogUtil.i("data", data.toString());
			if (data != null) {
				uri = data.getData();
				addImageView.setImageURI(uri);
			}
			break;

		}

	}
}
