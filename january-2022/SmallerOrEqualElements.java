import java.util.Scanner;

/**
 * Given an sorted array A of size N. Find number of elements which are less than or equal to B.

NOTE: Expected Time Complexity O(log N)



Problem Constraints
1 <= N <= 106

1 <= A[i], B <= 109



Input Format
First agument is an integer array A of size N.

Second argument is an integer B.



Output Format
Return an integer denoting the number of elements which are less than or equal to B.



Example Input
Input 1:

 A = [1, 3, 4, 4, 6]
 B = 4
Input 2:

 A = [1, 2, 5, 5]
 B = 3


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 Elements (1, 3, 4, 4) are less than or equal to 4.
Explanation 2:

 Elements (1, 2) are less than or equal to 3.
 */
public class SmallerOrEqualElements {
    public static int bs(int[] A,int B,int f,int l){
        if(f<=l){
            int m=(f+l)/2;
            // if(m==A.length-1)   return m;
            // System.out.println(m);
            if(A[m]<=B && A[m+1]>B){
                return m;
            }
            else if(A[m]<=B){
                return bs(A,B,m+1,l);
            }
            else if(A[m]>B){
                return bs(A,B,f,m-1);
            }
        }
        return -1;
    }

    public static int solve(int[] A, int B) {
        if(A[A.length-1]<=B) return A.length;
        return bs(A,B,0,A.length-1)+1;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int n=ob.nextInt();
    		    
    	int[] Array=new int[n];
    		    
    	for (int i=0; i<n ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        int B=ob.nextInt();

        System.out.println(solve(Array,B));
    }
}
