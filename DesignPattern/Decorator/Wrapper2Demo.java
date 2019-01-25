package DesignPattern;

public class Wrapper2Demo {
    public static void main(String[] args) {
        SourceSub1 sub1 = new SourceSub1();
        SourceSub2 sub2 = new SourceSub2();

        sub1.method1();
        sub1.method2();
        sub2.method1();
        sub2.method2();
    }
}
