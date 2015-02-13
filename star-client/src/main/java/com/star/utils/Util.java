package com.star.utils;

import java.io.InputStream;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/**
 * 常用工具
 * @ClassName: Util.java 
 * @Description: 提供常用、通用的相关处理方法
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 下午12:03:12
 */
public class Util {

	public static String TAG = "starTracker";
	/**
	 * 快速设置 Toast
	 * @param context
	 * @param text
	 */
	public static void t(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 打印日志
	 * @param content
	 */
	public static void log(String content){
		Log.d(TAG, content);
	}
	
	/**
	 * 修改 EditText 提示语 hint 的样式
	 * 
	 * @param editText
	 *            编辑框对象
	 * @param content
	 *            提示内容
	 * @return
	 */
	public static EditText setHintContent(EditText editText, String content) {

		SpannableString ss = new SpannableString(content);

		AbsoluteSizeSpan ass = new AbsoluteSizeSpan(18, true);

		ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		editText.setHint(new SpannedString(ss));
		return editText;
	}

	/**
	 * 设置焦点对象
	 * 
	 * @param v
	 *            获取焦点的对象
	 */
	public static void setFocusOnView(View v) {
		v.setFocusable(true);
		v.setFocusableInTouchMode(true);
		v.requestFocus();
		v.requestFocusFromTouch();
	}
	
	/**
     * 获取联系人头像
     * 
     * @param people_id
     * @return
     */
    public static Bitmap getPhoto(Context context, Long photoid, Long contactid,int defaultIco) {
    	if(photoid > 0 ) {  
            Uri uri =ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,contactid);  
            InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(context.getContentResolver(), uri);  
            return BitmapFactory.decodeStream(input);  
        }else {  
            return BitmapFactory.decodeResource(context.getResources(), defaultIco);  
        }
    }
}
