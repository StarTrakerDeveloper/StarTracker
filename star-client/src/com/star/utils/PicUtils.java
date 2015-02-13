package com.star.utils;

import java.io.InputStream;
import java.util.ArrayList;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.provider.ContactsContract;

/**
 * 图片工具栏
 * @ClassName: PicUtils.java 
 * @Description: 生成圆角头像等
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 下午12:00:28
 */
public class PicUtils
{
	private Context context = null;
	private ArrayList<Bitmap> mBmps;

	/**
	 * 工具类构造方法
	 * @param context
	 */
	public PicUtils(Context context)
	{
		this.context = context;
	}

	/**
	 * 获取联系人头像信息
	 * @param photoId
	 * @param contactid
	 * @param defaultPhoto
	 * @return
	 */
	public Bitmap getPhoto(Long photoId, Long contactid, int defaultPhoto)
	{
		// photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
		if (photoId > 0) {
			Uri uri = ContentUris.withAppendedId(
					ContactsContract.Contacts.CONTENT_URI, contactid);
			InputStream input = ContactsContract.Contacts
					.openContactPhotoInputStream(context.getContentResolver(), uri);
			return BitmapFactory.decodeStream(input);
		} else {
			return getRoundBitmap(BitmapFactory.decodeResource(context.getResources(), defaultPhoto));
		}
	}

	/**
	 * 将给定的图片转换为圆角
	 * @param bitmap
	 * @return
	 */
	public Bitmap getRoundBitmap(Bitmap bitmap)
	{
		try
		{
			Paint paint = new Paint(); 
			paint.setAntiAlias(true); 
			Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
			Canvas canvas = new Canvas(output);
			final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
			final RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
			paint.setStrokeWidth(2);
			paint.setColor(Color.RED);
			canvas.drawARGB(0, 0, 0, 0);
			final float roundPx = 90;
			paint.setStyle(Style.FILL);
			canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
			paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
			final Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
			canvas.drawBitmap(bitmap, src, rect, paint);
			return output;
		}
		catch (Exception e)
		{
			return bitmap;
		}
	}
}
