package DesignPattern.Factory;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/25 15:59
 */
public class BarChart implements Chart {

    public BarChart()
    {
        System.out.println("Create Bar Chart");
    }
    @Override
    public void display() {
        System.out.println( "Bar Chart display");
    }

}
