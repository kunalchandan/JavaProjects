import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GoogleSitePriceSort {
	public static void main(String[] a) {
		//copy past the google site search to an excel file, and save as a csv
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<String> domains = new ArrayList<String>();
		ArrayList<Integer> price = new ArrayList<Integer>();

		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader(new File("names.csv"))));
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if(line.contains("Add to cart,")) {

				}
				else {
					lines.add(line);
				}
			}
			in.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//System.out.println(lines);


		for(int x = 0; x < lines.size(); x ++) {
			String[] temp = lines.get(x).split(",");
			for(int y = 0; y < temp.length; y++) {
				if(temp[y].length()>=2) {
					if(y == 0) {
						domains.add(temp[y]);
					}
					else if(y == 1) {
						price.add(
								Integer.parseInt(
										temp[y].substring(
												temp[y].indexOf("$") + 1, 
												temp[y].indexOf("/")
												)
										));
					}
				}
			}
		}
		//System.out.println(domains);
		//System.out.println(price);

		int maxVal = 20;
		for(int x = 0; x < price.size(); x++) {
			if(price.get(x) < maxVal) {
				System.out.println(domains.get(x) + "  " + price.get(x));
			}
		}
	}
}
