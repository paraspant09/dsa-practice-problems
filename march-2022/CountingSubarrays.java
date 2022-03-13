import java.util.Scanner;

/**
 * Problem Description

Given an array A of N non-negative numbers and you are also given non-negative number B.

You need to find the number of subarrays in A having sum less than B. We may assume that there is no overflow.



Problem Constraints
1 <= N <= 104

1 <= A[i] <= 100

1 <= B <= 108



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the number of subarrays in A having sum less than B.



Example Input
Input 1:

 A = [2, 5, 6]
 B = 10
Input 2:

 A = [1, 11, 2, 3, 15]
 B = 10


Example Output
Output 1:

 4
Output 2:

 4


Example Explanation
Explanation 1:

 The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
Explanation 2:

 The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
 */
public class CountingSubarrays {
    public static int solve(int[] A, int B) {
        int cnt=0;
        int i=0,j=1;
        int sum=0;
        if(A.length>1){
            sum=A[0];
            if(A[0]<B)  cnt++;
        }
        while(i<A.length && j<A.length){
            if(A[j]+sum < B){
                cnt+=(j-i)+1;
                sum+=A[j++];
            }
            else{
                sum-=A[i++];
            }
        }
        
        return cnt;
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
