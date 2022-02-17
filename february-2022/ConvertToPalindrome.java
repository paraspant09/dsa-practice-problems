import java.util.Scanner;
/**
 * Problem Description

Given a string A consisting only of lowercase characters, we need to check whether it is possible to make this string a palindrome after removing exactly one character from this.

If it is possible then return 1 else return 0.



Problem Constraints
3 <= |A| <= 105

 A[i] is always a lowercase character.



Input Format
First and only argument is an string A.



Output Format
Return 1 if it is possible to convert A to palindrome by removing exactly one character else return 0.



Example Input
Input 1:

 A = "abcba"
Input 2:

 A = "abecbea"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 We can remove character ‘c’ to make string palindrome
Explanation 2:

 It is not possible to make this string palindrome just by removing one character 
 */
public class ConvertToPalindrome {
    public static int Pal(String A,boolean is,int s,int e){
        if(s>=e){
            return 1;
        }
            
        if(A.charAt(s)==A.charAt(e)){
            return Pal(A,is,s+1,e-1);
        }
        if(!is) return 0;
        return Pal(A,!is,s+1,e) | Pal(A,!is,s,e-1);
    }
    
    public static int solve(String A) {
        int len=A.length();
        
        return Pal(A,true,0,len-1);
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        String A=ob.next();

        System.out.println(solve(A));
    }
}
