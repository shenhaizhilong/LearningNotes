package DesignPattern.Adapter;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 17:43
 */
public class BlackDog implements Dog {

    @Override
    public void bark() {
        System.out.println("Black Dog wang wang");
    }
}
