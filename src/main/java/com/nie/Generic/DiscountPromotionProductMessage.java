/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.Generic;

/**
 * DiscountPromotionProductMessage
 *
 * @author zhaochengye
 * @Date 2019/9/17
 */
public class DiscountPromotionProductMessage {

    public static <T> Long getProductSkuId2(T t){
        return 0L;
    }

    public void showKeyValue1(Generic<?> obj){
        System.out.println("泛型测试"+"key value is " + obj.getKey());
    }

    public  void test(String[] args) {

        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);

        showKeyValue1(gInteger);
    }

}