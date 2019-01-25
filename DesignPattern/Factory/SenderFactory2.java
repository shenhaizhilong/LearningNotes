package DesignPattern.Factory;

public class SenderFactory2 {

    public static ISender produceMail()
    {
        return new MailSender();
    }

    public static ISender produceSms()
    {
        return new SmsSender();
    }

    public static void main(String[] args) {
        ISender sender = SenderFactory2.produceMail();
        sender.send();

        sender = SenderFactory2.produceSms();
        sender.send();
    }
}
