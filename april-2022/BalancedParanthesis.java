import java.util.Scanner;

/**
 * Problem Description

Given a string A consisting only of '(' and ')'.

You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
First argument is an string A.



Output Format
Return 1 if parantheses in string are balanced else return 0.



Example Input
Input 1:

 A = "(()())"
Input 2:

 A = "(()"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Given string is balanced so we return 1
Explanation 2:

 Given string is not balanced so we return 0
 */
public class BalancedParanthesis {
    public static int solve(String A) {
        int numOfOpenParanthesis=0;

        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(ch=='(')
                numOfOpenParanthesis++;
            else{
                if(numOfOpenParanthesis==0)
                    return 0;
                else
                    numOfOpenParanthesis--;
            }
        }
        if(numOfOpenParanthesis==0)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        String A=ob.next();
        int res=solve(A);
        if(res==1)  System.out.println("Paranthesis are balanced.");
        else    System.out.println("Paranthesis are not balanced.");
    }
}
