
public class E004 {

	public static void main(String[] args) {
		int biggest = 0;
		for(int x = 100; x < 999; x++) {
			for(int y = 100; y < 999; y++) {
				if(isPalli(x*y)) {
					if(x*y > biggest)
						biggest = x*y;
					System.out.println(biggest);
				}
			}
		}
	}
	private static boolean isPalli(int x) {
		int input = x;
		int reversedNum = 0;
		while (input != 0) {
			reversedNum = reversedNum * 10 + input % 10;
			input = input / 10;   
		}
		if(x == reversedNum)
			return true;
		else
			return false;
	}
}
