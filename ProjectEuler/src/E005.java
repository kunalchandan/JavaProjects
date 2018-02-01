
public class E005 {

	public static void main(String[] args) {
		int guess = 2*2*2*2*3*3*5*7*11*13*17*19;
		for(int x = 1; x < 21; x ++) {
			if(guess%x != 0) {
				System.out.println(x);
			}
		}
		System.out.println(guess);
	}

}
