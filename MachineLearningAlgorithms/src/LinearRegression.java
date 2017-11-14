import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LinearRegression {

	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner( new BufferedReader( new FileReader (new File("src/test.csv"))));
		Random ran = new Random();
		System.out.println(in.nextLine());

		ArrayList<Double> dataX = new ArrayList<Double>();
		ArrayList<Double> dataY = new ArrayList<Double>();

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
		
		double delta = 0.1;

		double slope = -1;
		double bias = -1;
		System.out.println(slope + " " + bias);
		System.out.println("First Cost: " + cost(dataX, dataY, slope, bias));
		for(int x = 0; x < 10000; x++) 
		{
			double cCost = cost(dataX, dataY, slope, bias);
			if(cCost > cost(dataX, dataY, slope, bias - delta)) {
				bias-=delta;
			}
			if(cCost > cost(dataX, dataY, slope, bias + delta)) {
				bias+=delta;
			}
			if(cCost > cost(dataX, dataY, slope - delta, bias)) {
				slope-=delta;
			}
			if(cCost > cost(dataX, dataY, slope + delta, bias)) {
				slope+=delta;
			}
			if(x%1000 == 0)
				System.out.println(cost(dataX, dataY, slope, bias));
		}
		System.out.println(cost(dataX, dataY, slope, bias));

		System.out.println("Final Slope + Bias:");
		System.out.println(slope + " " + bias);

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