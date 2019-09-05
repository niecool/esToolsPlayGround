package com.nie;

import com.alibaba.fastjson.JSON;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nie.guiceDemo.BillingService;
import com.nie.guiceDemo.GuiceModule;
import com.nie.guiceDemo.model.CreditCard;
import com.nie.guiceDemo.model.PizzaOrder;
import com.nie.guiceDemo.model.Receipt;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        //1.guiceDemo
        System.out.println( "Hello World!" );
        Injector injector = Guice.createInjector(new GuiceModule());
        BillingService billingService = injector.getInstance(BillingService.class);
        PizzaOrder order = new PizzaOrder();
        order.setId(123L);
        order.setOrderAmount(888);
        CreditCard card = new CreditCard();
        card.setCreditCardNum("6217002870002309");
        Receipt receipt = billingService.chargeOrder(order,card);
        System.out.println(JSON.toJSON(receipt));

        //2.jersy demo

    }
}
