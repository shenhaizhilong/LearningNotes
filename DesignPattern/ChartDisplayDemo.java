package DesignPattern;

public class ChartDisplayDemo {
    public static void main(String[] args) {

        BarChart barChart = new BarChart();
        LineChart lineChart = new LineChart();
        PieChart pieChart  = new PieChart();
        ChartDisplay chart = new ChartDisplay();
        chart.setChart(barChart);
        chart.display();
        chart.setChart(lineChart);
        chart.display();
        chart.setChart(pieChart);
        chart.display();
    }
}
