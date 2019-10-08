/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.Executors;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Test
 *
 * @author zhaochengye
 * @Date 2019/9/19
 */
public class Test {
    public static void main(String[] args) {
//        new ArrayList(null);
//        new ArrayList<String>().stream().map(x->x).collect(Collectors.toList());
//        BigDecimal a = new BigDecimal(100);
//        a.compareTo(null);
//        ArrayList a = new ArrayList<Long>();
//        a.add(1L);
//        ArrayList b = new ArrayList();
//        a.stream().map(x->b.add(x));
//        System.out.println(b);

        A a1 = new A("小明", "中国2");
        A a2 = new A("小明", "中国");
        A a3 = new A("小a", "中国2");
        List<A> l = new ArrayList<A>();
        l.add(a1);
        l.add(a2);
        l.add(a3);
//        Map<String,A> map = l.stream().collect(Collectors.toMap(PromotionProductKeyConverter::getKey, Function.identity()));
        A aa = l.stream().filter(x -> Objects.equals("中国3", x.getCountry())).findFirst().orElse(l.get(0));
                System.out.println(JSON.toJSONString(aa));


//        Executors.newWorkStealingPool()
    }
}
