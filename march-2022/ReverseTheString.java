import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given a string A.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.

Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.

If there are multiple spaces between words, reduce them to a single space in the reversed string.




Input Format

The only argument given is string A.
Output Format

Return the string A after reversing the string word by word.
For Example

Input 1:
    A = "the sky is blue"
Output 1:
    "blue is sky the"

Input 2:
    A = "this is ib"
Output 2:
    "ib is this"
 */
public class ReverseTheString {
    public static String solve(String A) {
        int i=0;
        A=A.trim();
        ArrayList<String> res=new ArrayList<String>();
        StringBuilder left=new StringBuilder();

        while(i<A.length()){
            if(A.charAt(i)!=' '){
                left.append(A.charAt(i));
            }
            else{
                if(left.length()!=0){
                    res.add(left.toString());
                    left.delete(0, left.length());
                }
            }
            i++;
        }
        res.add(left.toString());
        left.delete(0, left.length());
        for(int j=res.size()-1;j>=0;j--){
            left.append(res.get(j));
            if(j!=0)    left.append(" ");
        }
        return left.toString();
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        String A=ob.nextLine();

        System.out.println(solve(A));
    }
}
