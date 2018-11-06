import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String numPlayers = in.nextLine();
		String str = in.nextLine();
		String[] unp = str.split(" ");
		ArrayList<Integer> skills = new ArrayList<Integer>();
		for(int x = 0; x < unp.length; x++) {
			try {
				skills.add(Integer.parseInt(unp[x]));
			}catch(Exception e) {
			}
		}
		Collections.sort(skills);
		int max = skills.get(0);
		int min = skills.get(skills.size()-1);
		int middleLow = skills.get(skills.size()/2);
		int middleHigh = skills.get(skills.size()/2 -1);
		int ex = Math.abs((max+min)-(middleLow+middleHigh));
		System.out.println(ex);
		/*
		int[][] lol = new int[skills.size()/2][2];
		
		for(int x = 0; x < lol.length; x++) {
			int indexMin = 0;
			for(int y = 0; y < lol[0].length; y++) {
				if(lol[0][y] < indexMin) {
					indexMin = y;
				}
			}
		}
		int diff = (int) Math.abs(sumA-sumB);
		System.out.println(diff);*/
	}
}
