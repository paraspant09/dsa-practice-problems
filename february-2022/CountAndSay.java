import java.util.Scanner;

/**
 * Problem Description

The count-and-say sequence is the sequence of integers beginning as follows: 
1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11. 11 is read off as two 1s or 21.
21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2, the sequence is 11.
 */
public interface CountAndSay {
    public static String countAndSay(int A) {
        StringBuffer sb=new StringBuffer("1");

        for(int i=2;i<=A;i++){
            char ch=sb.charAt(0);
            int cnt=1;
            StringBuffer newsb=new StringBuffer("");
            for(int j=1;j<sb.length();j++){
                if(ch!=sb.charAt(j)){
                    newsb.append(""+cnt+ch);
                    cnt=1;
                    ch=sb.charAt(j);
                }
                else
                    cnt++;
            }
            newsb.append(""+cnt+ch);
            sb.delete(0, sb.length());
            sb.append(newsb);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int A=ob.nextInt();

        System.out.println(countAndSay(A));
    }
}
