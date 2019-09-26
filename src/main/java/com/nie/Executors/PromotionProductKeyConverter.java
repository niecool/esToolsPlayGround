/**
 * Copyright © 2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.Executors;


/**
 * 活动产品 key
 * Created by hukaiyang on 2019/4/29.
 */
public class PromotionProductKeyConverter {
    private PromotionProductKeyConverter() {throw new RuntimeException();}

    public static String getKey(final A param) {
        return param.getName() + "-" + param.getCountry();
    }
}
