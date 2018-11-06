import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class E013 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("DATA/E013.txt"))));
		ArrayList<String> unParsedNums = new ArrayList<String>();
		while(in.hasNext()) {
			unParsedNums.add(in.nextLine());
		}
		BigInteger bug = new BigInteger("0");
		for(int x = 0; x < unParsedNums.size();x++) {
			BigInteger one = new BigInteger(unParsedNums.get(x));
			bug = bug.add(one);
		}
		System.out.println(bug);
		in.close();
	}
}