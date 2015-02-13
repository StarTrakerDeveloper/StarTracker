package com.star.activity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.star.R;
import com.star.adapter.ImagesAdapter;
import com.star.adapter.NearMessagesAdapter;
import com.star.utils.LogUtil;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class WriteTalkActivity extends BaseActivity implements OnClickListener {
	private Spinner quanxian;
	private Button cancle, send;
	private int QUANXIAN = 0;
	private EditText content;
	private List<Bitmap> images;
	private GridView gridView;
	private Bitmap bmp;
	//
	ImagesAdapter imgAdapter;
	private Uri uri;
	static int DO_WHAT = 7, TAKE_PHOTO = 6, PICK_PICTURE = 7;
	private File outputImage;
	private File path;
	static String filename;
	static int ONCLICKED = 0;
	static int count = 1;
	final static int MAXCOUNT = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write_talk);
		initView();
		cancle.setOnClickListener(this);
		images = new ArrayList<Bitmap>();
		quanxian.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(WriteTalkActivity.this, "第" + arg2 + "个被选中", 0)
						.show();
				// PUBLIC = 0, PRIVATE = 2, ONLY_FRIEND = 1,
				QUANXIAN = arg2;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				LogUtil.i("WriteTalkActivity", "没有任何被选中");
			}
		});

		Resources r = this.getResources();
		InputStream is = r.openRawResource(R.drawable.test);
		BitmapDrawable bmpDraw = new BitmapDrawable(is);
		bmp = bmpDraw.getBitmap();
		images.add(bmp);
		imgAdapter = new ImagesAdapter(this, R.layout.write_talk_item_images,
				images);
		gridView.setAdapter(imgAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				ONCLICKED = position + 1;
				if (ONCLICKED <= MAXCOUNT) {
					openOptionsMenu();
				} else {
					Toast.makeText(WriteTalkActivity.this, "最多添加12张图片", 1)
							.show();
				}

			}
		});
	}

	void initView() {
		quanxian = (Spinner) this.findViewById(R.id.write_talk_quanxian);
		cancle = (Button) this.findViewById(R.id.write_talk_cancle);
		send = (Button) this.findViewById(R.id.write_talk_send);
		content = (EditText) this.findViewById(R.id.write_talk_content);
		gridView = (GridView) this.findViewById(R.id.write_talk_images);
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
			startActivityForResult(intent, 0);
			break;
		case R.id.takephoto:
			DO_WHAT = TAKE_PHOTO;
			Intent openCameraIntent = new Intent(
					MediaStore.ACTION_IMAGE_CAPTURE);
			openCameraIntent.addCategory(Intent.CATEGORY_DEFAULT);
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date(System.currentTimeMillis());
			filename = format.format(date);
			// 存储至DCIM文件夹
			path = Environment
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
			Uri imageUri = Uri.fromFile(outputImage);
			openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(openCameraIntent, 1);
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
		case 0:
			if (data != null) {
				uri = data.getData();
				Bitmap pic = getBitmapFromUri(uri);
				if (ONCLICKED == images.size()) {
					if (pic != null) {
						images.add(pic);
						Collections.swap(images, count - 1, images.size() - 1);
						count++;
					}
				} else {
					if (pic != null) {
						images.add(pic);
						Collections.swap(images, ONCLICKED - 1,
								images.size() - 1);
						images.remove(images.size() - 1);
					}
				}
				imgAdapter.notifyDataSetChanged();
			}

			break;

		case 1:
			if (DO_WHAT == TAKE_PHOTO) {
				Bitmap pibm = scalePicture();
				if (ONCLICKED == images.size()) {
					if (pibm != null) {
						images.add(pibm);
						Collections.swap(images, count - 1, images.size() - 1);
						count++;
					}
				} else {
					if (pibm != null) {
						images.add(pibm);
						Collections.swap(images, ONCLICKED - 1,
								images.size() - 1);
						images.remove(images.size() - 1);
					}
				}

				imgAdapter.notifyDataSetChanged();
			}
			break;

		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.write_talk_send:
			String msg = content.getText().toString().trim();
			if (TextUtils.isEmpty(msg)) {
				Toast.makeText(this, "请输入说说内容", 0).show();
			} else {
				// 数据提交到服务器，返回时间轴页面
				Toast.makeText(this, "发送成功", 0).show();
			}
			break;
		case R.id.write_talk_cancle:
			finish();
			break;
		}
	}

	public Bitmap getBitmapFromUri(Uri uri) {
		try {
			// 读取uri所在的图片
			Bitmap bitmap = MediaStore.Images.Media.getBitmap(
					this.getContentResolver(), uri);
			return bitmap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Bitmap scalePicture() {
		BitmapFactory.Options opts = new Options();
		// 不读取像素数组到内存中，仅读取图片的信息
		opts.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(path.getAbsolutePath() + "/" + filename
				+ ".jpg", opts);
		// 从Options中获取图片的分辨率
		int imageHeight = opts.outHeight;
		int imageWidth = opts.outWidth;

		// 获取Android屏幕的服务
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		// 获取屏幕的分辨率，getHeight()、getWidth已经被废弃掉了
		// 应该使用getSize()，但是这里为了向下兼容所以依然使用它们
		int windowHeight = wm.getDefaultDisplay().getHeight();
		int windowWidth = wm.getDefaultDisplay().getWidth();

		// 计算采样率
		int scaleX = imageWidth / windowWidth;
		int scaleY = imageHeight / windowHeight;
		int scale = 1;
		// 采样率依照最大的方向为准
		if (scaleX > scaleY && scaleY >= 1) {
			scale = scaleX;
		}
		if (scaleX < scaleY && scaleX >= 1) {
			scale = scaleY;
		}

		// false表示读取图片像素数组到内存中，依照设定的采样率
		opts.inJustDecodeBounds = false;
		// 采样率
		opts.inSampleSize = scale;
		Bitmap bm = BitmapFactory.decodeFile(path.getAbsolutePath() + "/"
				+ filename + ".jpg", opts);
		return bm;

	}
}
