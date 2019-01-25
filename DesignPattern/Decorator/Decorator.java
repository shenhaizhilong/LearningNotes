package DesignPattern;

public class Decorator implements ISourceable2 {
    private ISourceable2 sourceable2;
    public Decorator(ISourceable2  sourceable2){
        super();
        this.sourceable2 = sourceable2;
    }
    @Override
    public void method1() {
        System.out.println("before decorator");
        sourceable2.method1();
        System.out.println("after decorator");
    }
}
