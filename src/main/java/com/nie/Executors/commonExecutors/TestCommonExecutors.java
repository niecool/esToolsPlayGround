/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.Executors.commonExecutors;


import java.util.concurrent.*;

/**
 * TestCommonExecutors
 *
 * @author zhaochengye
 * @Date 2019/9/27
 */
public class TestCommonExecutors {
    private static int coreProcessorsNum = Runtime.getRuntime().availableProcessors();


    private static ExecutorService executorService = new ThreadPoolExecutor(coreProcessorsNum, coreProcessorsNum * 2, 5, TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(new SecurityManager().getThreadGroup(),r, "prefix_",1024*1024);
        }
    }, new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("我被拒绝了");
        }
    });


    public static void main(String[] args) {
//        //shutdown
//        executorService.shutdown();
//        System.out.println(executorService.isShutdown());
//        executorService.shutdownNow();
//        System.out.println(executorService.isShutdown());
//        executorService.

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        a.start();
    }
}