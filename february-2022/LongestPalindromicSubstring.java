import java.util.Scanner;

/**
 * Problem Description

Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:

A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the longest palindromic substring of string A.



Example Input
A = "aaaabaaa"


Example Output
"aaabaaa"


Example Explanation
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String A) {
        int len=A.length();
        boolean[][] dp=new boolean[len][len];
        int pos_i=0,pos_j=0;
        boolean chk=false;
        int a=0;
        for(int i=0;i<len;i++){
            chk=false;
            for(int j=0;j<len-i;j++){
                if(A.charAt(j)!=A.charAt(j+a)){
                    dp[j][j+a]=false;
                }
                else{
                    if(a<2 || dp[j+1][j+a-1]){
                        dp[j][j+a]=true;
                        if(!chk){
                            pos_i=j;
                            pos_j=j+a;
                        }
                        chk=true;
                    }
                    else{
                        dp[j][j+a]=false;
                    }
                }
            }
            a++;
        }
        return A.substring(pos_i,pos_j+1);
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        String A=ob.next();

        System.out.println(longestPalindrome(A));
    }
}
