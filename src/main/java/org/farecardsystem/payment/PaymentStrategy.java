package org.farecardsystem.payment;

import java.math.BigDecimal;

public interface PaymentStrategy {

    public void pay(BigDecimal amount);
}
