/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.guiceDemo;

import com.google.inject.AbstractModule;
import com.nie.guiceDemo.impl.BillingServiceImpl;

/**
 * guiceModule
 *
 * @author zhaochengye
 * @Date 2019/9/4
 */
public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(BillingService.class).to(BillingServiceImpl.class);
    }
}