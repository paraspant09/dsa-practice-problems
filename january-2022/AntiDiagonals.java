import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Description

Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
Example:

Input:

1 2 3
4 5 6
7 8 9
Return the following:
[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input: 
1 2
3 4
Return the following: 
[
  [1],
  [2, 3],
  [4]
]
 */
public class AntiDiagonals  {
    public static int[][] diagonal(int[][] A) {
        int len=A.length;
        int n=(2*len-1);
        int[][] res=new int[n][];

        int ct=0;
        int tst=0;
        int i1=0,j1=0;

        for(int i=0;i<n;i++){
            if(i<len){
                res[i]=new int[i+1];
                tst=i;
            }    
            else{
                res[i]=new int[(n-i)];
                ct++;
                tst=n-1-i;
            }
            j1=0;
            for(int j=0;j<=tst;j++){
                int k=ct+j;
                // System.out.println(k+" "+(i-k));
                res[i1][j1]=A[k][i-k];
                j1++;
            }
            i1++;
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int n=ob.nextInt();
    		    
    	int[][] Array=new int[n][n];
    		    
    	for (int i=0; i<n ;i++ ){
    	    for (int j=0; j<n ;j++ ){
                Array[i][j]=ob.nextInt();
            }
    	}

        int[][] res=diagonal(Array);

        for(int[] a:res)
            System.out.println(Arrays.toString(a));
    }
}
