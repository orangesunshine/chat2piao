package com.orange.chat2piao.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GestureUnLockView extends View {
    private final int COLOR_FULL_LINE = Color.parseColor("#dfefff");
    private final int COLOR_FULL_STROKE = Color.parseColor("#147ce3");
    private final int COLOR_STROKE = Color.parseColor("#7f7f7f");

    private int mWidth;
    private int mHeight;

    private int circle_radius = 29;//小圆半径
    private int cirle_radius_alw = 67;//容差

    private int[][] unLockData = new int[3][3];

    private int horizontal_spac_circle;//水平间距
    private int vertical_spac_circle;//垂直间距

    private Map<String, Point> coordinateMap;//所有小圆点的坐标
    private PointPacking startPoint;
    private List<PointPacking> points = new ArrayList<>();

    private int moveX = -1;
    private int moveY = -1;
    private int drawX = -1;
    private int drawY = -1;

    /**
     * 显示手势轨迹
     */
    private boolean flag_show_gesture = true;

    private int paint_circle_width = 3;

    private Paint drawPointBgPaint = new Paint();
    private Paint drawPointSelectPoint = new Paint();
    private Paint drawLinePaint = new Paint();

    private OnUnLockListener listener;

    public void setListener(OnUnLockListener listener) {
        this.listener = listener;
    }

    /**
     * 设置是否显示手势轨迹
     *
     * @param flag_show_gesture
     */
    public void setFlag_show_gesture(boolean flag_show_gesture) {
        this.flag_show_gesture = flag_show_gesture;
    }

    public GestureUnLockView(Context context) {
        this(context, null);
    }

    public GestureUnLockView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GestureUnLockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        initGestureUnLockView();
        initPaint();
    }

    private void initPaint() {
        drawPointBgPaint.setAntiAlias(true);
        drawPointBgPaint.setColor(COLOR_FULL_STROKE);
        drawPointSelectPoint.setAntiAlias(true);
        drawPointSelectPoint.setColor(COLOR_FULL_LINE);
        drawLinePaint.setAntiAlias(true);
        drawLinePaint.setColor(COLOR_FULL_LINE);
        drawLinePaint.setStyle(Paint.Style.FILL);
        drawLinePaint.setStrokeWidth(5);
    }

    private void initGestureUnLockView() {
        coordinateMap = new HashMap<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        final int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        mWidth = widthSize;//控件宽
        mHeight = heightSize;//控件高
        horizontal_spac_circle = (mWidth - unLockData[0].length * circle_radius * 2
                - getPaddingLeft() - getPaddingRight() - cirle_radius_alw * 2 - paint_circle_width)
                / (unLockData[0].length - 1);//计算间距宽
        vertical_spac_circle = (mHeight - unLockData.length * circle_radius * 2
                - getPaddingTop() - getPaddingBottom() - cirle_radius_alw * 2 - paint_circle_width)
                / (unLockData.length - 1);//计算间距高
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircle(canvas);
        if (flag_show_gesture) {
            for (int i = 0; i < points.size(); i++) {
                if (i == 0) {
                    drawX = points.get(0).x;
                    drawY = points.get(0).y;
                } else {
                    canvas.drawLine(drawX, drawY, points.get(i).x, points.get(i).y, drawLinePaint);
                    drawX = points.get(i).x;
                    drawY = points.get(i).y;
                }
            }
            if (moveX != -1 && moveY != -1 && points.size() > 0) {
                canvas.drawLine(drawX, drawY, moveX, moveY, drawLinePaint);
            }
        }
    }

    /**
     * 绘制小圆点
     *
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {
        coordinateMap.clear();
        int count = 1;
        for (int i = 0; i < unLockData.length; i++) {
            for (int j = 0; j < unLockData[i].length; j++) {
                int cx = horizontal_spac_circle * j + circle_radius + (circle_radius * 2 * j) + getPaddingLeft() + cirle_radius_alw + paint_circle_width;
                int cy = vertical_spac_circle * i + circle_radius + (circle_radius * 2 * i) + getPaddingTop() + cirle_radius_alw + paint_circle_width;
                canvas.drawCircle(cx, cy, circle_radius, drawPointBgPaint);
                for (PointPacking point : points) {
                    if (cx == point.x && cy == point.y) {
                        drawPointSelectPoint.setStyle(Paint.Style.FILL);
                        drawPointSelectPoint.setShadowLayer(50, 0, 0, Color.parseColor("#aa08a3ee"));
                        canvas.drawCircle(cx, cy, circle_radius, drawPointSelectPoint);
                        drawPointSelectPoint.clearShadowLayer();

                        drawPointSelectPoint.setStyle(Paint.Style.STROKE);
                        drawPointSelectPoint.setStrokeWidth(paint_circle_width);
                        canvas.drawCircle(cx, cy, circle_radius + cirle_radius_alw, drawPointSelectPoint);
                    }
                }
                String key = String.valueOf(count);
                Point point = new Point(cx, cy);
                coordinateMap.put(key, point);
                count++;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startPoint = judgmentPosition(event.getX(), event.getY());
                if (startPoint != null) {
                    points.add(startPoint);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = (int) event.getX();
                moveY = (int) event.getY();
                PointPacking point = judgmentPosition(moveX, moveY);
                boolean flag = false;
                if (point != null) {
                    if (startPoint == null) {
                        startPoint = point;
                    }
                    if (points.size() > 0) {
                        for (PointPacking p : points) {
                            if (point.x == p.x && point.y == p.y) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            points.add(point);
                        }
                    }
                }
                postInvalidate();
                break;
            case MotionEvent.ACTION_UP:
                moveX = -1;
                moveY = -1;
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null && points.size() > 0) {
                            StringBuilder sb = new StringBuilder();
                            for (PointPacking p : points) {
                                sb.append(p.position);
                            }
                            listener.unLock(sb.toString());
                        }
                        startPoint = null;
                        points.clear();
                        postInvalidate();
                    }
                }, 300);
                postInvalidate();
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 判断点击的位置在哪个小圆点上
     *
     * @param x
     * @param y
     */
    private PointPacking judgmentPosition(float x, float y) {
        Iterator<Map.Entry<String, Point>> iterator = coordinateMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Point> next = iterator.next();
            String key = next.getKey();
            Point point = next.getValue();
            if ((point.x - circle_radius - cirle_radius_alw) < x && x < (point.x + circle_radius + cirle_radius_alw)) {
                if ((point.y - circle_radius - cirle_radius_alw) < y && y < (point.y + circle_radius + cirle_radius_alw)) {
                    return new PointPacking(key, point);
                }
            }
        }
        return null;
    }

    class PointPacking extends Point {
        String position;

        PointPacking(String key, Point point) {
            position = key;
            x = point.x;
            y = point.y;
        }
    }

    public interface OnUnLockListener {
        void unLock(String pwd);
    }
}
