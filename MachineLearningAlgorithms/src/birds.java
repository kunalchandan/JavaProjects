import java.io.*;
import java.util.*;

public class birds {
	static ArrayList<String> courses = new ArrayList<String>();
	static ArrayList<String> birds = new ArrayList<String>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("Ry/birds.csv"))));
		Scanner sc = new Scanner(new BufferedReader(new FileReader(new File("Ry/RyersonCourses.txt"))));
		while(sc.hasNextLine()) {
			courses.add(sc.nextLine().split(",")[0]);
		}
		while(in.hasNextLine()) {
			birds.add(in.nextLine().split(",")[0]);
		}
		for(int x = 0; x < courses.size(); x++) {
			if(courses.get(x).contains("ARB")){
				courses.remove(x);
			}if(courses.get(x).contains("CHN")){
				courses.remove(x);
			}if(courses.get(x).contains("FRE")){
				courses.remove(x);
			}if(courses.get(x).contains("GRK")){
				courses.remove(x);
			}if(courses.get(x).contains("SPN")){
				courses.remove(x);
			}if(courses.get(x).contains("WLG")){
				courses.remove(x);
			}if(courses.get(x).contains("SCI")){
				courses.remove(x);
			}
		}
		for(int x = 0; x < birds.size(); x++) {
			if(birds.get(x).contains("ARB")){
				birds.remove(x);
			}if(birds.get(x).contains("CHN")){
				birds.remove(x);
			}if(birds.get(x).contains("FRE")){
				birds.remove(x);
			}if(birds.get(x).contains("GRK")){
				birds.remove(x);
			}if(birds.get(x).contains("SPN")){
				birds.remove(x);
			}if(birds.get(x).contains("WLG")){
				birds.remove(x);
			}if(birds.get(x).contains("SCI")){
				birds.remove(x);
			}
		}
		for(int x = 0; x < courses.size(); x++) {
			for(int y = 0; y < birds.size(); y++) {
				if(courses.get(x).equalsIgnoreCase(birds.get(y))) {
					System.out.println(courses.get(x));
				}
			}
		}
	}

}
