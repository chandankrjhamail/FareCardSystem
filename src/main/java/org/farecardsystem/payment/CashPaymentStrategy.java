package org.farecardsystem.payment;

import java.math.BigDecimal;

public class CashPaymentStrategy implements PaymentStrategy {

    private BigDecimal amount;

    @Override
    public void pay(BigDecimal amount) {
        System.out.println(amount.doubleValue() +" paid with cash payment strategy");
    }
}
