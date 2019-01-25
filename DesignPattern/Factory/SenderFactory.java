package DesignPattern.Factory;

/**
 * Factory method
 */
public class SenderFactory {

    public ISender produce(SenderType type)
    {
        if(type == SenderType.Mail)
        {
            return new MailSender();
        }else if( type == SenderType.Sms)
        {
            return new SmsSender();
        }else {
            System.out.println("Please input the right type!");
            return null;
        }
    }

    public ISender produceMail()
    {
        return new MailSender();
    }

    public ISender produceSms()
    {
        return new SmsSender();
    }

    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        ISender sender = senderFactory.produce(SenderType.Sms);
        sender.send();

        sender = senderFactory.produce(SenderType.Mail);
        sender.send();

        sender = senderFactory.produceMail();
        sender.send();

        sender = senderFactory.produceSms();
        sender.send();
    }
}
