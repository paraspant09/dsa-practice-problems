import java.util.Scanner;

/**
 * Given a matrix of integers A of size N x M in which each row is sorted.

Find an return the overall median of the matrix A.

Note: No extra memory is allowed.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.




Input Format

The first and only argument given is the integer matrix A.
Output Format

Return the overall median of the matrix A.
Constraints

1 <= N, M <= 10^5
1 <= N*M  <= 10^6
1 <= A[i] <= 10^9
N*M is odd
For Example

Input 1:
    A = [   [1, 3, 5],
            [2, 6, 9],
            [3, 6, 9]   ]
Output 1:
    5
Explanation 1:
    A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
    Median is 5. So, we return 5.

Input 2:
    A = [   [5, 17, 100]    ]
Output 2:
    17 ``` Matrix=
```
 */
public class MatrixMedian {
    public static int numLessThanK(int[] A,int k,int l,int h){
        while(l<=h){
            int mid=l+(h-l)/2;
            if(A[mid]<=k)
                l=mid+1;
            else
                h=mid-1;
        }
        return l;
    }

    public static int findMedian(int[][] A) {
        int N=A.length;
        int M=A[0].length;
        int chk=(N*M)/2;
        int l=1;
        int h=(int)1e9;
        while(l<=h){
            int mid=l+(h-l)/2;
            int tot=0;
            for(int i=0;i<N;i++){
                tot+=numLessThanK(A[i],mid,0,M-1);
            }
            if(tot<=chk)
                l=mid+1;
            else
                h=mid-1;
        }
        return l;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int N=ob.nextInt();
        int M=ob.nextInt();

        int[][] A=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j]=ob.nextInt();
            }
        }
    	
        System.out.println(findMedian(A));
    }
}
