package DesignPattern.Factory;

import DesignPattern.AbstractFactory.ISender;

public class MailSender implements ISender {

    @Override
    public void send() {
        System.out.println("Mail Sender");
    }
}
