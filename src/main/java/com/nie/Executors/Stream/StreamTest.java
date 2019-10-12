/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.Executors.Stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * StreamTest
 *
 * @author zhaochengye
 * @date 2019/10/12
 */
public class StreamTest {


    /**
     * @return
     * @Description https://www.jianshu.com/p/25e6174d52fd
     * @Param
     **/
    public void testSpliterator() {
        // Create an array list for doubles.
        ArrayList<Integer> al = new ArrayList<>();

        // Add values to the array list.
        al.add(1);
        al.add(2);
        al.add(-3);
        al.add(-3);
        al.add(-4);
        al.add(5);

        Stream<Integer> str1 = al.stream();
        Spliterator<Integer> splitr1 = str1.spliterator();
        System.out.println(splitr1.characteristics());
        //结合hasNext和next方法
        splitr1.tryAdvance((a) -> System.out.println(a + "!"));

        // trySplit()  将剩余元素分成两部分，取出第一部分
        Spliterator<Integer> splitr2 = splitr1.trySplit();
        splitr2.forEachRemaining((a) -> System.out.println(a));
        splitr1.forEachRemaining((a) -> System.out.println(a));
    }


}