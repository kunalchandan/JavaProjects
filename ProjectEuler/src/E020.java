import java.math.BigInteger;

public class E020 {

	public static void main(String[] args) {
		for(int a = 0 ; a < 101; a++) {
			BigInteger fact = new BigInteger("1");
			int sum = 0;
			for(int x = 1; x < a; x++) {
				fact = fact.multiply(new BigInteger(x + ""));
			}
			String face = fact.toString();
			for(int x = 0; x < face.length(); x++) {
				sum += Byte.parseByte(face.charAt(x)+"");
			}
			System.out.println(sum);
		}
	}

}
