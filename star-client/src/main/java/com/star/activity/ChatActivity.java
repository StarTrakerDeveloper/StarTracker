package com.star.activity;

import java.util.ArrayList;
import java.util.List;

import com.star.R;
import com.star.adapter.MsgAdapter;
import com.star.model.Message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ChatActivity extends BaseActivity implements OnClickListener {
	private Button back, herzil, send;
	private TextView name;
	private ListView content;
	private ImageView biaoqing, add;
	private EditText message;
	private List<Message> msgList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);
		initView();
		back.setOnClickListener(this);
		biaoqing.setOnClickListener(this);
		add.setOnClickListener(this);
		herzil.setOnClickListener(this);
		send.setOnClickListener(this);
		initMsg();
		// System.out.println(msgList.size());
		MsgAdapter adapter = new MsgAdapter(ChatActivity.this,
				R.layout.chat_content_item, msgList);
		content.setAdapter(adapter);
	}

	void initView() {
		back = (Button) this.findViewById(R.id.chat_back);
		name = (TextView) this.findViewById(R.id.chat_name);
		herzil = (Button) this.findViewById(R.id.chat_herzil);
		content = (ListView) this.findViewById(R.id.chat_content);
		biaoqing = (ImageView) this.findViewById(R.id.biaoqing);
		add = (ImageView) this.findViewById(R.id.add);
		message = (EditText) this.findViewById(R.id.message);
		send = (Button) this.findViewById(R.id.send);
	}

	private void initMsg() {
		msgList = new ArrayList<Message>();
		Message msg1 = new Message(Message.TYPE_RECEIVED, "no zuo no die");
		Message msg2 = new Message(Message.TYPE_SEND, "why you try");
		// Message msg3 = new Message(Message.TYPE_RECEIVED, "you zuo you die");
		Message msg3 = new Message(
				Message.TYPE_RECEIVED,
				"遇见，乃是人生路上一道美丽的风景，不要把什么都看得那么重。人生最怕什么都想计较，却又什么都抓不牢。失去的风景，走散的人，等不来的渴望，全都住在缘分的尽头。何必太执着，该来的自然会来，会走的你怎么也留不住。");
		Message msg4 = new Message(Message.TYPE_SEND, "don't ask why");
		msgList.add(msg1);
		msgList.add(msg2);
		msgList.add(msg3);
		msgList.add(msg4);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.chat_back:
			finish();
			break;
		case R.id.biaoqing:
			Toast.makeText(this, "表情", 0).show();
			break;
		case R.id.add:
			Toast.makeText(this, "添加", 0).show();
			break;
		case R.id.chat_herzil:
			Intent intent = new Intent(this, TimeLineActivity.class);
			startActivity(intent);
			break;
		case R.id.send:
			Toast.makeText(this, "发送消息", 0).show();
			break;
		}
	}
}
