
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ScatterPlot extends JFrame {

	private static final long serialVersionUID = -2520445085124419595L;

	public ScatterPlot(String title, ArrayList<Double> x, ArrayList<Double> y) {
		super();

		XYDataset dataset = createDataset(x, y);

		// Create chart
		JFreeChart chart = ChartFactory.createScatterPlot("Linear Regression", "X", "Y", dataset);

		//Changes background color
		XYPlot plot = (XYPlot)chart.getPlot();
		
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

		// Create Panel
		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}

	public XYDataset createDataset(ArrayList<Double> xset, ArrayList<Double> yset) {
		XYSeriesCollection dataset = new XYSeriesCollection();

		XYSeries xyset = new XYSeries("X Versus Y Values");
		for(int x = 0; x < xset.size(); x ++) {
			xyset.add(xset.get(x), yset.get(x));
		}
		dataset.addSeries(xyset);
		return dataset;
	}
	
	public ScatterPlot(String title, ArrayList<Double> vals) {
		super();

		XYDataset dataset = createDataset(vals);

		// Create chart
		JFreeChart chart = ChartFactory.createScatterPlot("Cost function over time", "Time", "Cost", dataset);

		//Changes background color
		XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(Color.white);

		// Create Panel
		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}
	
	public XYDataset createDataset(ArrayList<Double> costs) {
		XYSeriesCollection dataset = new XYSeriesCollection();

		XYSeries xyset = new XYSeries("Cost");
		for(int x = 0; x < costs.size(); x ++) {
			xyset.add(x, costs.get(x));
		}
		dataset.addSeries(xyset);
		return dataset;
	}
}