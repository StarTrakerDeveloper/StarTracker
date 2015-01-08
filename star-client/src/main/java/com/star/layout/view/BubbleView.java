package com.star.layout.view;

import java.util.Random;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.star.R;

/**
 * 留言板中气泡随机出现的布局
 * @ClassName: BubbleView.java 
 * @Description: 根据传入的气泡数量生产随机的气泡位置，气泡位置算法不完善，且未添加事件，应改为添加组件的方式
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:54:42
 */
public class BubbleView extends View {

	// 6颗星星的等级
	Bitmap star1, star2, star3, star4, star5, star6 ;

	// 画笔
	private final Paint mPaint = new Paint();

	// 随即生成器
	private static final Random RNG = new Random();

	// 花的位置
	private Coordinate[] flowers = new Coordinate[15];

	// 屏幕的高度和宽度
	int view_height = 0;
	int view_width = 0;

	/**
	 * 构造器
	 * 
	 * 
	 */
	public BubbleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public BubbleView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public BubbleView(Context context) {
		super(context);
	}

	/**
	 * 加载天女散花的花图片到内存中
	 * 
	 */
	public void LoadFlowerImage() {
		Resources r = this.getContext().getResources();
		star1 = ((BitmapDrawable) r.getDrawable(R.drawable.btn_wode_p))
				.getBitmap();
	}

	/**
	 * 设置当前窗体的实际高度和宽度
	 * 
	 */
	public void SetView(int height, int width) {
		view_height = height - 100;
		view_width = width - 50;

	}

	/**
	 * 随机的生成花朵的位置
	 * 
	 */
	public void addRandomFlower() {
		for(int i = 0 ; i < flowers.length ; i ++ ){
			flowers[i] = new Coordinate(RNG.nextInt(view_width),
					RNG.nextInt(view_height));
		}
	}

	/* 内嵌坐标对象 */
	private class Coordinate {
		public int x;
		public int y;

		public Coordinate(int newX, int newY) {
			x = newX;
			y = newY;
		}

		public boolean equals(Coordinate other) {
			if (x == other.x && y == other.y) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "Coordinate: [" + x + "," + y + "]";
		}
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		for (int x = 0; x < flowers.length; x += 1) {

			canvas.drawBitmap(star1, ((float) flowers[x].x),
					((float) flowers[x].y), mPaint);
		}

	}

}
