import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class E018 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("DATA/E018.txt"))));
		while(in.hasNextLine()) {
			String[] input = in.nextLine().split(" ");
			for(int x = 0;x < input.length; x ++) {
				
			}
		}
		int a = 8;
		int b = ~a;
		System.out.println(b);
		
		in.close();
	}
}
