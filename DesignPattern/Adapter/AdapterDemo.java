package DesignPattern.Adapter;

public class AdapterDemo {

    public static void main(String[] args) {
        ITarget adapter = new Adapter();
        adapter.method2();
        adapter.method1();
    }
}
