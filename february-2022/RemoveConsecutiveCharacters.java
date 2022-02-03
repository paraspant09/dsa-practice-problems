import java.util.Scanner;
/**
 * Problem Description

Given a string A and integer B, remove all consecutive same characters that have length exactly B.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= |A|



Input Format
First Argument is string A.

Second argument is integer B.



Output Format
Return a string after doing the removals.



Example Input
Input 1:

A = "aabcd"
B = 2
Input 2:

A = "aabbccd"
B = 2


Example Output
Output 1:

 "bcd"
Output 2:

 "d"


Example Explanation
Explanation 1:

 "aa" had length 2.
Explanation 2:

 "aa", "bb" and "cc" had length of 2.
 */
public class RemoveConsecutiveCharacters {
    public static String solve(String A, int B) {
        int len=A.length();
        StringBuilder sb=new StringBuilder();
        boolean chk=false;
        
        for(int i=0;i<len;){
            String sub;
            if(i+B >= len)  sub=A.substring(i,len);
            else    sub=A.substring(i,i+B);
            chk=false;
            char f=sub.charAt(0);
            for(int j=1;j<sub.length();j++){
                char ch=sub.charAt(j);
                if(f!=ch){
                    chk=true;
                    break;
                }
            }
            if(sub.length()==1 || chk){
                sb.append(A.charAt(i));
                i++;
                continue;
            }
            i=i+B;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        String A=ob.next();
        int B=ob.nextInt();
    	
        System.out.println(solve(A,B));
    }
}
