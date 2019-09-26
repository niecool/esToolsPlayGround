/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.Executors;

import org.apache.lucene.util.NamedThreadFactory;
import org.omg.SendingContext.RunTime;

import java.util.concurrent.*;

/**
 * DefaultExecutors
 *
 * @author zhaochengye
 * @Date 2019/9/18
 */
public class DefaultExecutors {

    public static void main(String[] args) {
        //第一种方式，但是优化不够
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //第二种推荐方式,方便同学优化线程池，避免资源耗尽。
        ExecutorService executorService1 = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() * 2,
                6,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                new NamedThreadFactory("zcy1_"),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("线程不够，只有拒绝咯");
                        System.out.println(executor);
                    }
                }
        );
        System.out.println(executorService1);
        for (int i=0;i<1000;i++){
            executorService1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("====");
                }
            });
//            try {
//                future.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(executorService1);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(executorService1);
        executorService1.shutdown();

    }
}