import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class problem3 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("data/DATA22.txt"))));

		for(int x = 0; x < 10; x++) {
			int lowestD = 70000;
			String output = "";
			int routes = in.nextInt();
			int [][] rows = new int [routes][70];
			for (int m = 0; m < routes; m++) {
				rows[m][0] = in.nextInt();
				rows[m][1] = in.nextInt();
				for(int t = 2; t < (rows[m][1] + 2); t++) {
					rows[m][t] = in.nextInt();

				}
			}
			for(int z =0; z<routes; z++) {
				for(int p=2; p< (rows[z][1] + 2); p++) {
					if(rows[z][p] < lowestD) {
						lowestD = rows[z][p];

					}

				}

			}
			for(int z =0; z<routes; z++) {
				for(int p=2; p < (rows[z][1] + 2); p++) {
					if(rows[z][p] == lowestD) {
						output= output + rows[z][0];
						break;		
					}
				}
			}
			System.out.print(lowestD + " {");
			for(int q = 0; q < output.length(); q++) {
				if (q == 0) {
					System.out.print(output.charAt(q));
				}
				else
				{
					System.out.print(","+output.charAt(q));
				}
			}
			System.out.println("}");
		}

	}
}


