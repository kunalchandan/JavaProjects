package ecoo2017;

import java.io.*;
import java.util.*;

public class problem1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("2017/DATA10.txt")))); 
		int prices [] = {12,10,7,5};
		while(in.hasNextLine()){
			int money = in.nextInt();
			double[] percent = new double[4];

			for (int x = 0; x < 4; x++){
				percent [x]= in.nextDouble();

			}
			int students = in.nextInt();  
			int [] gradeMoney = new int[4];
			for (int x = 0; x < 4; x++){
				gradeMoney[x] = (int)(prices[x]*(percent[x]*students)); 
			}
		}
	}
}