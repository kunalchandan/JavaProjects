package ecoo2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("2017/DATA10.txt")))); 
		int categories[] = new int[4];
		for(int x =0;x < 4;x++ ) {
			categories[x]= in.nextInt();
		}
		int people = in.nextInt();
		
		int marks[][] = new int[4][people];
		
		for(int x=0;x<people;x++) {
			
		}
		/*
		int mark1;
		int mark2;
		int mark3
		mark1 = in.nextInt();
		data[0]
		 */
	}

}
