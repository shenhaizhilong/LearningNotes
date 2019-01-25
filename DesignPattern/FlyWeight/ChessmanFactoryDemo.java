package DesignPattern.FlyWeight;

public class ChessmanFactoryDemo {
    public static void main(String[] args) {
        Chessman b1, b2, b3,w1, w2;
        ChessmanFactory factory = ChessmanFactory.getFactory();
        b1 = factory.getChessman("b");
        b2 = factory.getChessman("b");
        b3 = factory.getChessman("b");
        w1 = factory.getChessman("w");
        w2 = factory.getChessman("w");
        System.out.println(b1 == b2);
        System.out.println(w1 == w2);

        b1.display(new Coordinates(1,2));
        b2.display(new Coordinates(1,3));
        b3.display(new Coordinates(2,2));
        w1.display(new Coordinates(2,3));
        w2.display(new Coordinates(3,4));

    }
}
