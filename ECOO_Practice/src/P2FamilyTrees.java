import java.io.*;
import java.util.*;

public class P2FamilyTrees {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner( new BufferedReader(new FileReader(new File("src/2017/DATA11.txt"))));
		//Scanner in = new Scanner(System.in);
		for(int x = 0; x < 2; x++) {
			int numberOfLines = Integer.parseInt(in.nextLine());
			for(int y = 0; y < numberOfLines; y++) {
				ArrayList<Integer> firstID = csv(in.nextLine());
				System.out.println(firstID + "Parsed ID of person \n");
			}
		}
		in.close();
	}

	public static ArrayList<Integer> csv(String stuff) {
		String[] preNums = stuff.split(".");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 0; i < preNums.length; i++) {
			System.out.println(preNums[i] + " ");
			numbers.add(Integer.parseInt(preNums[i]));
		}
		return numbers;
	}
}
