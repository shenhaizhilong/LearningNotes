package DesignPattern.FlyWeight;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;

    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y +")";
    }
}
