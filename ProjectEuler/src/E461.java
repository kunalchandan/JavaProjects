
public class E461 {

	static int[] abcd = new int[4];
	static double newCost  = 0;
	static double lastCost = 0;
	static double pi = Math.PI;
	static double e  = Math.E;
	static int k = 10000;
	public static void main(String[] args) {
		initABCD();
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 4; y++) {
				abcd[y]++;
				newCost = calcCost();
				if(newCost > lastCost) {
					abcd[y]--;
				}
				abcd[y]--;
				newCost = calcCost();
				if(newCost > lastCost) {
					abcd[y]++;
				}
				lastCost = newCost;
				newCost = 0;
			}
		}
		for(int i = 0; i < 4; i++) {
			System.out.print(abcd[i]+" ");
		}
		System.out.printf("%n%.15f", a);

	}
	static double a = 0;
	private static double calcCost() {
		for(int i = 0; i < 4; i++) {
			a += Math.pow(e, abcd[i]/k);
			System.out.println(a);
		}
		a -= 4;
		return Math.abs(a-pi);
	}
	private static void initABCD() {
		for(int y = 0; y < 4; y++) {
			abcd[y] = 0;
		}
	}
}
