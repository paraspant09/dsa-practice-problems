import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Description

Given numRows, generate the first numRows of Pascal's triangle.
Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
Constraints:
0 <= numRows <= 25

 */
public class PascalTriangle {
    public static int[][] solve(int A) {
        int[] dp=new int[A];
        int[][] res=new int[A][];
        for(int i=0;i<A;i++){
            res[i]=new int[i+1];
        }

        if(A>0){
            dp[0]=1;
            res[0][0]=1;
        }

        for(int i=1;i<A;i++){
            for(int j=i;j>0;j--){
                dp[j]+=dp[j-1];
            }
            for(int j=0;j<=i;j++){
                res[i][j]=dp[j];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int n=ob.nextInt();

        int[][] res=solve(n);

        for(int[] a:res)
            System.out.println(Arrays.toString(a));
    }
}
