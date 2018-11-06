import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class problem4 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File("data/DATA41.txt"))));
		for(long counter = 0; counter < 10; counter++) {
			String[] line = in.nextLine().split(" ");
			long x = Long.parseLong(line[0]);
			long y = Long.parseLong(line[1]);
			ArrayList<Long> fib = new ArrayList<Long>();
			long a = 0, b = 1;
			for(long fiber = 0; fiber < 40; fiber++) {
				fib.add(a);
				long c = a+b;
				a = b;
				b = c;
			}
			
			
			long countX = 0;
			long sumX = 0;
			long countY = 0;
			long sumY = 0;
			if(x > 0l) {
				int count = 1;
				long sum = 0;
				while(x <= sum) {
					sum += fib.get(count)*fib.get(count);
					count+=2;
				}
				sumX = sum;
				countX = fib.get(count);
			}else if(x < 0l) {
				long x2 = Math.abs(x);
				int count = 2;
				long sum = 0;
				while(x2 <= sum) {
					sum += fib.get(count)*fib.get(count);
					count+=2;
				}
				sumX = sum;
				countX = fib.get(count);
			}
			if(y > 0l) {
				int count = 3;
				long sum = 0;
				while(y <= sum) {
					sum += fib.get(count);
					count+=4;
				}
				sumY = sum;
				countY = fib.get(count);
			}else if(y < 0l) {
				long y2 = Math.abs(y);
				int count = 1;
				long sum = 0;
				while(y2 <= sum) {
					sum += fib.get(count);
					count+=4;
				}
				sumY = sum;
				countY = fib.get(count);
			}
			//////WHAT TO PRINT
			System.out.println(countX);
			
			
			
		}
	}

}
