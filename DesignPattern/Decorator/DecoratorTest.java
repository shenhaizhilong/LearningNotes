package DesignPattern;

public class DecoratorTest {
    public static void main(String[] args) {
        ISourceable2 sourceable2 = new Source2();
        ISourceable2 obj = new Decorator(sourceable2);
        obj.method1();

    }
}
