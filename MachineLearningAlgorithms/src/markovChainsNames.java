import java.io.*;
import java.util.*;

public class markovChainsNames {

	static ArrayList<String> names = new ArrayList<String>();
	static ArrayList<Integer> ncounts = new ArrayList<Integer>();
	static ArrayList<Integer> nlens = new ArrayList<Integer>();

	static int alphaLen = 27;
	static int[][] letters = new int[alphaLen][alphaLen];
	static int[] rowsum = new int[alphaLen];
	static int[] lens = new int[20];
	public static void main(String[] args) throws IOException {
		readInput();
		initArray();
		train();
		printArray();
		BufferedWriter bf = new BufferedWriter(new FileWriter(new File ("DATAnames/newNames.csv")));
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 100; y++) {
				bf.write(generateName()+",");
			}
			bf.newLine();
		}
		bf.close();
	}
	private static String generateName() {
		Random rand = new Random();
		String name = "";
		int length = nlens.get(rand.nextInt(nlens.size()));
		char seedLetter = (char)(97+rand.nextInt(alphaLen));
		char nextLetter = ' ';
		for(int x = 0; x < length; x++) {
			if(seedLetter == '{') {
				name+="\'";
			}else {
				name+=seedLetter;
			}
	    	int newL = rand.nextInt(rowsum[seedLetter-97]);
			for(int y = 1; y < letters.length; y++) {
				if(newL >= letters[seedLetter-97][y-1] && newL <= letters[seedLetter-97][y] ) {
					nextLetter = (char)(y+97);
					
					seedLetter = nextLetter;
					break;
				}
			}
		}
		return name;
	}
	private static void train() {
		///Gather counts for successive characters
		for(int x = 0; x < names.size(); x++) {
			//System.out.println(names.get(x));
			for(int y = 1; y < names.get(x).length(); y++) {
				letters[names.get(x).charAt(y-1)-97][names.get(x).charAt(y)-97] += ncounts.get(x);
			}
		}
		///Gather counts for lengths
		for(int x = 0; x < nlens.size(); x++) {
			lens[nlens.get(x)]++;
		}
///Make successive character array into sum successive array
		for(int x = 0; x < letters.length; x++) {
			int sum = 0;
			for(int y = 0; y < letters.length; y++) {
				sum += letters[x][y];
				letters[x][y] = sum;
			}
			rowsum[x] = sum;
		}
	}
	private static void readInput() throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("DATAnames/NationalNames.csv"))));
		in.nextLine();
		while(in.hasNextLine()) {
			String[] lol = in.nextLine().split(",");
			//if(lol[1].equalsIgnoreCase("female")) {
				lol[1] = lol[1].replace("\'", "{");
				//System.out.println(lol[1]);
				names.add(lol[1].toLowerCase());
				nlens.add(lol[1].length());
				ncounts.add(Integer.parseInt(lol[4]));
			//}
			//for(int x = 0; x < lol.length; x++)
			//	System.out.print(lol[x]);
			//System.out.println();
		}
		in.close();
	}
	private static void printArray() {
		for(int x = 0; x < letters.length; x++) {
			for(int y = 0; y < letters.length; y++) {
				System.out.print(letters[x][y] + " ");
			}
			System.out.println();
		}
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		for(int x = 0; x < lens.length; x++) {
			System.out.print(lens[x] + " ");
		}
	}
	private static void initArray() {
		for(int x = 0; x < letters.length; x++) {
			for(int y = 0; y < letters.length; y++) {
				letters[x][y] = 0;
			}
		}
		for(int x = 0; x < lens.length; x++) {
			lens[x] = 0;
		}
	}
}
