package com.star.dialog;

import com.star.dialog.effect.BaseEffects;
import com.star.dialog.effect.FadeIn;
import com.star.dialog.effect.Fall;
import com.star.dialog.effect.FlipH;
import com.star.dialog.effect.FlipV;
import com.star.dialog.effect.NewsPaper;
import com.star.dialog.effect.RotateBottom;
import com.star.dialog.effect.RotateLeft;
import com.star.dialog.effect.Shake;
import com.star.dialog.effect.SideFall;
import com.star.dialog.effect.SlideBottom;
import com.star.dialog.effect.SlideLeft;
import com.star.dialog.effect.SlideRight;
import com.star.dialog.effect.SlideTop;
import com.star.dialog.effect.Slit;

/**
 * 对话框特效
 * @ClassName: Effectstype.java 
 * @Description: 提供 14 种对话框特效
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:53:34
 */
public enum  Effectstype {

    Fadein(FadeIn.class),
    Slideleft(SlideLeft.class),
    Slidetop(SlideTop.class),
    SlideBottom(SlideBottom.class),
    Slideright(SlideRight.class),
    Fall(Fall.class),
    Newspager(NewsPaper.class),
    Fliph(FlipH.class),
    Flipv(FlipV.class),
    RotateBottom(RotateBottom.class),
    RotateLeft(RotateLeft.class),
    Slit(Slit.class),
    Shake(Shake.class),
    Sidefill(SideFall.class);
    private Class effectsClazz;

    private Effectstype(Class mclass) {
        effectsClazz = mclass;
    }

    public BaseEffects getAnimator() {
        try {
            return (BaseEffects) effectsClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
