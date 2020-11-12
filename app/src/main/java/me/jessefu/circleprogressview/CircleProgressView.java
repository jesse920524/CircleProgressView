package me.jessefu.circleprogressview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author: Jesse Fu
 * date: 2020/11/10 20:50
 * description: 圆形进度条View
 */
public class CircleProgressView extends View {

    private Paint mPaint;
    private float mRadius;//半径
    private float mStartAngle;//progress起始角度
    private float mTotalProgress;//总进度 默认100 可按需配置
    private List<ProgressVO> mDatas;//数据

    public CircleProgressView(Context context) {
        super(context);
        init(context, null);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    /**设置数据*/
    public void setData(List<ProgressVO> data){
        if (mDatas.size() > 0){
            mDatas.clear();
        }

        /**将数据按照progress从大到小排序(大先绘制)*/
        Collections.sort(data);
        mDatas.addAll(data);
        invalidate();
    }

    public List<ProgressVO> getData(){
        return mDatas;
    }

    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.circle_progress_default_base_progress_color));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(Utils.dpToPixel(15));


        mRadius = Utils.dpToPixel(100);
        mStartAngle = 0;
        mTotalProgress = 100;
        mDatas = new ArrayList<>(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawProgress(canvas);
    }

    private void drawProgress(Canvas canvas) {
        float centerX = getWidth()/2;
        float centerY = getHeight()/2;

        float left = centerX - mRadius;
        float top = centerY - mRadius;
        float right = centerX + mRadius;
        float bottom = centerY + mRadius;
        RectF rectF = new RectF();
        rectF.set(left, top, right, bottom);
        /**绘制base progress*/
        canvas.drawArc(rectF, mStartAngle, 360, false, mPaint);

        for (ProgressVO item :
                mDatas) {
            mPaint.setColor(getResources().getColor(item.color));
            canvas.drawArc(rectF, mStartAngle, item.progress / mTotalProgress * 360, false, mPaint);
        }
    }

    public static class ProgressVO implements Comparable{
        int id;
        float progress;
        @ColorRes int color;

        @Override
        public int compareTo(Object o) {
            ProgressVO vo = (ProgressVO) o;

            if (vo.equals(this)) return 0;

            if (vo.progress > this.progress){
                return -1;
            }else if (vo.progress < this.progress){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
