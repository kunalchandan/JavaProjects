
import java.util.*;

public class Super{
	public static void main(String[] args){


		ArrayList<ArrayList<Integer>> perm;
		perm = permutation2(new int[] {1, 2, 3}, 3);//new ArrayList<String>();
		Arrays.sort(perm);

		System.out.println(perm);
		boolean remove = false;
		ArrayList<Integer> superperm = new ArrayList<Integer>();
		for(int x = 0; x < perm.size(); x++){
			int index = findIndexLowest(perm);
			for(int each = 0; each < perm.get(0).size(); each++){
				if(superperm.get(superperm.size()-1) == perm.get(index).get(each)){
					for(int a = 1; a < perm.size(); a++){
						superperm.add(perm.get(index).get(a));
					}
					remove = true;
				}
			}
			if(remove){
				perm.remove(index);
				remove = false;
			}
		}
		System.out.println(superperm);
	}

	public static int findIndexLowest(ArrayList<ArrayList<Integer>> perm){
		int min = 100;
		int index = perm.size();
		for(int x = 0; x < perm.size(); x++){
			if(perm.get(x).get(0) < min){
				index = x;
			}
		}
		return index;
	}
	public static ArrayList<ArrayList<Integer>> permutation2(int[] a, int n) {

        ArrayList<ArrayList<Integer>> gen = new ArrayList<>();
        if(n == 1) {
            ArrayList<Integer> new_permutation = new ArrayList<>();
            new_permutation.add(a[n-1]);
            gen.add(new_permutation);
        } else {
            Iterator<ArrayList<Integer>> itr = permutation2(a, n-1).iterator();
            while(itr.hasNext()) {
                ArrayList<Integer> permutation = itr.next();
                // (create new permutation with this element in every position)
                for(int i = 0;i <= permutation.size();i++) {
                    ArrayList<Integer> new_permutation = new ArrayList<>(permutation);
                    new_permutation.add(i, a[n-1]);
                    gen.add(new_permutation);
                }
            }
        }
        return gen;
    }

}
