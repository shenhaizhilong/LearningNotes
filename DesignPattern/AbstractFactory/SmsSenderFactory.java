package DesignPattern.AbstractFactory;

import DesignPattern.Factory.SmsSender;

public class SmsSenderFactory implements IProvider {

    @Override
    public ISender produce() {
        return new SmsSender();
    }
}
