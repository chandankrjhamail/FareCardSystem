package org.farecardsystem.payment;

import java.math.BigDecimal;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String expiredDate;

    public CreditCardPaymentStrategy(String name, String cardNumber, String cvv, String expiredDate){
        this.name=name;
        this.cardNumber=cardNumber;
        this.cvv=cvv;
        this.expiredDate=expiredDate;
    }
    @Override
    public void pay(BigDecimal amount) {
        System.out.println(amount.doubleValue() +" paid with credit card strategy");
    }
}
