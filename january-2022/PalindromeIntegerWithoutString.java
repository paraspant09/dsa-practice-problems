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
public class PalindromeIntegerWithoutString {
    public static int isPalindrome(int A) {
        int num=0,place=1,n=0;
        int temp=A;
        if(A<0) return 0;
        while(temp!=0){
            n++;
            temp/=10;
        }
        temp=A;
        place=(int)Math.pow(10,n-1);
        while(temp!=0){
            num+=((temp%10)*place);
            temp/=10;
            place/=10;
        }
        if(A!=num){
                return 0;
        }
        
        return 1;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int k=ob.nextInt();

        System.out.println(isPalindrome(k));
    }
}
