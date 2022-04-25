import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Problem Description
 
 

An arithmetic expression is given by a charater array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each character may be an integer or an operator.



Problem Constraints
1 <= N <= 105



Input Format
The only argument given is character array A.



Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.



Example Input
Input 1:
    A =   ["2", "1", "+", "3", ""]
Input 2:
    A = ["4", "13", "5", "/", "+"]


Example Output
Output 1:
    9
Output 2:
    6


Example Explanation*
Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
 */
public class EvaluateExpression {
    public static int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack=new Stack<Integer>();

        for(int i=0;i<A.size();i++){
            String str=A.get(i);
            if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*")){
                int one=stack.pop(),two=stack.pop(),temp=0;
                if(str.equals("+"))    temp=two+one;
                if(str.equals("-"))    temp=two-one;
                if(str.equals("/"))    temp=two/one;
                if(str.equals("*"))    temp=two*one;
                stack.push(temp);
            }
            else
                stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int N=ob.nextInt();
        ArrayList<String> A=new ArrayList<String>();

        for(int i=0;i<N;i++){
            A.add(ob.next());
        }

        System.out.println("Evaluated Expression value is : "+evalRPN(A));

    }
}
