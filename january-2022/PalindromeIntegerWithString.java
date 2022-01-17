import java.util.Scanner;

/**
 * Problem Description

Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed. Negative numbers are not palindromic.

Example :

Input : 12121
Output : True


Input : 123
Output : False
 */
public class PalindromeIntegerWithString {
    public static int isPalindrome(int A) {
        String num=Integer.toString(A);
        int len=num.length();
        for(int i=0;i<len/2;i++){
            if(num.charAt(i)!=num.charAt(len-1-i)){
                return 0;
            }
        }
        
        return 1;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int k=ob.nextInt();

        System.out.println(isPalindrome(k));
    }
}
