import java.util.Scanner;

/**
 * Problem Description

Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.

NOTE: You should make minimum number of comparisons.



Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109



Input Format
First and only argument is an integer array A of size N.



Output Format
Return an integer denoting the sum Maximum and Minimum element in the given array.



Example Input
Input 1:

 A = [-2, 1, -4, 5, 3]
Input 2:

 A = [1, 3, 4, 1]


Example Output
Output 1:

 1
Output 2:

 5


Example Explanation
Explanation 1:

 Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1. 
Explanation 2:

 Maximum Element is 4 and Minimum element is 1. (4 + 1) = 5.
 */
public class SumOfMaxMin {
    public static int solve(int[] A) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        int len=A.length;
        for(int i=0;i<len && (i+1)<len;i+=2){
            int tmp_max=0,tmp_min=0;
            if(A[i]>A[i+1]){
                tmp_max=A[i];
                tmp_min=A[i+1];
            }
            else{
                tmp_max=A[i+1];
                tmp_min=A[i];
            }
            
            max=Math.max(max,tmp_max);
            min=Math.min(min,tmp_min);
        }
        if((len & 1) == 1){
            max=Math.max(max,A[len-1]);
            min=Math.min(min,A[len-1]);
        }
        return (max+min);
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
