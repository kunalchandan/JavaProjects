
public class E014 {

	public static void main(String[] args) {
		long maxCount = 0;
		long maxNum = 0;
		for(long x = 1; x < 1000000; x++) {
			long a = x;
			long count = 0;
			while(a != 1) {
				count++;
				if(a%2 == 0) {
					a = a/2;
				}else {
					a = 3*a + 1;
				}
			}
			if(count>maxCount) {
				maxCount = count;
				maxNum = x;
			}
		}
		System.out.println(maxNum + "  " + maxCount);
	}
}
