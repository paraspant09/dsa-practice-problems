import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem Description
 
 

Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified. You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

Pad extra spaces ' ' when necessary so that each line has exactly L characters. Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right. For the last line of text, it should be left justified and no extra space is inserted between words.

Your program should return a list of strings, where each string represents a single line.

Example:

words: ["This", "is", "an", "example", "of", "text", "justification."]


L: 16.



Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Note: Each word is guaranteed not to exceed L in length. 
 */
public class JustifiedText {
    static StringBuilder fit(String sb,int tot,int B){
        StringBuilder res=new StringBuilder();
        String[] words=sb.split(" ");
        int i=0,spaces=(B-tot),leftwords=words.length-1;
        double numOfpsaces=0;

        while(i<words.length-1){
            numOfpsaces=Math.ceil((double)spaces/leftwords);
            res.append(words[i++]+String.format("%"+numOfpsaces+"s", ""));
            spaces-=numOfpsaces;
            leftwords--;
        }
        res.append(words[i]);

        return res;
    }
    public static String[] fullJustify(String[] A, int B) {
        ArrayList<String> res=new ArrayList<String>();
        for(int i=0;i<A.length;i++){
            int j=i,tot=A[i].length();
            StringBuilder sb=new StringBuilder();
            sb.append(A[j]);
            while((j+1)<A.length && B-(sb+" "+A[j+1]).length() >=0 ){
                j++;
                sb.append(" "+A[j]);
                tot+=A[j].length();
            }
            if(j<A.length-1 && sb.length()!=B){
                sb=fit(sb.toString(),tot,B);
            }
            i=j;
            if((B-sb.length())>0)    sb.append(String.format("%"+(B-sb.length())+"s", ""));
            res.add(sb.toString());
        }
        return res.toArray(new String[res.size()]);
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        int N=ob.nextInt();
        String[] A=new String[N];

        for(int i=0;i<N;i++){
            A[i]=ob.next();
        }
        int B=ob.nextInt();
        String[] res=fullJustify(A,B);
        for(String s:res){
            System.out.println("|"+s+"|");
        }
    }
}
