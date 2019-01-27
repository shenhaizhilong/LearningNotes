package DesignPattern.Adapter;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 17:44
 */
public class WhiteCat implements Cat {

    @Override
    public void miaowmiaow() {
        System.out.println("white cat miaow miaow");
    }
}
