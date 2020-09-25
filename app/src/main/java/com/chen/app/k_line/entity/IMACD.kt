package com.chen.app.k_line.entity

/**
 * MACD指标(指数平滑移动平均线)接口
 * @see [](https://baike.baidu.com/item/MACD指标)相关说明
 * Created by tifezh on 2016/6/10.
 */
interface IMACD {
    /**
     * DEA值
     */
    val dea: Float

    /**
     * DIF值
     */
    val dif: Float

    /**
     * MACD值
     */
    val macd: Float
}