
public class E006 {

	public static void main(String[] args) {
		long sq = 0, py = 0;
		for(int x = 1; x <= 100; x ++) {
			py += Math.pow(x,2);
			sq+=x;
		}
		sq = (long) Math.pow(sq, 2);
		System.out.println(sq-py);
	}

}
