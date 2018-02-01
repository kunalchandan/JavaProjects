import java.util.Scanner;

public class SC {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String[] unp = str.split(" ");
		int[] fsl = new int[unp.length];
		for(int x = 0; x < unp.length; x++) {
			try {
				fsl[x] = Integer.parseInt(unp[x]);
			}catch(Exception e) {
				System.out.println(unp[x]);
			}
		}
		int f = fsl[0];
		int s = fsl[1];
		int l = fsl[2];
		if(l > Math.max(f, s)) {
			System.out.println(-1);
		}
		if(l == f || l == s) {
			System.out.println(1);
		}
	}
}
