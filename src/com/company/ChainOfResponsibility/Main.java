package com.company.ChainOfResponsibility;

class Receiver {
    private boolean bankTransfer;
    private boolean moneyTransfer;
    private boolean payPalTransfer;

    public boolean isBankTransfer() {
        return bankTransfer;
    }

    public boolean isMoneyTransfer() {
        return moneyTransfer;
    }

    public boolean isPayPalTransfer() {
        return payPalTransfer;
    }

    public void setBankTransfer(boolean bankTransfer) {
        this.bankTransfer = bankTransfer;
    }

    public void setMoneyTransfer(boolean moneyTransfer) {
        this.moneyTransfer = moneyTransfer;
    }

    public void setPayPalTransfer(boolean payPalTransfer) {
        this.payPalTransfer = payPalTransfer;
    }

    public Receiver(boolean bt, boolean mt, boolean ppt) {
        this.bankTransfer = bt;
        this.moneyTransfer = mt;
        this.payPalTransfer = ppt;
    }
}

abstract class PaymentHandler {
    public PaymentHandler successor;
    public abstract void Handle(Receiver receiver);
}

class BankPaymentHandler extends PaymentHandler {
    @Override
    public void Handle(Receiver receiver) {
        if (receiver.isBankTransfer())
            System.out.println("Выполняем банковский перевод");
        else if (successor != null)
            successor.Handle(receiver);
    }
}
class MoneyPaymentHandler extends PaymentHandler {
    @Override
    public void Handle(Receiver receiver) {
        if (receiver.isMoneyTransfer())
            System.out.println("Выполняем денежный перевод");
        else if (successor != null)
            successor.Handle(receiver);
    }
}

class PayPalPaymentHandler extends PaymentHandler {
    @Override
    public void Handle(Receiver receiver) {
        if (receiver.isPayPalTransfer())
            System.out.println("Выполняем перевод через PayPal");
        else if (successor != null)
            successor.Handle(receiver);
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        Receiver receiver = new Receiver(false, true, true);
        PaymentHandler bankPayment = new BankPaymentHandler();
        PaymentHandler moneyPayment = new MoneyPaymentHandler();
        PaymentHandler payPal = new PayPalPaymentHandler();
        bankPayment.successor = payPal;
        payPal.successor = moneyPayment;
        bankPayment.Handle(receiver);
    }
}
