package com.example.chapter3.homework;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;

/**
 * 如何创建自定义 View：https://developer.android.google.cn/guide/topics/ui/custom-components
 * Advanced TextView：https://chiuki.github.io/advanced-android-textview
 */
public class RainbowTextView extends AppCompatTextView {
    private float mRainbowPercent;

    public RainbowTextView(Context context) {
        super(context);
        autoPlay();
    }

    public RainbowTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        autoPlay();
    }

    public RainbowTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        autoPlay();
    }

    public void setRainbowPercent(float rainbowPercent) {
        mRainbowPercent = rainbowPercent;
        updatePaint(getWidth(), rainbowPercent);
    }

    public float getRainbowPercent() {
        return mRainbowPercent;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updatePaint(w, mRainbowPercent);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = getMySize(100, widthMeasureSpec);
//        int height = getMySize(100, heightMeasureSpec);
//
//        if (width < height) {
//            height = width;
//        } else {
//            width = height;
//        }
//
//        setMeasuredDimension(width, height);
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        //调用父View的onDraw函数，因为View这个类帮我们实现了一些
//        // 基本的而绘制功能，比如绘制背景颜色、背景图片等
//        super.onDraw(canvas);
//
////        int r = getMeasuredWidth() / 2;//也可以是getMeasuredHeight()/2,本例中我们已经将宽高设置相等了
////        //圆心的横坐标为当前的View的左边起始位置+半径
////        int centerX = getLeft() + r;
////        //圆心的纵坐标为当前的View的顶部起始位置+半径
////        int centerY = getTop() + r;
////
//        Paint paint = new Paint();
//        paint.setColor(Color.GREEN);
//        //开始绘制
//        canvas.drawText("hhh",3,3,paint);
//
//
//    }

    private void updatePaint(int w, float rainbowPercent) {
        int[] rainbow = getRainbowColors();
        Shader shader = new LinearGradient(0, 0, 0, w, rainbow,
                null, Shader.TileMode.MIRROR);
        Matrix matrix = new Matrix();
        matrix.setRotate(90);
        matrix.postTranslate(w * rainbowPercent, 0);
        shader.setLocalMatrix(matrix);
        getPaint().setShader(shader);
        invalidate();
    }

    private void autoPlay() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this,
                "rainbowPercent", 0, 100);
        animator.setDuration(60000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setEvaluator(new FloatEvaluator());
        animator.start();
    }

    private int[] getRainbowColors() {
        return new int[]{
                getResources().getColor(R.color.rainbow_red),
                getResources().getColor(R.color.rainbow_yellow),
                getResources().getColor(R.color.rainbow_green),
                getResources().getColor(R.color.rainbow_blue),
                getResources().getColor(R.color.rainbow_purple)
        };
    }

}
