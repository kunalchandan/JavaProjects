import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N  = in.nextInt();
		double[] vi = new double[N];
		for(int x = 0; x < N; x++) {
			vi[x] = in.nextInt();
		}
		Arrays.sort(vi);
		double min = Double.MAX_VALUE;
		for(int x = 0; x < N-2; x ++) {
			if(((Math.abs((vi[x+1]-vi[x])/2) + (vi[x+2]-vi[x+1])/2)) < min) {
				min = ((Math.abs((vi[x+1]-vi[x])/2) + (vi[x+2]-vi[x+1])/2));
			}
		}
		System.out.printf("%.1f", Math.abs(min));
	}

}
