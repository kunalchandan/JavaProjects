import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class LinearRegression {

	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner( new BufferedReader( new FileReader (new File("DATA/test.csv"))));
		System.out.println(in.nextLine());

		ArrayList<Double> dataX = new ArrayList<Double>();
		ArrayList<Double> dataY = new ArrayList<Double>();
		ArrayList<Double> costs = new ArrayList<Double>();

		while(in.hasNextLine()) 
		{
			double[] readLine = separate(in.nextLine());
			if(readLine.length >= 2) 
			{
				dataX.add(readLine[0]);
				dataY.add(readLine[1]);
				//for(int x = 0; x < readLine.length; x++){ System.out.println(readLine[0] + " " + readLine[1]);}
			}
		}

		double delta = 0.001;

		double slope = Math.random()*4.0 - 2.0;
		double bias = Math.random()*4.0 - 2.0;
		System.out.println(slope + " " + bias);
		System.out.println("First Cost: " + cost(dataX, dataY, slope, bias));
		for(int x = 0; x < 3001; x++) 
		{
			boolean addBias = false;
			boolean addSlope = false;
			double cCost = cost(dataX, dataY, slope, bias);
			costs.add(cCost);
			if(cCost > cost(dataX, dataY, slope, bias - delta)) {
				addBias = false;
			}
			else if(cCost > cost(dataX, dataY, slope, bias + delta)) {
				addBias = true;
			}
			if(cCost > cost(dataX, dataY, slope - delta, bias)) {
				addSlope = false;
			}
			else if(cCost > cost(dataX, dataY, slope + delta, bias)) {
				addSlope = true;
			}
			if(addBias) {
				bias += delta;
			} else {
				bias -= delta;
			}
			if(addSlope) {
				slope += delta;
			} else {
				slope -= delta;
			}
			
			if(x%1000 == 0)
				System.out.println(cost(dataX, dataY, slope, bias));
		}
		System.out.println("Final cost\n" + cost(dataX, dataY, slope, bias));
		System.out.println("Final Slope + Bias:");
		System.out.println(slope + " " + bias);

		//////// Draw that Graph
		SwingUtilities.invokeLater(() -> {
			ScatterPlot sc = new ScatterPlot("Linear Regression", dataX, dataY);
			sc.setSize(800, 400);
			sc.setLocationRelativeTo(null);
			sc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			sc.setVisible(true);
		});
		//////// Draw that Graph
		SwingUtilities.invokeLater(() -> {
			ScatterPlot sc = new ScatterPlot("Cost", costs);
			sc.setSize(800, 400);
			sc.setLocationRelativeTo(null);
			sc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			sc.setVisible(true);
		});
		in.close();
	}

	public static double[] separate(String nextLine) 
	{
		String[] array = nextLine.split(",");
		double[] line = new double[array.length];

		for(int x = 0; x < array.length; x ++) 
		{
			double banana = Double.parseDouble(array[x]);
			line[x] = banana;
		}
		return line;
	}

	public static double cost(ArrayList<Double> datax, ArrayList<Double> datay, double slope, double bias) 
	{
		double cost = 0;
		for(int x = 0; x < datax.size()-1; x++) {
			cost += Math.pow((slope * datax.get(x) + bias) - datay.get(x), 2);
		}
		return cost;
	}

}
