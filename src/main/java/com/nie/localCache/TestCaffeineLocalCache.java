/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.localCache;

import com.carrotsearch.sizeof.RamUsageEstimator;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.ConcurrentMap;

/**
 * TestLocalCache
 *
 * @author zhaochengye
 * @Date 2019/9/25
 */
public class TestCaffeineLocalCache {
    public static void main(String[] args) {
        new TestCaffeineLocalCache().test();
    }

    private void test(){
        Object graph = "haha";
        Cache<String, Object> manualCache = Caffeine.newBuilder()
                .softValues()//对所有缓存，不够全部淘汰
                .build((key -> createExpensiveGraph(key)));

        String key = "name1";
        // 根据key查询一个缓存，如果没有返回NULL
        graph = manualCache.getIfPresent(key);
        // 根据Key查询一个缓存，如果没有调用createExpensiveGraph方法，并将返回值保存到缓存。
        // 如果该方法返回Null则manualCache.get返回null，如果该方法抛出异常则manualCache.get抛出异常
        graph = manualCache.get(key, k -> createExpensiveGraph(k));
        graph = "sdfghjfddddddddddddddddddddddddddddddddddddddd" +
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
        manualCache.put(key, graph);
        // 删除一个缓存
        manualCache.invalidate(key);
        for (int i = 0; i < 1000_000; i++) {
            manualCache.put(key+i,graph);
            System.out.println(RamUsageEstimator.sizeOf(manualCache)/1024+"kb");
            System.out.println(manualCache.estimatedSize());

        }
        ConcurrentMap<String, Object> map = manualCache.asMap();
        manualCache.invalidate(key);
    }

    public String createExpensiveGraph(String k){
        return k+"a";
    }
}