package com.chen.app.k_line.base

import android.graphics.Canvas
import com.chen.app.k_line.BaseKChartView

/**
 * 画图的基类 根据实体来画图形
 * Created by tifezh on 2016/6/14.
 */
interface IChartDraw<T : Any> {
    /**
     * 需要滑动 物体draw方法
     *
     * @param canvas    canvas
     * @param view      k线图View
     * @param position  当前点的位置
     * @param lastPoint 上一个点
     * @param curPoint  当前点
     * @param lastX     上一个点的x坐标
     * @param curX      当前点的X坐标
     */
    fun drawTranslated(
        lastPoint: T?, curPoint: T,
        lastX: Float,
        curX: Float,
        canvas: Canvas,
        view: BaseKChartView,
        position: Int
    )

    /**
     * @param canvas
     * @param view
     * @param position 该点的位置
     * @param x        x的起始坐标
     * @param y        y的起始坐标
     */
    fun drawText(canvas: Canvas, view: BaseKChartView,
        position: Int,
        x: Float,
        y: Float
    )

    /**
     * 获取当前实体中最大的值
     *
     * @param point
     * @return
     */
    fun getMaxValue(point: T): Float

    /**
     * 获取当前实体中最小的值
     *
     * @param point
     * @return
     */
    fun getMinValue(point: T): Float

    /**
     * 获取value格式化器
     */
    val valueFormatter: IValueFormatter?
}