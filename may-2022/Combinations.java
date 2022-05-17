import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :

If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python.

If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class Combinations {
    static void combinations(List<Integer> a,int k,ArrayList<Integer> curSet,ArrayList<ArrayList<Integer>> res){
        if(k==0){
            res.add(new ArrayList<Integer>(curSet));
            return;
        }
        if(a.size()==0) return;
        
        for(int i=0;i<a.size();i++){
            curSet.add(a.get(i));
            combinations(a.subList(i+1,a.size()),k-1,curSet,res);
            curSet.remove(curSet.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        List<Integer> a=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        for(int i=1;i<=A;i++){
            a.add(i);
        }
        combinations(a,B,new ArrayList<Integer>(),res);
        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        int A=ob.nextInt();
        int B=ob.nextInt();

        for(ArrayList<Integer> list:combine(A,B))
            System.out.println(list.toString());
    }
}
