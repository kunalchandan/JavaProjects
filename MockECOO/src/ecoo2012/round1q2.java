package ecoo2012;

import java.io.*;
import java.util.*;

public class round1q2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("2012/DATA21.txt"))));
		String promoter = "TATAAT";
		int count =0;
		while(in.hasNextLine()) {
			count ++;
			String dna = in.nextLine();
			String postPromote = "";
			for(int x = 0; x < dna.length()-6; x++) {
				if(dna.substring(x, x+6).equalsIgnoreCase(promoter)){
					postPromote = dna.substring(x+10);
					break;
				}
			}
			for(int x = 0; x < postPromote.length(); x++) {
				for(int y = 6; y < (postPromote.length()/2); y++) {
					String terminator = postPromote.substring(x, x+y);
					String postTerminator = postPromote.substring(x+y);
					if(postTerminator.indexOf(reverse(complementDNA(terminator))) != -1 && (postTerminator.indexOf(reverse(complementDNA(terminator))) != 0)) {
						System.out.println(count + ": " + complementRNA(postPromote.substring(0, postPromote.indexOf(terminator))));
						x = postPromote.length();
						break;
					}
				}
			}
		}
	}
	public static String complementRNA(String dna) {
		dna = dna.replace('A', 'U');
		dna = dna.replace('T', 'A');
		dna = dna.replace('G', 'Z');
		dna = dna.replace('C', 'G');
		dna = dna.replace('Z', 'C');
		return dna;
	}
	public static String complementDNA(String dna) {
		dna = dna.replace('A', 'U');
		dna = dna.replace('T', 'A');
		dna = dna.replace('U', 'T');
		dna = dna.replace('G', 'Z');
		dna = dna.replace('C', 'G');
		dna = dna.replace('Z', 'C');
		return dna;
	}
	public static String reverse(String input){
		char[] in = input.toCharArray();
		int begin=0;
		int end=in.length-1;
		char temp;
		while(end>begin){
			temp = in[begin];
			in[begin]=in[end];
			in[end] = temp;
			end--;
			begin++;
		}
		return new String(in);
	}
}
