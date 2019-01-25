package DesignPattern.Factory;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/25 16:00
 */
public class PieChart implements Chart {
    public PieChart()
    {
        System.out.println("Create Pie Chart");
    }
    @Override
    public void display() {
        System.out.println( "Pie Chart display");
    }
}
