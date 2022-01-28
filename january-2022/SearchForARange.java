import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm’s runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].




Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

 Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
Constraints

1 <= N <= 10^6
1 <= A[i], B <= 10^9
For Example

Input 1:
    A = [5, 7, 7, 8, 8, 10]
    B = 8
Output 1:
    [3, 4]
Explanation 1:
    First occurence of 8 in A is at index 3
    Second occurence of 8 in A is at index 4
    ans = [3, 4]

Input 2:
    A = [5, 17, 100, 111]
    B = 3
Output 2:
    [-1, -1]
 */
public class SearchForARange {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] searchRange(final int[] A, int B) {
        int f=0,l=A.length-1;
        int m1=-1,m2=-1,m=0;
        while(f<=l){
            m=(f+l)/2;
            if(A[m]==B && (m<=0 || A[m-1]!=B)){
                m1=m;
                break;
            }
            else if(A[m]<B)
                f=m+1;
            else
                l=m-1;
        }
        f=0;
        l=A.length-1;
        while(f<=l){
            m=(f+l)/2;
            if(A[m]==B && (m>=(A.length-1) || A[m+1]!=B)){
                m2=m;
                break;
            }
            else if(A[m]<=B)
                f=m+1;
            else
                l=m-1;
        }
        return new int[]{m1,m2};
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        int B=ob.nextInt();

        System.out.println(Arrays.toString(searchRange(Array,B)));
    }
}
