/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.guiceDemo.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.nie.guiceDemo.BillingService;
import com.nie.guiceDemo.model.CreditCard;
import com.nie.guiceDemo.model.PizzaOrder;
import com.nie.guiceDemo.model.Receipt;

import java.util.UUID;

/**
 * BillingServiceImpl
 *
 * @author zhaochengye
 * @Date 2019/9/4
 */
@Singleton
public class BillingServiceImpl implements BillingService {

    @Inject
    public BillingServiceImpl() {
    }

    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        Receipt receipt = new Receipt();
        receipt.setId(1234L);
        receipt.setTitle(creditCard.getCreditCardNum() + "支付订单（"+ order.getId()+")"+order.getOrderAmount());
        receipt.setTotalNum(order.getOrderAmount());
        return receipt;
    }


}