import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Description

Given a sorted array A containing N integers both positive and negative.

You need to create another array containing the squares of all the elements in A and return it in non-decreasing order.

Try to this in O(N) time.


Problem Constraints
1 <= N <= 105.

-103 <= A[i] <= 103



Input Format
First and only argument is an integer array A.



Output Format
Return a integer array as described in the problem above.



Example Input
Input 1:

 A = [-6, -3, -1, 2, 4, 5]
Input 2:

 A = [-5, -4, -2, 0, 1]


Example Output
Output 1:

 [1, 4, 9, 16, 25, 36]
Output 2:

 [0, 1, 4, 16, 25]
 */
public class SortArrayWithSquares {
    public static int[] solve(int[] A) {
        int i=0,j=A.length-1;
        int one,two,max;
        int[] res=new int[A.length];
        int k=j;

        for(;k>=0;){
            one=Math.abs(A[i]);
            two=Math.abs(A[j]);

            if(one>two){
                max=one;
                i++;
            }
            else{
                max=two;
                j--;
            }

            res[k--]=(max*max);
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        System.out.println(Arrays.toString(solve(Array)));
    }
}
