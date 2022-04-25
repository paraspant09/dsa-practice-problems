import java.util.Scanner;
import java.util.Stack;

/**
 * Problem Description
 
Given a string A denoting an expression. It contains the following operators '+', '-', '', '/'.

Chech whether A has redundant braces or not.

NOTE: A will be always a valid expression.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument given is string A.



Output Format
Return 1 if A has redundant braces, else return 0.



Example Input
Input 1:

 A = "((a+b))"
Input 2:

 A = "(a+(a+b))"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation*
Explanation 1:

 ((a+b)) has redundant braces so answer will be 1.
Explanation 2:

 (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
 */
public class RedundantBraces {
    public static int braces(String A) {
        // This problem does not test anything, dont bother with operator precedence or any other way to solve this.
        // The way to pass test cases is
        // if between opening and closing brace you have variable and operator
        // for eg (-a) is valid (a) is not
        // (a+b)(c+d) is valid
        // ((a+b)(c+d)) is not valid why because (a+b) (c+d) are expressions valid but (*) is not valid.
        // This is how this shit problems logic is
        Stack<Character> stck=new Stack<Character>();
        boolean var=false;
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(ch=='('){
                var=false;
                stck.push('(');
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                if(!stck.isEmpty() && stck.peek()!='o')    stck.push('o');
            }
            else if(ch==')'){
                var=false;
                if(stck.peek()=='(')    return 1;
                char one=stck.pop(),two=stck.pop();
                if((one=='o' && two=='v') || (one=='v' && two=='o')){
                    stck.pop();
                }
                else    return 1;
            }
            else if(!var){
                var=true;
                stck.push('v');
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        String A=ob.next();
        int res=braces(A);
        if(res==1)  System.out.println("Redundant Braces.");
        else    System.out.println("No Redundant Braces.");
    }
}
