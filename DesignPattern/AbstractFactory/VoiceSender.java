package DesignPattern.AbstractFactory;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/26 1:18
 */
public class VoiceSender implements ISender {

    public VoiceSender()
    {
        System.out.println("Create Voice Sender");
    }
    @Override
    public void send() {
        System.out.println("Voice Sender send");
    }
}
