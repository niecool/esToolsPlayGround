/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.Executors.pstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * PStream
 *
 * @author zhaochengye
 * @Date 2019/9/27
 */
public class PStream {
    /**
     * @Description //TODO
     * @Param
     * @return
     **/
     public void test(){
        List<Long> ids = new ArrayList<>();
        buildList(ids);
         ExecutorService executorService = Executors.newCachedThreadPool();
//         executorService.execute();
//        ids.parallelStream().

     }

     /**
      * @Description //TODO
      * @Param
      * @return
      **/
      public void buildList(List<Long> ids){
          Random myRandom = new Random();
          for (int i = 0; i < 1000; i++) {
              ids.add((long)myRandom.nextInt(100_000_000));
          }
          System.out.println(ids.size());

      }

    public static void main(String[] args) {
        new PStream().test();
    }
}