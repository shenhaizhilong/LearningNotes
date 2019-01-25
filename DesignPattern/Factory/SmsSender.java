package DesignPattern.Factory;

public class SmsSender  implements ISender{

    @Override
    public void send() {
        System.out.println("Sms Sender");
    }
}
