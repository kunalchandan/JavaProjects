
public class E017 {

	public static void main(String[] args) { //I hate this problem, 
		// all that still needs to be done is add " hundred".length() to map100 and add integers together 
		// This is a FALSE Problem
		int [] map1  ={0,3,3,5,4,4,3,5,5,4};
		int [] map10 ={0,3,6,6,6,5,5,7,6,6};
		int [] map100={0,3,3,5,4,4,3,5,5,4};
		int total = 0;
		for(int x = 0; x <= 1000; x++) {
			String num = x+"";
			while(num.length() < 3) {
				num = "0" + num;
			}
		}
	}

}
