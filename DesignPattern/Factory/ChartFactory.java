package DesignPattern.Factory;


// factory class
public class ChartFactory {

    public static Chart getChart(ChartType type)
    {
        Chart chart = null;
        if(type == ChartType.BAR)
        {
            chart = new BarChart();
        }else if(type == ChartType.PIE)
        {
            chart = new PieChart();
        }else if(type == ChartType.LINE)
        {
            chart = new LineChart();
        }
        return chart;
    }
}
