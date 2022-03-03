import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem Description

Given an one-dimensional unsorted array A containing N integers.

You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.

Return 1 if any such pair exists else return 0.



Problem Constraints
1 <= N <= 105
-103 <= A[i] <= 103
-105 <= B <= 105


Input Format
First argument is an integer array A of size N.

Second argument is an integer B.



Output Format
Return 1 if any such pair exists else return 0.



Example Input
Input 1:

 A = [5, 10, 3, 2, 50, 80]
 B = 78
Input 2:

 A = [-10, 20]
 B = 30


Example Output
Output 1:

 1
Output 2:

 1


Example Explanation
Explanation 1:

 Pair (80, 2) gives a difference of 78.
Explanation 2:

 Pair (20, -10) gives a difference of 30 i.e 20 - (-10) => 20 + 10 => 30
 */
public class PairWithGivenDifference {
    public static int solve(int[] A, int B) {
        Map<Integer,Integer> tble=new HashMap<Integer,Integer>();
        //we want to find A[j]-A[i]=B , we store A[i]+B in HashMap and finding A[j] in map
        for(int i=0;i<A.length;i++){
            tble.put(A[i]+B,1);
        }
        if(B==0)    return (A.length-tble.size())>0?1:0; 
        for(int i=0;i<A.length;i++){
            if(tble.get(A[i])!=null)
                return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int N=ob.nextInt();

        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=ob.nextInt();
        }
        int B=ob.nextInt();

        System.out.println(solve(A,B));
    }
}