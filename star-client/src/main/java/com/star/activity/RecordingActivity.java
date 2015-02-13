package com.star.activity;

import com.star.R;
import com.star.utils.LogUtil;

import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecordingActivity extends BaseActivity {
	private TextView tv_remainingTime;
	private ImageView iv_sound;
	private int remainTime = 60;
	private String TAG = "RecordingActivity";
	private MediaRecorder recorder;
	private boolean isTimeOut = false;
	public static int CHANGETIME = 1;
	public static int TIMEOUT = 2;
	public static int FINISH = 3;

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == CHANGETIME) {
				tv_remainingTime.setText(remainTime + "s");
			} else if (msg.what == TIMEOUT) {
				Toast.makeText(RecordingActivity.this, "时间到，录制结束!", 1).show();
				finish();
			} else if (msg.what == FINISH) {
				Toast.makeText(RecordingActivity.this, "录制成功!", 1).show();
				finish();
			}

		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voince_input);
		initView();
		tv_remainingTime.setText(remainTime + "s");
		prepareRecoder();
		iv_sound.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					recorder.start();

					new Thread(new Runnable() {

						@Override
						public void run() {
							while (!isTimeOut) {
								// TODO Auto-generated method stub
								remainTime--;
								if (remainTime <= 0) {
									isTimeOut = true;
									recorder.stop();
									recorder.release();
									// recorder = null;
									Message msg = new Message();
									msg.what = TIMEOUT;
									handler.sendMessage(msg);
									LogUtil.i(TAG, "时间到，结束录音");

								}
								// tv_remainingTime.setText(remainTime + "s");
								Message msg = new Message();
								msg.what = CHANGETIME;
								handler.sendMessage(msg);
								// System.out.println(remainTime);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}).start();

					LogUtil.i(TAG, "录音开始");
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					isTimeOut = true;
					recorder.stop();
					recorder.release();
					// recorder = null;
					Message msg = new Message();
					msg.what = FINISH;
					handler.sendMessage(msg);
					LogUtil.i(TAG, "结束录音");
				}

				return true;
			}
		});
	}

	private void initView() {
		tv_remainingTime = (TextView) this.findViewById(R.id.remainingTime);
		iv_sound = (ImageView) this.findViewById(R.id.sound_image);
	}

	// 选取外部图片
	public void pick(View view) {
		// 重新挂载sd卡
		// Intent mount = new Intent();
		// mount.setAction(Intent.ACTION_MEDIA_MOUNTED);
		// mount.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
		// sendBroadcast(mount);
		// System.out.println("sd�����¹���");
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_PICK);
		intent.setType("image/*");
		startActivityForResult(intent, 0);
	}

	private void prepareRecoder() {
		recorder = new MediaRecorder();
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		Time t = new Time();
		t.setToNow();
		int year = t.year;
		int month = t.month + 1;
		int date = t.monthDay;
		int hour = t.hour;
		int minute = t.minute;
		int second = t.second;
		recorder.setOutputFile(getFilesDir().toString() + year + month + date
				+ hour + minute + second + ".amr");
		try {
			recorder.prepare();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(RecordingActivity.this, "录制失败", 1).show();
			e.printStackTrace();
		}

	}

}
