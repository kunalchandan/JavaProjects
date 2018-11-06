
public class E003 {

	public static void main(String[] args) {
		long num = 600851475143l;
		for(long x = 2; x < num; x++) {
			while(num%x==0) {
				num=num/x;
				System.out.println(x + "  " + num);
			}
		}
	}
}
