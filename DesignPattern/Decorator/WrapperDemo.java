package DesignPattern;

public class WrapperDemo {

    public static void main(String[] args) {

        Wrapper wrapper = new Wrapper(new Source());
        wrapper.method1();
        wrapper.method2();

    }
}
