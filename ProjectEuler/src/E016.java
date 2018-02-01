import java.math.BigInteger;

public class E016 {

	public static void main(String[] args) {
		BigInteger power = new BigInteger("1");
		for(int x = 1; x < 1001; x++) {
			power = power.multiply(new BigInteger("2"));
			String pow = "" + power;
			int sum = 0;
			for(int y = 0 ; y < pow.length(); y++) {
				sum += Integer.parseInt(pow.substring(y, y+1));
			}
			System.out.println(x + "  " + power + "  " + sum);
		}

	}

}
