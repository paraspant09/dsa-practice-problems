import java.util.Scanner;
/**
 * Problem Description

Given a string A consisting of lowercase characters.

You have to find the number of substrings in A which starts with vowel and end with consonants or vice-versa.

Return the count of substring modulo 109 + 7.



Problem Constraints
1 <= |A| <= 105

A consists only of lower-case characters.



Input Format
First argument is an string A.



Output Format
Return a integer denoting the the number of substrings in A which starts with vowel and end with consonants or vice-versa with modulo 109 + 7.



Example Input
Input 1:

 A = "aba"
Input 2:

 A = "a"


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

 Substrings of S are : [a, ab, aba, b, ba, a]Out of these only 'ab' and 'ba' satisfy the condition for special Substring. So the answer is 2.
Explanation 2:

 No possible substring that start with vowel and end with consonant or vice-versa.
 */
public class VowelAndConsonantSubstrings {
    public static int solve(String A) {
        int len=A.length();
        int count=0;
        int n=0,n2=0;
        int M = (int)1e9+7;
        for(int i=0;i<len;i++){
            char s=A.charAt(i);
            if(s=='a'|| s=='e' || s=='i' || s=='o' || s=='u'){
                n=(n+1);
            }
            else{
                count=(count+n)%M;
            }
            if(s!='a' && s!='e' && s!='i' && s!='o' && s!='u'){
                n2=(n2+1);
            }
            else{
                count=(count+n2)%M;
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        String s=ob.next();
    	
        System.out.println(solve(s));
    }
}
