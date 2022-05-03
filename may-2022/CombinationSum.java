import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Problem Description

Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

The same repeated number may be chosen from A unlimited number of times.

Note:

1) All numbers (including target) will be positive integers.

2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

3) The combinations themselves must be sorted in ascending order.

4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)

5) The solution set must not contain duplicate combinations.

Problem Constraints
1 <= |A| <= 20 

1 <= A[i] <= 50

1 <= B <= 500

Input Format
The first argument is an integer array A.

The second argument is integer B.

Output Format
 Return a vector of all combinations that sum up to B.

Example Input
Input 1:

A = [2, 3]
B = 2
Input 2:

A = [2, 3, 6, 7]
B = 7

Example Output
Output 1:

[ [2] ]
Output 2:

[ [2, 2, 3] , [7] ]

Example Explanation
Explanation 1:

All possible combinations are listed.
Explanation 2:

All possible combinations are listed.
 */
public class CombinationSum {
    static void recurse(ArrayList<Integer> A, int B,ArrayList<Integer> curSelected,ArrayList<ArrayList<Integer>> res,int i){
        if(A.size()==i || B<0) return;
        if(B==0){
            if(!res.contains(new ArrayList<Integer>(curSelected))){
                res.add(new ArrayList<Integer>(curSelected));
            }    
            return;
        }

        //Selected
        curSelected.add(A.get(i));
        recurse(A,B-A.get(i),curSelected,res,i);
        curSelected.remove(curSelected.size()-1);
        //not selected
        recurse(A,B,curSelected,res,i+1);
    }
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        recurse(A,B,new ArrayList<Integer>(),res,0);
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
