import java.util.Scanner;
import java.util.TreeSet;

/*
Problem Description

Given an array A containing N integers.

You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.

If no such triplet exist return 0.



Problem Constraints
3 <= N <= 105.

1 <= A[i] <= 108.



Input Format
First argument is an integer array A.



Output Format
Return a single integer denoting the maximum sum of triplet as described in the question.



Example Input
Input 1:

 A = [2, 5, 3, 1, 4, 9]
Input 2:

 A = [1, 2, 3]


Example Output
Output 1:

 16
Output 2:

 6


Example Explanation
Explanation 1:

 All possible triplets are:-
    2 3 4 => sum = 9
    2 5 9 => sum = 16
    2 3 9 => sum = 14
    3 4 9 => sum = 16
    1 4 9 => sum = 14
  Maximum sum = 16
Explanation 2:

 All possible triplets are:-
    1 2 3 => sum = 6
 Maximum sum = 6
*/
public class MaxSumTriplet {
    public static int solve(int[] A) {
        int len=A.length;
        int max=0;
        int[] B=new int[len];

        int tmp_max=0;
        for(int i=len-1;i>=0;i--){
            tmp_max=Math.max(tmp_max,A[i]);
            if(tmp_max!=A[i])
                B[i]=tmp_max;
        }
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(Integer.MIN_VALUE);

        for(int i=0;i<len-1;i++){
            int cur=A[i];

            int leftMax=0;
            
            leftMax=set.lower(cur);
            set.add(cur);

            int rightMax=B[i];

            if(leftMax!=0 && rightMax!=0)
                max=Math.max(max,leftMax+A[i]+rightMax);
        }
        
        return max;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        System.out.println(solve(Array));
    }
}
