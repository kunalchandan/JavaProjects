import java.util.ArrayList;

public class E012 {

	public static void main(String[] args) {
		// Generate Triangle numbers
		ArrayList<Integer> tri = new ArrayList<Integer>();
		tri.add(0);
		int maxFact = 0;
		int count = 1;
		while(maxFact  < 500) {
			tri.add(tri.get(count-1) + count);
			/////////////////////////////////////////
			int temp = tri.get(count);
			int tempFact = 0;
			for(int x = 1; x <= Math.sqrt(temp); x++) {
				if((temp%x == 0) && (x < Math.sqrt(temp) )) {
					tempFact += 2;
				}
				else if (temp%x == 0) {
					tempFact++;
				}
			}
			if(tempFact > maxFact) {
				maxFact = tempFact;
				System.out.println(tri.get(count) + "  " + tempFact);
			}
			count++;
		}
	}
}
