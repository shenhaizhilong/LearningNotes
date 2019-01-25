package DesignPattern.Factory;

import DesignPattern.AbstractFactory.AbstractChart;

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
