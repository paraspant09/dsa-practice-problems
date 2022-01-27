import java.util.Scanner;

/**
 * Given a matrix of integers A of size N x M and an integer B.

Write an efficient algorithm that searches for integar B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.




Input Format

The first argument given is the integer matrix A.
The second argument given is the integer B.
Output Format

Return 1 if B is present in A, else return 0.
Constraints

1 <= N, M <= 1000
1 <= A[i][j], B <= 10^6
For Example

Input 1:
    A = 
    [ [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]  ]
    B = 3
Output 1:
    1

Input 2:
    A = [   [5, 17, 100, 111]
            [119, 120,  127,   131]    ]
    B = 3
Output 2:
    0
 */
public class MatrixSearch {
    static int bs(int[] A,int B,int f,int l){
        if(f<=l){
            int m=(f+l)/2;
            if(A[m]==B)
                return 1;
            else if(A[m]<B)
                return bs(A,B,m+1,l);
            else if(A[m]>B)
                return bs(A,B,f,m-1);
        }
        return 0;
    }
    static int bs2(int[][] A,int B,int f,int l){
        if(f<=l){
            int m=(f+l)/2;
            if(A[m][0]<=B && (m==A.length-1 || A[m+1][0]>B))
                return m;
            else if(A[m][0]<B)
                return bs2(A,B,m+1,l);
            else if(A[m][0]>B)
                return bs2(A,B,f,m-1);
        }
        return -1;
    }
    public static int searchMatrix(int[][] A, int B) {
        int N=A.length;
        int M=A[0].length;
        
        int t=bs2(A,B,0,N-1);
        return t!=-1?bs(A[t],B,0,M-1):0;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int N=ob.nextInt();
        int M=ob.nextInt();
    		    
    	int[][] Array=new int[N][M];
    		    
    	for (int i=0; i<N ;i++ ){
            for (int j=0; j<M ;j++ ){
                Array[i][j]=ob.nextInt();
            }
    	}

        int B=ob.nextInt();

        System.out.println(searchMatrix(Array,B));
    }
}
