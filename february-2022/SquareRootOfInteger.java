import java.util.Scanner;

/**
 * Problem Description

Given an integer A.

Compute and return the square root of A.

If A is not a perfect square, return floor(sqrt(A)).

DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.

NOTE: Do not use sort function from standard library. Users are expected to solve this in O(log(A)) time.



Input Format
The first and only argument given is the integer A.



Output Format
Return floor(sqrt(A))



Example Input
Input 1:

 11
Input 2:

 9


Example Output
Output 1:

 3
Output 2:

 3


Example Explanation
Explanation:

 When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 When A = 9 which is a perfect square of 3, so we return 3.
 */
public class SquareRootOfInteger {
    public static int sqrt(int A) {
        long l=1;
        long h=A;//Or 1e9
        long m=0;
        while(l<=h){
            m=l+(h-l)/2;
            if(m*m>A)
                h=m-1;
            else if(m*m <= A)
                l=m+1;
        }
        return (int)h;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int N=ob.nextInt();
        
        System.out.println(sqrt(N));
    }
}
