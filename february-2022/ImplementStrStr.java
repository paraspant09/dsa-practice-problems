import java.util.Scanner;
/**
 * Problem Description

Another question which belongs to the category of questions which are intentionally stated vaguely.

Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Implement strStr().

strstr - locate a substring ( needle ) in a string ( haystack ).

Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

NOTE: String A is haystack, B is needle.

Good clarification questions:

What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases.

 */
public class ImplementStrStr {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int strStr(final String A, final String B) {
        int Alen=A.length();
        int Blen=B.length();

        if(Alen==0 || Blen==0) return 0;
        
        for(int i=0;i<=(Alen-Blen);i++){
            String sub=A.substring(i,i+Blen);
            // System.out.println(sub);
            if(B.equals(sub)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        String A=ob.next();
        String B=ob.next();
    	
        System.out.println(strStr(A,B));
    }
}
