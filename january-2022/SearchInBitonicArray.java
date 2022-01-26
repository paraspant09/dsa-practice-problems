import java.util.Scanner;

/**
 * Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

NOTE:

A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.


Problem Constraints
3 <= N <= 105

1 <= A[i], B <= 108

Given array always contain a bitonic point.

Array A always contain distinct elements.



Input Format
First argument is an integer array A denoting the bitonic sequence.

Second argument is an integer B.



Output Format
Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.



Example Input
Input 1:

 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20
Input 2:

 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30


Example Output
Output 1:

 3
Output 2:

 -1


Example Explanation
Explanation 1:

 B = 20 present in A at index 3
Explanation 2:

 B = 30 is not present in A
 */
public class SearchInBitonicArray {
    public static int find(int[] A,int f,int l){
        if(f<=l){
            int m=(f+l)/2;
                
            if(A[m]>A[m-1] && A[m]>A[m+1]){
                return m;
            }
            else if(A[m]>A[m-1] && A[m]<A[m+1]){
                return find(A,m+1,l);
            }
            else if(A[m]<A[m-1] && A[m]>A[m+1]){
                return find(A,f,m-1);
            }
        }
        return -1;
    }
    public static int bsIncreasing(int[] A,int B,int f,int l){
        if(f<=l){
            int m=(f+l)/2;    
            if(A[m]==B){
                return m;
            }
            else if(A[m]>B){
                return bsIncreasing(A,B,f,m-1);
            }
            else if(A[m]<B){
                return bsIncreasing(A,B,m+1,l);
            }
        }
        return -1;
    }
    public static int bsDecreasing(int[] A,int B,int f,int l){
        if(f<=l){
            int m=(f+l)/2;    
            if(A[m]==B){
                return m;
            }
            else if(A[m]>B){
                return bsDecreasing(A,B,m+1,l);
            }
            else if(A[m]<B){
                return bsDecreasing(A,B,f,m-1);
            }
        }
        return -1;
    }
    public static int solve(int[] A, int B) {
        int bpoint=find(A,0,A.length-1);
        if(A[bpoint]==B)    return bpoint;
        int left=bsIncreasing(A,B,0,bpoint-1);
        if(left!=-1)    return left;
        return bsDecreasing(A,B,bpoint+1,A.length-1);
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

