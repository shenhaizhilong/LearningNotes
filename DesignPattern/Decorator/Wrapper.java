package DesignPattern;


public class Wrapper implements ITarget {

    private Source source;

    public Wrapper(Source source)
    {
        super();
        this.source = source;
    }

    @Override
    public void method2() {
        System.out.println("this is the target method");
    }

    @Override
    public void method1() {
        source.method1();
    }
}
