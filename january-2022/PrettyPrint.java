import java.util.Arrays;
import java.util.Scanner;

/**
 * Print concentric rectangular pattern in a 2d matrix. 

Let us show you some examples to clarify what we mean.

Example 1:

Input: A = 4.

Output:

4 4 4 4 4 4 4 
4 3 3 3 3 3 4 
4 3 2 2 2 3 4 
4 3 2 1 2 3 4 
4 3 2 2 2 3 4 
4 3 3 3 3 3 4 
4 4 4 4 4 4 4 
Example 2:

Input: A = 3.

Output:

3 3 3 3 3 
3 2 2 2 3 
3 2 1 2 3 
3 2 2 2 3 
3 3 3 3 3 
The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */
public class PrettyPrint {
    public static void recurse(int[][] B,int A,int s,int e){
        if(s>e)    return;

        for(int i=s;i<=e;i++){
            B[s][i]=A;
            B[i][s]=A;
            B[i][e]=A;
            B[e][i]=A;
        }
        recurse(B,A-1,s+1,e-1);
    }
    public static int[][] prettyPrint(int A) {
        int rc=2*A-1;
        int[][] B=new int[rc][rc];
        recurse(B,A,0,rc-1);

        return B;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int A=ob.nextInt();

        int[][] B=prettyPrint(A);

        for(int[] row:B)
            System.out.println(Arrays.toString(row));
    }
}
