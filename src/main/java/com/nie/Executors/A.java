/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.Executors;

/**
 * A
 *
 * @author zhaochengye
 * @Date 2019/9/23
 */
public class A {
    private String name;
    private String country;

    public A(String name, String country) {
        this.name = name;
        this.country = country;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * 设置
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}