/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.jersyDemo.resource;

import com.alibaba.fastjson.JSON;
import com.google.inject.Inject;
import com.nie.guiceDemo.BillingService;
import com.nie.guiceDemo.model.CreditCard;
import com.nie.guiceDemo.model.PizzaOrder;
import com.nie.guiceDemo.model.Receipt;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * DemoResource
 *
 * @author zhaochengye
 * @Date 2019/9/5
 */
@Path("/receipt")
public class DemoResource {

    @Inject
    private BillingService billingService;

    /**
     * @return
     * @Description //TODO
     * @Param
     **/
    @Path("/getReceipt")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Receipt getReceipt() {
        PizzaOrder order = new PizzaOrder();
        order.setId(123L);
        order.setOrderAmount(888);
        CreditCard card = new CreditCard();
        card.setCreditCardNum("6217002870002309");
        Receipt receipt = billingService.chargeOrder(order, card);
        System.out.println(JSON.toJSON(receipt));
        return receipt;
    }
}