import java.io.*;
import java.util.*;

public class meh {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("DATA11.txt"))));
		ArrayList<Integer> bananas = new ArrayList<Integer>();
		// to read each line, and add in all the integers into an ArrayList, do this
		while(in.hasNextLine()) {
			//read line
			String line = in.nextLine();
			//spliit the data into 2 parts, the name and number, and forget about the colon
			String[] data  = line.split(":");
			//parse the string to an int
			int number = Integer.parseInt(data[1]);
			//add the int into the ArrayList
			bananas.add(number);
		}
		//print out the contents of the arraylist
		System.out.println(bananas);
	}

}
