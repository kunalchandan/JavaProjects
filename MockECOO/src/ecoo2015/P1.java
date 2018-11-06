package ecoo2015;

import java.io.*;
import java.util.*;

public class P1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("DATA11.txt"))));
		for(int x = 0; x < 10; x++) {
			boolean key = true;
			// orange, blue, green, yellow, pink, violet, brown, red
			double[] smarties = {0, 0, 0, 0, 0, 0, 0, 0};
			String line = "";
			while(!line.equals("end of box")) {
				line = in.nextLine();
				if(line.equals("orange")) {
					smarties[0]++;
				}else if(line.equals("blue")) {
					smarties[1]++;
				}else if(line.equals("green")) {
					smarties[2]++;
				}else if(line.equals("yellow")) {
					smarties[3]++;
				}else if(line.equals("pink")) {
					smarties[4]++;
				}else if(line.equals("violet")) {
					smarties[5]++;
				}else if(line.equals("brown")) {
					smarties[6]++;
				}else if(line.equals("red")) {
					smarties[7]++;
				}
			}
			for(int y = 0; y < smarties.length-1; y++) {
				smarties[y] = Math.ceil(smarties[y] / 7.0);
			}
			int time = 0;
			for(int y = 0; y < smarties.length-1; y++) {
				time+=(13*smarties[y]);
			}
			time+=(16*smarties[7]);
			System.out.println(time);
		}
	}

}
