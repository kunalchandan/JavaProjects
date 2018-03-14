import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N  = Integer.parseInt(in.nextLine());
		int[][] gard = new int [N][N];
		String lol = "";
		for(int x = 0; x < N; x ++) {
			lol = in.nextLine();
			String[]lol1 = lol.split(" ");
			for(int y = 0; y < lol1.length; y++) {
				gard[x][y] = Integer.parseInt(lol1[y]);
			}
		}
		N--;
		int lu = gard[0][0];
		int ru = gard[N][0];
		int ld = gard[0][N];
		int rd = gard[N][N];
		N++;
		if(N == 1) {
			System.out.println(lol);
		}
		if(lu < ru) {
			if(lu < rd) {
				//if(lu < rd) {
					for(int x = 0; x < N; x ++) {
						for(int y = 0; y < N; y ++) {
							System.out.print(gard[x][y]+ " ");
						}
						System.out.println();
					}
				//}
			}
		}
		if(lu > ru) {
			if(ru < rd) {
				//if(lu <= rd) {
					for(int y = 0; y < N; y ++) {
						for(int x = N-1; x >= 0; x --) {
							System.out.print(gard[x][y]+ " ");
						}
						System.out.println();
					}
					//rotate 90 deg ccw
				//}
			}
		}
		if(ld < rd) {
			if(lu > ld) {
				//if(lu <= rd) {
					for(int y = N-1; y >= 0; y --) {
						for(int x = 0; x < N; x ++) {
							System.out.print(gard[x][y]+ " ");
						}
						System.out.println();
					}
					//rotate 90 deg cw
				//}
			}
		}
		if(ld > rd) {
			if(rd > ld) {
				//if(lu > rd) {
					for(int y = N-1; y >= 0; y --) {
						for(int x = N-1; x >= 0; x --) {
							System.out.print(gard[x][y]+ " ");
						}
						System.out.println();
					}
					//rotate 180 deg cw
				//}
			}
		}	
	}
}
