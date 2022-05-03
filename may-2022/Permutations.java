import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]
NOTE

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
 */
public class Permutations {
    static void findPermutations(ArrayList<Integer> cur,ArrayList<Integer> rem,ArrayList<ArrayList<Integer>> res){
        if(rem.size()==0){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=0;i<rem.size();i++){
            cur.add(rem.get(i));
            ArrayList<Integer> tempList=new ArrayList<Integer>();
            tempList.addAll(rem.subList(0,i));
            tempList.addAll(rem.subList(i+1,rem.size()));
            findPermutations(cur,tempList,res);
            cur.remove(cur.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        findPermutations(new ArrayList<Integer>(),A,res);
        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<Integer> A=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            A.add(ob.nextInt());
        }
        for(ArrayList<Integer> list:permute(A))
            System.out.println(list.toString());
    }
}
