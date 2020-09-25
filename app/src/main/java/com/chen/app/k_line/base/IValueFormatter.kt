package com.chen.app.k_line.base

/**
 * Value格式化接口
 * Created by tifezh on 2016/6/21.
 */
interface IValueFormatter {
    /**
     * 格式化value
     *
     * @param value 传入的value值
     * @return 返回字符串
     */
    fun format(value: Float): String?
}