import java.util.Scanner;

/**
 * Problem Description

Given a string A consisting of lowercase characters.

We need to tell minimum characters to be appended (insertion at end) to make the string A a palindrome.



Problem Constraints
1 <= |A| <= 105

A consists only of lower-case characters.



Input Format
First argument is an string A.



Output Format
Return a integer denoting the minimum characters to be appended (insertion at end) to make the string A a palindrome.



Example Input
Input 1:

 A = "abede"
Input 2:

 A = "aabb"


Example Output
Output 1:

 2
Output 2:

 2


Example Explanation
Explanation 1:

 We can make string palindrome as "abedeba" by adding ba at the end of the string.
Explanation 2:

 We can make string palindrome as "aabbaa" by adding aa at the end of the string.
 */
public class MinimumAppendsForPalindrome {
    public static int solve(String A) {
        int len=A.length();
        int i=0,j=len-1;
        int num=0;
        while(i<len && i<j){
            if(A.charAt(i)!=A.charAt(j)){
                num++;
                i=num;
                j=len-1;
            }
            else{
                i++;
                j--;
            }
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        String A=ob.next();

        System.out.println(solve(A));
    }
}
