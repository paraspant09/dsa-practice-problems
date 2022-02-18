import java.util.Scanner;
/**
 * Problem Description

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",


return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 */
public class LengthOfLastWord {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int lengthOfLastWord(final String A) {
        int i=A.length()-1;
        int num=0;
        while(i>=0 && A.charAt(i)==' '){
            i--;
        }
        while(i>=0 && A.charAt(i)!=' '){
            num++;
            i--;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int n=ob.nextInt();
        StringBuilder sb=new StringBuilder();
        while(n>0){
            if(n==1){
                sb.append(ob.next());
                break;
            }
            n--;
            sb.append(ob.next()+" ");
        }      

        System.out.println("Word=|"+sb+"|");
        System.out.println(lengthOfLastWord(sb.toString()));
    }
}
