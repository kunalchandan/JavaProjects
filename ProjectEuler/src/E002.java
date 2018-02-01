
public class E002 {

	public static void main(String[] args) {
		int one = 1, two = 1;
		int x = 0;
		int sum = 0;
		while(x < 4000000) {
			x = one+two;
			int swap = two;
			two = x;
			one = swap;
			if(two%2 ==0)
				sum+=two;
			System.out.println(one + "  " + two);
		}
		System.out.println(sum);
	}

}
