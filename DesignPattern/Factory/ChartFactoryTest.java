package DesignPattern.Factory;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/25 16:07
 */
public class ChartFactoryTest {

    public static void main(String[] args) {

        Chart chart = null;
        for(ChartType type : ChartType.values())
        {
            chart = ChartFactory.getChart(type);
            chart.display();
        }
    }
}
