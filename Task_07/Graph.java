/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;
import Task_0203.Item2d;
import Task_0203.View;
import Task_0203.ViewResult;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;

/**
 * Клас `Graph` створює вікно з графіком, що відображає кількість цифр для
 * різних систем числення.
 *
 * @author Софія Жаботинська
 */
public class Graph extends JFrame {

    /**
     * Серія даних для 8-кової та 16-кової систем числення.
     */
    private final XYSeries numSeries, numSeries2;

    /**
     * Конструктор створює вікно з графіком.
     *
     * @param title Назва вікна
     */
    public Graph(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Створення набору даних
        XYSeriesCollection dataset = new XYSeriesCollection();
        numSeries = new XYSeries(" у 8-ковому числі");
        dataset.addSeries(numSeries);

        numSeries2 = new XYSeries("у 16-ковому числі");
        dataset.addSeries(numSeries2);

        // Встановлення кольорів ліній та фону графіка
        String bgColor = "#e4eda6";
        Color myColor1 = Color.decode(bgColor);

        String octColor = "#5736ba";
        Color myColor2 = Color.decode(octColor);

        String hexColor = "#2f6605";
        Color myColor3 = Color.decode(hexColor);

        // Візуалізація ліній
        StandardXYItemRenderer renderer = new StandardXYItemRenderer();
        renderer.setSeriesPaint(0, myColor2);
        renderer.setSeriesPaint(1, myColor3);

        // Створення графіка
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Графік кількості цифр у різних системах обчислення",
                "Десяткове число",
                "Кількість цифр",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        plot.setBackgroundPaint(myColor1);

        plot.setRenderer(renderer);

        // Панель для відображення графіка
        ChartPanel chartPanel = new ChartPanel(chart);
        this.add(chartPanel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Оновлює дані на графіку.
     *
     * @param view Дані для оновлення
     */
    public void updateGraph(View view) {
        numSeries.clear();
        numSeries2.clear();

        for (Item2d item : ((ViewResult) view).getItems()) {
            numSeries.add(item.getDecimalValue(), item.getOctNumber());
            numSeries2.add(item.getDecimalValue(), item.getHexNumber());
        }

        repaint();
    }

    /**
     * Додає дані до графіка (ідентично до updateGraph).
     *
     * @param view Дані для додавання
     */
    public void addData(View view) {
        for (Item2d item : ((ViewResult) view).getItems()) {
            numSeries.add(item.getDecimalValue(), item.getOctNumber());
            numSeries2.add(item.getDecimalValue(), item.getHexNumber());
        }

        repaint();
    }
}
