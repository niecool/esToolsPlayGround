/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.guiceDemo.model;

/**
 * PizzaOrder
 *
 * @author zhaochengye
 * @Date 2019/9/4
 */
public class PizzaOrder {
    private Long id;
    private double orderAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }
}