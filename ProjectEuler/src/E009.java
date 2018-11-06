 
public class E009 {

	public static void main(String[] args) {
		int triplet = 1000;
		for(int a = 0; a < 1000; a++) {
			for(int b = 0; b < 1000; b++) {
				for(int c = 0; c < 1000; c++) {
					int lhs = (int) (Math.pow(a, 2) + Math.pow(b, 2));
					int rhs = (int) (Math.pow(c, 2));
					if(rhs == lhs) {
						if(a+b+c == triplet) {
							System.out.println(a*b*c);
							System.out.println(a+" "+b+" "+c);
						}
					}
				}
			}
		}
	}
}
