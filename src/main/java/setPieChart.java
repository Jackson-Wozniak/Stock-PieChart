import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class setPieChart extends JPanel {

    private final ArrayList<Double> values;
    private final ArrayList<String> names;

    public setPieChart(ArrayList<Double> values, ArrayList<String> names){
        this.names = names;
        this.values = values;
        createChart();
    }

    public void createChart(){
        PieDataset<?> dataset = createData();
        JFreeChart chart = pieChart(dataset);
        chart.setBackgroundPaint(new Color(214,217,223));
        chart.getPlot().setBackgroundPaint(new Color(214,217,223));
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.black);
        chartPanel.setPreferredSize(new Dimension(510,300));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.add(chartPanel);
    }

    public PieDataset<?> createData(){
        DefaultPieDataset<String> pieData = new DefaultPieDataset<>();
        for(int i = 0; i < names.size(); i++){
            pieData.setValue(names.get(i), values.get(i));
        }
        return pieData;
    }

    public static JFreeChart pieChart(PieDataset<?> dataset){
        JFreeChart chart = ChartFactory.createPieChart(
                "Portfolio",
                dataset,
                true,
                true,
                false
        );
        final PiePlot<?> plot = (PiePlot<?>) chart.getPlot();
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}: {2}", new DecimalFormat("0.0"), new DecimalFormat("0.0%"));
        plot.setLabelGenerator(gen);
        return chart;
    }

}
