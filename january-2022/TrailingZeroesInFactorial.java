import java.util.Scanner;

/**
 * Problem Description

Given an integer A, return the number of trailing zeroes in A!.

Note: Your solution should be in logarithmic time complexity.



**Problem Constraints**
1 <= A <= 10000



**Input Format**
First and only argumment is integer A.



**Output Format**
Return an integer, the answer to the problem.



**Example Input**
Input 1:

 A = 4
Input 2:

 A = 5


**Example Output**
Output 1:

 0
Output 2:

 1


**Example Explanation**
Explanation 1:

 4! = 24
Explanation 2:

 5! = 120
 */
public class TrailingZeroesInFactorial {
    public static int trailingZeroes(int A) {
        int i=5,num=0;
        while(i<=A){
            num+=(A/i);
            i*=5;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int k=ob.nextInt();

        System.out.println(trailingZeroes(k));
    }
}
