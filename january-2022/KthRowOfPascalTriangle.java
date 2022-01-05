import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Description

Given an index k, return the kth row of the Pascal's triangle.
Pascal's triangle: To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.

Example:

Input : k = 3


Return : [1,3,3,1]

Note: k is 0 based. k = 0, corresponds to the row [1]. 

Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class KthRowOfPascalTriangle {
    public static int[] getRow(int k) {
        int[] dp=new int[k+1];

        dp[0]=1;

        for(int i=1;i<=k;i++){
            for(int j=i;j>=1;j--){
                dp[j]=dp[j-1]+dp[j];
            }
        }

        return dp;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int k=ob.nextInt();

        System.out.println(Arrays.toString(getRow(k)));
    }
}
