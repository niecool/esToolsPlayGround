/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.jersyDemo.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.nie.guiceDemo.BillingService;
import com.nie.guiceDemo.impl.BillingServiceImpl;
import com.nie.jersyDemo.resource.DemoResource;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 * BindMoudle
 *
 * @author zhaochengye
 * @Date 2019/9/5
 */
public class BindModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ServletModule() {
            @Override
            protected void configureServlets() {

                bind(BillingService.class).to(BillingServiceImpl.class);
                bind(DemoResource.class);

                // 集成jersey访问
                bind(GuiceContainer.class);

                // 集成jackson json格式转换
                bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);
                //项目访问路径配置
                serve("/*").with(GuiceContainer.class);

            }
        });

    }

}