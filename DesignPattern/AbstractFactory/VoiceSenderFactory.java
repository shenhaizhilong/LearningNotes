package DesignPattern.AbstractFactory;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/26 1:20
 */
public class VoiceSenderFactory implements IProvider {

    @Override
    public ISender produce() {
        return new VoiceSender();
    }
}
