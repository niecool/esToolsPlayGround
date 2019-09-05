/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.jersyDemo.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import com.nie.guiceDemo.GuiceModule;

import java.util.ArrayList;
import java.util.List;

/**
 * MyServletContextListener
 *
 * @author zhaochengye
 * @Date 2019/9/5
 */
public class MyServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        List<Module> modules = new ArrayList<>();
        modules.add(new BindModule());
//        modules.add(new GuiceModule());
        return Guice.createInjector(modules);
    }
}