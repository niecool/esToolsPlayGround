/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.Executors.forkJoin;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.function.Consumer;

/**
 * PrintTask
 *
 * @author zhaochengye
 * @Date 2019/10/10
 */
public class IndexTask extends RecursiveAction {

    @Override
    protected void compute() {

    }

    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(Thread.currentThread().getName() + "[" + x);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        numbers.stream()

        ForkJoinPool forkJoinPool = new ForkJoinPool(1);
        forkJoinPool.submit(() -> numbers.parallelStream().forEach(number -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
        }));

//        ForkJoinPool forkJoinPool2 = new ForkJoinPool(6);
//        forkJoinPool2.submit(() -> {
//            numbers.parallelStream().forEach((number) -> {
//                try {
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                }
//            });
//        });

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}