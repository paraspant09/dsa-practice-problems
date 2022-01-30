import java.util.Scanner;
/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PalindromeString {
    public static int isPalindrome(String A) {
        int len=A.length();
        int j=len-1;
        int i=0;
        while(i<j){
            if(!(A.charAt(i)>=65 && A.charAt(i)<=90) && !(A.charAt(i)>=48 && A.charAt(i)<=57) && 
            !(A.charAt(i)>=97 && A.charAt(i)<=122)){
                i++;
                continue;
            }
            if(!(A.charAt(j)>=65 && A.charAt(j)<=90) && !(A.charAt(j)>=48 && A.charAt(j)<=57) && 
            !(A.charAt(j)>=97 && A.charAt(j)<=122)){
                j--;
                continue;
            }
            if(Character.toLowerCase(A.charAt(i))!=Character.toLowerCase(A.charAt(j))){
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        String s=ob.next();
    	
        System.out.println(isPalindrome(s));
    }
}
