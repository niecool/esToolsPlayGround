/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.localCache;

import com.carrotsearch.sizeof.RamUsageEstimator;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * TestGuavaLocalCache
 *
 * @author zhaochengye
 * @Date 2019/9/26
 */
public class TestGuavaLocalCache {
    public static void main(String[] args) {
        new TestGuavaLocalCache().test();
    }

    private void test() {
         Cache<String,Object> localContentCache = CacheBuilder.newBuilder().softValues().build();
        Object graph = "sdfghjfddddddddddddddddddddddddddddddddddddddd" +
                "saddaaaaaaaaaasaffgjjhgfd" +
                "trtrd34535ydffvcd" +
                "edtffefdgv" +
                "etrfetg" +
                "sdgtedfggrsd" +
                "ddddddddddddddddfghjk;tytuioyuttRGRW5J" +
                "ERHTYYUYLKMT7YU" +
                "ADHNTT" +
                "EHR" +
                "ddddddddddddddddddddddddddddddddddddddddddddddddd";
        // 将一个值放入缓存，如果以前有值就覆盖以前的值
        String key = "name1";
        localContentCache.put(key, graph);
        for (int i = 0; i < 1000_000; i++) {
            localContentCache.put(key+i,graph);
            System.out.println(RamUsageEstimator.sizeOf(localContentCache)/1024+"kb");
            System.out.println(localContentCache.size());

        }
    }
}