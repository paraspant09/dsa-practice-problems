import java.util.Scanner;

/**
 * Problem Description

Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.

Given an array A of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array. Return the answer modulo 1000000007.



Problem Constraints
1 <= |A| <= 200000

1 <= A[i] <= 109



Input Format
First and only argument is array A.



Output Format
Return one integer, the answer to the problem.



Example Input
Input 1:

 A = [1]
Input 2:

 A = [2, 4, 6]


Example Output
Output 1:

 0
Output 2:

 8


Example Explanation
Explanation 1:

 No pairs are formed.
Explanation 2:

 We return, f(2, 2) + f(2, 4) + f(2, 6) + f(4, 2) + f(4, 4) + f(4, 6) + f(6, 2) + f(6, 4) + f(6, 6) = 8
 */
public class SumOfPairwiseHammingDistance {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int hammingDistance(final int[] A) {
        long sum=0;
        long[] zeroes=new long[32];
        long[] ones=new long[32];

        int j=31;
        for(int i=0;i<A.length;i++){
            int res=A[i];
            j=31;
            while(j>=0){
                if((res&1)==1){
                    ones[j]=((ones[j]+1)%1000000007);
                }
                else
                    zeroes[j]=((zeroes[j]+1)%1000000007);
                
                res=res>>1;
                j--;
            }
        }
        for(int i=0;i<32;i++){
            long mul=((zeroes[i]*ones[i])%1000000007);
            long mul2=((2*mul)%1000000007);
            long mul3=((sum+mul2)%1000000007);
            sum=mul3;
        }
        return (int)(sum%1000000007);
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int n=ob.nextInt();
    		    
    	int[] Array=new int[n];
    		    
    	for (int i=0; i<n ;i++ ){
            Array[i]=ob.nextInt();
    	}

        System.out.println(hammingDistance(Array));
    }
}
