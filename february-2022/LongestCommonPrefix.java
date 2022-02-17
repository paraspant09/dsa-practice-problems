import java.util.Scanner;

/**
 * Problem Description

Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Input Format
The only argument given is an array of strings A.



Output Format
Return the longest common prefix of all strings in A.



Example Input
Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output
Output 1:

"a"
Output 2:

"ab"


Example Explanation
Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] A) {
        int len=A.length;
        StringBuffer sb=new StringBuffer();

        for(int i=0;i<A[0].length();i++){
            char ch=A[0].charAt(i);
            for(int j=0;j<len;j++){
                if(A[j].length()-1<i || ch!=A[j].charAt(i))
                    return sb.toString();
            }
            sb.append(ch);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int N=ob.nextInt();

        String[] A=new String[N];
        for(int i=0;i<N;i++){
            A[i]=ob.next();
        }
    	
        System.out.println(longestCommonPrefix(A));
    }
}
