
public class E015 {

	public static void main(String[] args) {
		for(int size = 1; size < 22; size++) {
			long[][] pascal = new long[size][size];
			for(int x = 0; x < pascal.length; x++) {
				pascal[0][x] = 1;
				pascal[x][0] = 1;
			}

			for(int x = 1; x < pascal.length; x++) {
				for(int y = 1; y < pascal.length; y++) {
					pascal[x][y] = pascal[x-1][y] + pascal[x][y-1];
				}
			}
			// Also used approach on Google Sheets
			System.out.println(pascal[pascal.length-1][pascal.length-1]);
		}
	}
}
