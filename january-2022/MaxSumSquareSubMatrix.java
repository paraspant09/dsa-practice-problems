import java.util.Scanner;
/**
 * Problem Description

Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1, such that sum of all the elements in submatrix is maximum.



Problem Constraints
1 <= N <= 103.

1 <= B <= N 

-102 <= A[i][j] <= 102.



Input Format
First arguement is an 2D integer matrix A.

Second argument is an integer B.



Output Format
Return a single integer denoting the maximum sum of submatrix of size B x B.



Example Input
Input 1:

 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3
Input 2:

 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2


Example Output
Output 1:

 48
Output 2:

 8


Example Explanation
Explanation 1:

    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48
Explanation 2:

 Maximum sum 2 x 2 matrix is
  2 2
  2 2
  Sum = 8
 */
public class MaxSumSquareSubMatrix {
    public static int solve(int[][] A, int B) {
        int max=Integer.MIN_VALUE;
        int len=A.length;
        int[] arr=new int[len];

        for(int k=0;k<=(len-B);k++){
            for(int i=0;i<len;i++){
                if(k>0){
                    arr[i]=arr[i]-A[k-1][i]+A[B+k-1][i];
                }
                else{
                    for(int j=0;j<B;j++){
                            arr[i]+=A[k+j][i];
                    }
                }
            }
            // System.out.println(Arrays.toString(arr));

            int sum=0;
            for(int j=0;j<B;j++){
                sum+=arr[j];
            }
            // System.out.println(sum);

            max=Math.max(max,sum);
            for(int i=1;i<=(len-B);i++){
                sum=sum-arr[i-1]+arr[B+i-1];
                // System.out.println(sum);

                max=Math.max(max,sum);
            }
        }
        return max;
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

        int B=ob.nextInt();

        System.out.println(solve(Array,B));
    }
}
