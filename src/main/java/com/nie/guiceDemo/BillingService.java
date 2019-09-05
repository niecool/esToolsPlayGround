/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.guiceDemo;

import com.nie.guiceDemo.model.CreditCard;
import com.nie.guiceDemo.model.PizzaOrder;
import com.nie.guiceDemo.model.Receipt;

/**
 * BillingService
 *
 * @author zhaochengye
 * @Date 2019/9/4
 */
public interface BillingService {
    /**
     * Attempts to charge the order to the credit card. Both successful and
     * failed transactions will be recorded.
     *
     * @return a receipt of the transaction. If the charge was successful, the
     *      receipt will be successful. Otherwise, the receipt will contain a
     *      decline note describing why the charge failed.
     */
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}