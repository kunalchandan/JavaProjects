import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class S4Taller {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("DATA11.txt"))));
		String[] strs = in.nextLine().split(" ");
		
		int[] line1 = new int[strs.length];
		
		for(int s = 0; s < strs.length; s++) {
			line1[s] = Integer.parseInt(strs[s]);
		}
		
		for(int x = 0; x < line1[0]; x++) {
			
		}
		
		
	}
}
