package DesignPattern.AbstractFactory;

import DesignPattern.Factory.MailSender;

public class MailSenderFactory implements IProvider {

    @Override
    public ISender produce() {
        return new MailSender();
    }
}
