package Pokemon;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PokeScatter extends JFrame {

	public PokeScatter(String title, ArrayList<Pokemon> poke) {
		super();

		XYDataset dataset = createDataset(poke);

		// Create chart
		JFreeChart chart = ChartFactory.createScatterPlot("Pokemon", "hp", "atk", dataset);


		//Changes background color
		XYPlot plot = (XYPlot)chart.getPlot();
		plot.setBackgroundPaint(new Color(255,228,196));


		// Create Panel
		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}

	public XYDataset createDataset(ArrayList<Pokemon> poke) {
		XYSeriesCollection dataset = new XYSeriesCollection();

		
		XYSeries pokemon = new XYSeries("Pokemon");
		for(int x = 0; x < poke.size(); x ++) {
			pokemon.add(poke.get(x).hp, poke.get(x).atk);
		}/*
		XYSeries pokemn = new XYSeries("Pokemn");
		for(int x = 0; x < poke.size(); x ++) {
			pokemn.add(poke.get(x).hp, poke.get(x).def);
		}
		XYSeries pokemon = new XYSeries("Pokemon");
		for(int x = 0; x < poke.size(); x ++) {
			pokemon.add(poke.get(x).speed, poke.get(x).atk);
		}*/

		dataset.addSeries(pokemon);
		return dataset;
	}
}