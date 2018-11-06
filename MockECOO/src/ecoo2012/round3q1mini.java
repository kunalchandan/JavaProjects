package ecoo2012;

import java.util.*;

public class round3q1mini {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word = in.next();

		char[][] charTree = new char[word.length()*2 -1][word.length()*2 +1];
		String[] tree = new String[word.length()*2+1];
		for(int x = word.length()-1; x >= 0; x--) {
			String layer = "";
			for(int y = 0 ; y < x; y ++) {
				layer+=" ";
			}
			layer+= word.substring(0,word.length()-x);
			layer+= reverse(word.substring(0, layer.length()));
			tree[word.length()-1-x] = layer;
		}
		for(int x = word.length(); x < word.length()*2; x++) {
			tree[x] = "";
		}

	}
	public static String reverse(String input){
		char[] in = input.toCharArray();
		int begin=0;
		int end=in.length-1;
		char temp;
		while(end>begin){
			temp = in[begin];
			in[begin]=in[end];
			in[end] = temp;
			end--;
			begin++;
		}
		return new String(in);
	}

}
