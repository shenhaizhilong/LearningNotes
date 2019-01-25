package DesignPattern.Factory;

public class SmsSenderFactory implements IProvider {

    @Override
    public ISender produce() {
        return new SmsSender();
    }
}
