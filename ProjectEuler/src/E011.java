import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class E011 {

	static String[][] strData = new String[20][20];
	static int[][] data = new int[20][20];
	public static void main(String[] args) throws Throwable {
		readData();
		parseIt();
		int len = 4;
		int biggest = 0;
		//read horizontal
		for(int x = 0; x < data.length - 4; x++) {
			for(int y = 0; y < data.length; y++) {
				int prod = 1;
				for(int z = 0; z < len; z++) {
					prod*= data[x+z][y];
				}
				if(prod > biggest) {
					biggest = prod;
					System.out.println(prod);
					for(int z = 0; z < len; z++) {
						System.out.println(data[x+z][y]);
					}
				}
			}
		}
		//read vertical
		for(int x = 0; x < data.length; x++) {
			for(int y = 0; y < data.length - 4; y++) {
				int prod = 1;
				for(int z = 0; z < len; z++) {
					prod*= data[x][y+z];
				}
				if(prod > biggest) {
					biggest = prod;
					System.out.println(prod);
					for(int z = 0; z < len; z++) {
						System.out.println(data[x][y+z]);
					}
				}
			}
		}
		//read diagonal
		for(int x = 0; x < data.length - 4; x++) {
			for(int y = 0; y < data.length - 4; y++) {
				int prod = 1;
				for(int z = 0; z < len; z++) {
					prod*= data[x+z][y+z];
				}
				if(prod > biggest) {
					biggest = prod;
					System.out.println(prod);
					for(int z = 0; z < len; z++) {
						System.out.println(data[x+z][y+z]);
					}
				}
			}
		}
		//read other diagonal
		for(int x = 0; x < data.length - 3; x++) {
			for(int y = 3; y < data.length; y++) {
				int prod = 1;
				for(int z = 0; z < len; z++) {
					prod*= data[x+z][y-z];
				}
				if(prod > biggest) {
					biggest = prod;
					System.out.println(prod);
					for(int z = 0; z < len; z++) {
						System.out.println(data[x+z][y-z]);
					}
				}
			}
		}
	}

	private static void parseIt() {
		for(int x = 0; x < strData.length; x++) {
			for(int y = 0; y < strData.length; y++) {
				data[x][y] = Integer.parseInt(strData[x][y]);
			}
		}
	}

	private static void readData() throws Throwable {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("DATA/E011.txt"))));
		for(int x = 0; x < strData.length; x++) {
			strData[x] = in.nextLine().split(" ");
		}
		in.close();

		
	}
}
