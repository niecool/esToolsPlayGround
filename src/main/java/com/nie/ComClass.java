/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie;

/**
 * ComClass
 *
 * @author zhaochengye
 * @Date 2019/9/17
 */
public class ComClass {
    private Integer id;
    private String name;

    public ComClass(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}