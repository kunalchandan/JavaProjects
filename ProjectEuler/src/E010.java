
public class E010 {

	public static void main(String[] args) {
		long sum = 0;
		for(int x = 0; x < 2000000; x++) {
			if(isPrime(x)) {
				sum+=x;
				System.out.println(x);
			}
		}
		System.out.println(sum);
	}
	static boolean isPrime(long n) {
	    if(n < 2) return false;
	    if(n == 2 || n == 3) return true;
	    if(n%2 == 0 || n%3 == 0) return false;
	    long sqrtN = (long)Math.sqrt(n)+1;
	    for(long i = 6L; i <= sqrtN; i += 6) {
	        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
	    }
	    return true;
	}

}
