import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DegreeNRegression {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Scanner in = new Scanner( new BufferedReader( new FileReader (new File("DATA/test.csv"))));
		in.nextLine();
		ArrayList<Double> dataX = new ArrayList<Double>();
		ArrayList<Double> dataY = new ArrayList<Double>();

		while(in.hasNextLine()) 
		{
			double[] readLine = separate(in.nextLine());
			if(readLine.length >= 2) 
			{
				dataX.add(readLine[0]);
				dataY.add(readLine[1]);
			}
		}
		in.close();
		for(int u = 1; u < 10; u++)
		{
			// Init Weights
			System.out.print("\n\nDegree:" + u + " Polynomial");
			double[] weights = new double[u];
			for(int x = 0; x < weights.length; x++)
			{
				weights[x] = -1;
			}
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			double h = .05;
			double delta = 0.005;
			for(int x = 0; x < 10001; x++) 
				
			{
				double cCost = cost(dataX, dataY, weights);
				for(int y = 0; y < weights.length; y++)
				{
					/** I can't manage to create a variable delta; but heres the code;
					 * the only thing I'm failing to do is prevent the walker from moving climbing out of the curve.
					 * TODO: Instead of updating 1 by 1; I need to update all of them together.
					double[] tempW = Arrays.copyOf(weights, weights.length);
					tempW[y] += h;
	
					double aroc = Math.pow(Math.abs(cost(dataX, dataY, tempW) - cost(dataX, dataY, weights)), (.5))*h;
					if(cost(dataX, dataY, tempW) > cost(dataX, dataY, weights))
						weights[y] += aroc;
					else
						weights[y] -= aroc;
					if(x%1000 == 0)
					{
						System.out.println(graph(cost(dataX, dataY, weights)));
						System.out.println(aroc);
					}*/
					/** This was for a fixed delta
					 */
					weights[y]-= delta;
					if(cCost > cost(dataX, dataY, weights)) 
					{
						continue;
					}
					else
					{
						weights[y]+= 2*delta;
						if (cCost > cost(dataX, dataY, weights))
						{
							continue;
						}
						else
						{
							weights[y]-= delta;
						}
					}
				}
			}
			System.out.println("\nFinal Cost:\n" + graph(cost(dataX, dataY, weights)) + "\n" + cost(dataX, dataY, weights));
			System.out.println("Final weights:");
			for(int x = 0; x < weights.length; x++)
			{
				System.out.print(weights[x] + "x^" + x + " + ");
			}
		}
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

	public static double cost(ArrayList<Double> datax, ArrayList<Double> datay, double[] weights) 
	{
		double cost = 0;
		double tempPos;
		for(int x = 0; x < datax.size()-1; x++) {
			tempPos = 0;
			for(int y = 0; y < weights.length; y++) {
				tempPos += weights[y] * Math.pow(datax.get(x), y);
			}
			cost += Math.pow(tempPos - datay.get(x), 2);
		}
		return cost;
	}
	
	public static String graph(double x) {
		String g = "";
		if(x < 0)
			g = "+";
		x = Math.abs(x);
		while(x > 1) {
			g+="-";
			x/=10;
		}
		return g + g.length();
	}
}
