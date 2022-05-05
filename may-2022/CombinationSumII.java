import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
 */
public class CombinationSumII {
    static void recurse(int ind,ArrayList<Integer> a, int b,ArrayList<Integer> curPath,ArrayList<ArrayList<Integer>> res){
		if(b==0){
			res.add(new ArrayList<>(curPath));
			return;
		}
		if(b<0)	return;
		
		for(int i=ind;i<a.size();i++){
			if(i!=ind && a.get(i)==a.get(i-1))
				continue;
			curPath.add(a.get(i));
			recurse( i+1 , a , b-a.get(i) , curPath , res);
			curPath.remove(curPath.size()-1);
		}
	}
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curPath=new ArrayList<Integer>();
		Collections.sort(a);

		recurse(0,a,b,curPath,res);
		return res;
	}
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<Integer> A=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            A.add(ob.nextInt());
        }
        int B=ob.nextInt();
        for(ArrayList<Integer> list:combinationSum(A,B))
            System.out.println(list.toString());
    }
}
