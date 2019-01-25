package DesignPattern.Factory;

public class MailSenderFactory implements IProvider {

    @Override
    public ISender produce() {
        return new MailSender();
    }
}
