package DesignPattern.Factory;

import DesignPattern.AbstractFactory.ISender;

public class SmsSender  implements ISender {

    @Override
    public void send() {
        System.out.println("Sms Sender");
    }
}
