package Pokemon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class KNearest {
	/**
	 * I'll Have you know that this is currently garbage, and cannot perform anything.
	 * It does nothing but parse Pokemon data, and draw a graph of some of the data
	 */

	public static void main(String[] args) throws Throwable {
		
		Scanner in = new Scanner( new BufferedReader( new FileReader (new File("DATA/Pokemon.csv"))));
		in.nextLine();
		ArrayList<Pokemon> allPokemon = new ArrayList<Pokemon>();
		
		int percent = 50;
		int[][] nthPercent = new int[(int)(100/percent)][allPokemon.size()/(100/percent)];

		while(in.hasNextLine())
		{
			String line = in.nextLine();
			allPokemon.add(new Pokemon(line));
		}
		System.out.println(allPokemon);
		in.close();
		allPokemon.sort(Comparator.comparingInt(Pokemon::hp));
		

		SwingUtilities.invokeLater(() -> {
			PokeScatter example = new PokeScatter("Pokemon Data", allPokemon);
			example.setSize(800, 400);
			example.setLocationRelativeTo(null);
			example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			example.setVisible(true);
		});
		
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
