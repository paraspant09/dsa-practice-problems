import java.util.Scanner;

/**
 * Problem Description
 
Given a string A and integer B, what is maximal lexicographical string that can be made from A if you do atmost B swaps.

Problem Constraints
1 <= |A| <= 9

A contains only digits from 0 to 9.

1 <= B <= 5



Input Format
First argument is string A.

Second argument is integer B.



Output Format
Return a string, the naswer to the problem.



Example Input
Input 1:

A = "254"
B = 1
Input 2:

A = "254"
B = 2


Example Output
Output 1:

 524
Output 2:

 542


Example Explanation
Explanation 1:

 Swap 2 and 5.
Explanation 2:

Swap 2 and 5 then swap 4 and 2.
 */
public class MaximalString {
    static String swapTwoCharacterInString(String s,int i,int j){
        StringBuilder sb=new StringBuilder(s);
        char tmpChar=sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,tmpChar);
        return sb.toString();
    }
    static String maxString(String A,String B){
        if(Integer.parseInt(A)>Integer.parseInt(B))
            return A;
        return B;
    }
    static void recurse(String s,int i,int j,int B,StringBuilder max){
        if(B==0 || (i==s.length()-1))   return;
        //swap
        String swappedString=swapTwoCharacterInString(s,i,j);
        max.replace(0, max.length(), maxString(max.toString(),swappedString));
        recurse(swappedString,i,j,B-1,max);
        //no swap
        if(j!=s.length()-1) recurse(s,i,j+1,B,max);
        else    recurse(s,i+1,i+2,B,max);
    }
    public static String solve(String A, int B) {
        StringBuilder max=new StringBuilder(A);
        recurse(A,0,1,B,max);
        return max.toString();
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        String A=ob.next();
        int B=ob.nextInt();

        System.out.println(solve(A,B));
    }
}
