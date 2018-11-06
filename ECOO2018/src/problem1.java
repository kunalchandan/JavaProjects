import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("data/DATA11.txt"))));
		for(int x = 0; x < 10; x++) {
			String[] line = in.nextLine().split(" ");
			int days = Integer.parseInt(line[1]);
			int adder = Integer.parseInt(line[0]);
			int catdays = 0;
			for(int y = 0; y < days; y++) {
				String box = in.nextLine();
				if(box.equals("B")) {
					catdays += adder;
				}
				catdays--;
				if(catdays < 0) {
					catdays = 0;
				}
			}
			System.out.println(catdays);
		}
	}

}
