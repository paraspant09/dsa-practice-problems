import java.util.Scanner;
/**
 * Problem Description

Given an array of integers A, every element appears twice except for one. Find that single one.


NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?



Problem Constraints
2 <= |A| <= 2000000

0 <= A[i] <= INTMAX



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer denoting the single element.



Example Input
Input 1:

 A = [1, 2, 2, 3, 1]
Input 2:

 A = [1, 2, 2]


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

3 occurs once.
Explanation 2:

1 occurs once.
 */
public class SingleNumber {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int singleNumber(final int[] A) {
        int res=0;
        for(int i=0;i<A.length;i++){
            res^=A[i];
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        int n=ob.nextInt();
        int A[]=new int[n];
        for(int i=0;i<n;i++)
            A[i]=ob.nextInt();

        System.out.println(singleNumber(A));
    }
}
