/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.jdk8.option;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Test
 *
 * @author zhaochengye
 * @date 2019/10/11
 */
public class TestOp {


    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<Long> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        Optional<Long> opt = Optional.of(null);
        Optional<Long> opt2 = Optional.ofNullable(null);

//        String result = Optional.ofNullable(null)
//  .flatMap(User::getAddress)
//  .flatMap(Address::getCountry)
//  .map(Country::getIsocode)
//  .orElse("default");
    }


}