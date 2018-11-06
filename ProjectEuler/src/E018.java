import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class E018 {
	static int [][] triangle;
	static int max;

	public static void main(String[] args) throws IOException {		max = findmaxLen();
		triangle = new int[max][max];
		readInput();
		//reverse();
		printTri();
		recursiveSearch();
		System.out.println(maxPathSum(triangle, triangle.length-1, triangle.length-1));
	}
	private static int maxPathSum(int tri[][], int m, int n) {
		for (int i = m - 1; i >= 0; i--)
		{
			for (int j = 0; j <= i; j++)
			{
				if (tri[i + 1][j] > tri[i + 1][j + 1])
					tri[i][j] += tri[i + 1][j];
				else
					tri[i][j] += tri[i + 1][j + 1];
			}
		}
		return tri[0][0];
	}

	private static void recursiveSearch() {
		max = 0;
		for(int x = 0; x < triangle.length-1; x++) {
			int val = crawl(0,x);
			if(val > max) {
				max = val;
			}
			//System.out.println(crawl(0,x));
		}
		//System.out.println(max);
	}

	public static int crawl(int i, int j) {
		if(i < triangle.length-1) {
			//System.out.print(triangle[i][j]+" ");
			if(j!=0) {
				if(triangle[i+1][j-1] > triangle[i+1][j])
					return triangle[i][j] + crawl(i+1,j-1);
				else
					return triangle[i][j] + crawl(i+1,j);
			}
			else
				return triangle[i][j] + crawl(i+1,j);
		}
		return 0;
	}

	private static void printTri() {
		for(int i = 0; i < triangle.length; i++) {
			for(int j = 0; j < triangle.length; j++) {
				System.out.print(triangle[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void reverse() {
		for(int x = 0;x < triangle.length/2;x++) {
			int[] temp = triangle[x];
			triangle[x] = triangle[triangle.length - x-1];
			triangle[triangle.length-x-1] = temp;
		}
	}

	private static void readInput() throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("DATA/E018.txt"))));
		int count = -1;
		while(in.hasNextLine()) {
			count++;
			String inp = in.nextLine();
			//System.out.println(inp);
			String[] inpu = inp.split(" ");
			for(int x = 0;x < inpu.length; x++) {
				triangle[count][x] = Integer.parseInt(inpu[x]);
			}
		}
		in.close();
	}

	private static int findmaxLen() throws IOException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("DATA/E018.txt"))));
		int max = 0;
		while(in.hasNextLine()) {
			String[] input = in.nextLine().split(" ");
			if(input.length > max) {
				max = input.length;
			}
		}
		in.close();
		return max;
	}
}
