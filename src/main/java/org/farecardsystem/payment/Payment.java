package org.farecardsystem.payment;

import org.farecardsystem.entity.ModeOfPayment;

import java.math.BigDecimal;

public class Payment {
    private ModeOfPayment paymentMethod;
    private PaymentStrategy paymentStrategy;

    public Payment(ModeOfPayment paymentMethod){
        this.paymentMethod=paymentMethod;
    }

    public void setModeOfPayment(ModeOfPayment paymentMethod){
        this.paymentMethod=paymentMethod;
    }

    public void pay(double amount){
        if(paymentMethod.equals(ModeOfPayment.CASH)){
            paymentStrategy = new CashPaymentStrategy();
            paymentStrategy.pay(BigDecimal.valueOf(amount));
        } else if(paymentMethod.equals(ModeOfPayment.DEBIT)){
            paymentStrategy = new DebitCardPaymentStrategy("chandan", "1234", "000", "15-12-22");
            paymentStrategy.pay(BigDecimal.valueOf(amount));
        } else if(paymentMethod.equals(ModeOfPayment.CREDIT)){
            paymentStrategy = new CreditCardPaymentStrategy("chandan", "1234", "000", "15-12-22");
            paymentStrategy.pay(BigDecimal.valueOf(amount));
        }
    }
}
