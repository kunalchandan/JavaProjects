import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class problem2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("data/DATA32.txt"))));
		for(int x = 0; x < 10; x++) {
			int[]rules;
			String[] line;
			try {
				line = in.nextLine().split(" ");
				rules = new int[line.length];
				for(int i = 0; i < line.length; i++) {
					rules[i] = Integer.parseInt(line[i]);
				}
			}catch(Exception e) {
				line = in.nextLine().split(" ");
				rules = new int[line.length];
				for(int i = 0; i < line.length; i++) {
					rules[i] = Integer.parseInt(line[i]);
				}
			}
			String[] sampleCode = new String[rules[0]];
			String[] realCode = new String[rules[0]];
			String[] compareCode = new String[rules[0]];
			for(int fs = 0; fs < compareCode.length; fs ++) {
				compareCode[fs] = "";
			}
			for(int n = 0; n < rules[0]; n++) {
				sampleCode[n] = in.nextLine();
			}
			String temp = in.nextLine();
			if(temp.equals("A")) {
				for(int n = 0; n < rules[0]; n++) {
					realCode[n] = in.nextLine();
				}
			}////END PARSING
			for(int n = 0; n < sampleCode.length; n++) {
				for(int iter = 0; iter < sampleCode[n].length(); iter++) {
					int read = Integer.parseInt(sampleCode[n].charAt(iter) + "");
					if(read == 0) {
						compareCode[n] += "" + rules[3];
					}else if(read%2 == 0) {
						compareCode[n] += "" + (read+rules[1]);
					}else if(read%2 == 1) {
						compareCode[n] += "" + (Math.max(read-rules[2], 0));
					}
				}
			}////END creation
			ArrayList<Integer> fails = new ArrayList<Integer>();
			for(int n = 0; n < realCode.length; n++) {
				if(!realCode[n].equals(compareCode[n])) {
					fails.add(n+1);
				}
			}////END CHECKS
			if(fails.size() == 0) {
				System.out.println("MATCH");
			}else {
				System.out.print("FAIL: ");
				for(int xb = 0 ; xb < fails.size()-1; xb ++) {
					System.out.print(fails.get(xb) + ",");
				}
				System.out.print(fails.get(fails.size()-1) + "\n");
				String lol = in.nextLine();
			}

		}

	}

}
