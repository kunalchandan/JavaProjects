import java.util.ArrayList;
import java.util.Scanner;

public class SA {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		int size = (int) Math.log10(input);
		String out = "";
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for(int x = 0; x < size+1; x ++) {
			arr.add((int)(input % Math.pow(10, x+1)));
			input -= input % Math.pow(10, x+1);
		}
		for(int x = arr.size()-1; x >= 0; x--) {
			if(arr.get(x) != 0) {
				out += arr.get(x);
				if(x != 0) {
					out += " + ";
				}
			}
		}
		String last = (out.substring(out.length()-3, out.length()));
		if(last.equals(" + "))
		{
			out = out.substring(0, out.length()-3);
		}
		System.out.println(out);
	}

}
