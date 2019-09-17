/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Utils
 *
 * @author zhaochengye
 * @Date 2019/9/17
 */
public class Utils {
    public static void main(String[] args) {
        Map<Integer, ComClass> map = new HashMap();
        ComClass a = new ComClass(1,"赵");
        ComClass b = new ComClass(2,"钱");
        ComClass c = new ComClass(3,"孙");
        ComClass d = new ComClass(4,"李");
        map.put(1,d);
        map.put(2,a);
        map.put(3,b);
        map.put(4,c);

    }
}