package DesignPattern.Factory;

public class MailSender implements ISender {

    @Override
    public void send() {
        System.out.println("Mail Sender");
    }
}
