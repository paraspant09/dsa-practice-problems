import java.util.Scanner;

/**
 * Problem Description

You are given an integer N and the task is to reverse the digits of the given integer. Return 0 if the result overflows and does not fit in a 32 bit signed integer


Look at the example for clarification.



Problem Constraints
N belongs to the Integer limits.



Input Format
Input an Integer.



Output Format
Return a single integer denoting the reverse of the given integer.



Example Input
Input 1:

 x = 123


Input 2:

 x = -123


Example Output
Output 1:

 321


Ouput 2:

 -321


Example Explanation
 If the given integer is negative like -123 the output is also negative -321.
 */
public class ReverseInteger {
    public static int reverse(int A) {
        try {
            StringBuilder num=new StringBuilder(Integer.toString(A));
            int i=0,j=i;
            int len=num.length();
            int end=len/2;
            if(num.charAt(0)=='-'){
                i=1;
                end+=1;
            }
            for(;i<end;i++,j++){
                char s=num.charAt(i);
                num.setCharAt(i,num.charAt(len-1-j));
                num.setCharAt(len-1-j,s);
            }
            return Integer.parseInt(num.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int k=ob.nextInt();

        System.out.println(reverse(k));
    }
}
