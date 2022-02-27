import java.util.Scanner;
/**
 * Problem Description

Given an integer A, count and return the number of trailing zeroes.



Problem Constraints
1 <= A <= 109



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the count of trailing zeroes.



Example Input
Input 1:

 A = 18
Input 2:

 A = 8


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 18 in binary is represented as: 10010, there is 1 trailing zero.
Explanation 2:

 8 in binary is represented as: 1000, there are 3 trailing zeroes.
 */
public class TrailingZeroes {
    public static int solve(int A) {
        int count=0;
        while((A&1)==0){
            count++;
            A=A>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int A=ob.nextInt();

        System.out.println(solve(A));
    }
}
