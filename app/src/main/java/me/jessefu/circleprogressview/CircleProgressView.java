package me.jessefu.circleprogressview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * author: Jesse Fu
 * date: 2020/11/10 20:50
 * description: 圆形进度条View
 */
public class CircleProgressView extends View {

    private Paint mPaint;
    float radius = Utils.dpToPixel(80);

    public CircleProgressView(Context context) {
        super(context);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(Utils.dpToPixel(15));

        float centerX = getWidth()/2;
        float centerY = getHeight()/2;

        RectF rectF = new RectF();

        rectF.set(centerX - radius,
                centerY - radius,
                centerX + radius,
                centerY + radius);
        canvas.drawArc(rectF, 135, 180, false, mPaint);
    }
}
