import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class KNearest {

	public static void main(String[] args) throws Throwable {
		
		Scanner in = new Scanner( new BufferedReader( new FileReader (new File("DATA/Pokemon.csv"))));
		in.nextLine();
		ArrayList<Pokemon> allPokemon = new ArrayList<Pokemon>();
		
		int percent = 50;
		int[][] nthPercent = new int[100/percent][allPokemon.size()/(100/percent)];

		while(in.hasNextLine())
		{
			String line = in.nextLine();
			allPokemon.add(new Pokemon(line));
		}
		System.out.println(allPokemon);
		in.close();
		allPokemon.sort(Comparator.comparingInt(Pokemon::hp));
		for(int x = 0; x < allPokemon.size(); x++)
		{
			for(int y = 0; y < nthPercent.length; y++)
			{
				nthPercent[y][x%y] = allPokemon.get(x).hp;
			}
		}
		
	}
	public static double[] separate(String nextLine) 
	{
		String[] array = nextLine.split(",");
		double[] line = new double[array.length];

		for(int x = 0; x < array.length; x ++) 
		{
			double banana = Double.parseDouble(array[x]);
			line[x] = banana;
		}
		return line;
	}

}
