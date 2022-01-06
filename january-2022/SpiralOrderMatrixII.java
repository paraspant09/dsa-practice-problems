import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.

Input Format:

The first and the only argument contains an integer, A.
Output Format:

Return a 2-d matrix of size A x A satisfying the spiral order.
Constraints:

1 <= A <= 1000
Examples:

Input 1:
    A = 3

Output 1:
    [   [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]   ]

Input 2:
    4

Output 2:
    [   [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]   ]
 */
public class SpiralOrderMatrixII {
    public static void recurse(int[][] B,int s,int e,int val){
        int i=s,j=s;
        
        if(s>e) return;
        if(s==e){
            B[i][j]=val;
            return;
        }

        do{
            B[i][j]=val++;
            if(j==e)    i++;
            else    j++;
        }while(i<j);
        do{
            B[i][j]=val++;
            if(j==s)    i--;
            else    j--;
        }while(j<i);

        recurse(B,s+1,e-1,val);
    }

    public static int[][] generateMatrix(int A) {
        int[][] B=new int[A][A];
        recurse(B,0,A-1,1);

        return B;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int n=ob.nextInt();

        int[][] res=generateMatrix(n);

        for(int[] a:res)
            System.out.println(Arrays.toString(a));
    }
}
