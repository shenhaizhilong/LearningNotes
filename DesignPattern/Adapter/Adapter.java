package DesignPattern;


public class Adapter extends Source implements ITarget {

    @Override
    public void method2() {
        System.out.println("This is " + this.getClass().getName() + " method2");
    }
}
