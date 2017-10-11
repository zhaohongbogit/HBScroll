package tk.zhzephi.demo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import tk.zhzephi.demo.R

/**
 * 自定义打对勾动画
 */
class HookView : View {

    val addProcess: Int = 5

    //绘制圆弧的进度值
    private var progress = 0
    //线1的x轴
    private var line1_x = 0
    //线1的y轴
    private var line1_y = 0
    //线2的x轴
    private var line2_x = 0
    //线2的y轴
    private var line2_y = 0

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
    }

    fun drawPoint(canvas: Canvas, x: Float, y: Float) {
        var paint = Paint()
        paint.color = Color.parseColor("#FF0000")
        paint.strokeWidth = 8f
        canvas.drawPoint(x, y, paint)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        drawPoint(canvas, 0f, 0f) //FIXME 画原点

        //开始绘制对勾图形
        progress += addProcess;
        /**
         * 绘制圆弧
         */
        val paint = Paint()
        //设置画笔颜色
        paint.color = ContextCompat.getColor(context, R.color.colorPrimary)
        //设置圆弧的宽度
        paint.strokeWidth = 5f
        //设置圆弧为空心
        paint.style = Paint.Style.STROKE
        //消除锯齿
        paint.isAntiAlias = true

        //获取圆心的x坐标
        val center = width / 2
        val center1 = center - width / 5

//        drawPoint(canvas, center.toFloat(), center.toFloat()) //FIXME 画中心点

        //圆弧半径
        val radius = width / 2 - 5

        //定义的圆弧的形状和大小的界限
        val rectF = RectF((center - radius - 1).toFloat(), (center - radius - 1).toFloat(), (center + radius + 1).toFloat(), (center + radius + 1).toFloat())

        //根据进度画圆弧
        canvas.drawArc(rectF, 235f, (-360 * progress / 100).toFloat(), false, paint)

        var oldx = 0f
        /**
         * 绘制对勾
         */
        //先等圆弧画完，才话对勾
        if (progress >= 100) {
            Log.d("=========", "进度为：$progress")
            if (line1_x < radius / 3) {
                line1_x += addProcess
                line1_y += addProcess
            }
            //画第一根线
            canvas.drawLine(center1.toFloat(), center.toFloat(), (center1 + line1_x).toFloat(), (center + line1_y).toFloat(), paint)

            oldx = line2_x.toFloat()

            if (line1_x == radius / 3) {
                line2_x = line1_x
                line2_y = line1_y
                line1_x += addProcess
                line1_y += addProcess
            }
            if (line1_x >= radius / 3 && line2_x <= radius) {
                line2_x += addProcess
                line2_y -= addProcess
            }
            //画第二根线
            canvas.drawLine((center1 + line1_x - 1).toFloat(), (center + line1_y).toFloat(), (center1 + line2_x).toFloat(), (center + line2_y).toFloat(), paint)
        }

        //每隔10毫秒界面刷新
        if (oldx == 0f || oldx != line2_x.toFloat()) {
            postInvalidateDelayed(10)
        }

    }
}
