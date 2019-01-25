package DesignPattern.Factory;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/25 16:00
 */
public class LineChart implements Chart {

    public LineChart()
    {
        System.out.println("Create Line Chart");
    }
    @Override
    public void display() {
        System.out.println( "Line Chart display");
    }

}
