package DesignPattern;

public class ChartDisplay extends AbstractChart {

    private AbstractChart chart;

    public void setChart(AbstractChart chart) {
        this.chart = chart;
    }

    @Override
    public void display() {
        chart.display();
    }
}
