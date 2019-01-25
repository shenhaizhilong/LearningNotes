package DesignPattern.FlyWeight;

public abstract class Chessman {
    public abstract String getColor();
    public void display(Coordinates coordinates)
    {
        System.out.println("the color of chessman is: " + this.getColor() +", Coordinates are:" + coordinates.toString());
    }
}
