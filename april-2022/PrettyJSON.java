import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**
 * Given a string A representating json object. Return an array of string denoting json object with proper indentaion.

Rules for proper indentaion:

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Note:

[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.




Input Format

The only argument given is the integer array A.
Output Format

Return a list of strings, where each entry corresponds to a single line. The strings should not have "\n" character in them.
For Example

Input 1:
    A = "{A:"B",C:{D:"E",F:{G:"H",I:"J"}}}"
Output 1:
    { 
        A:"B",
        C: 
        { 
            D:"E",
            F: 
            { 
                G:"H",
                I:"J"
            } 
        } 
    }

Input 2:
    A = ["foo", {"bar":["baz",null,1.0,2]}]
Output 2:
   [
        "foo", 
        {
            "bar":
            [
                "baz", 
                null, 
                1.0, 
                2
            ]
        }
    ]
 */
public class PrettyJSON {
    static String addT(int n){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            res.append("\t");
        }
        return res.toString();
    }
    public static String[] prettyJSON(String A) {
        ArrayList<String> arr=new ArrayList<String>();
        StringBuilder sb=new StringBuilder();
        Stack<Integer> stck=new Stack<Integer>();

        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(ch=='{' || ch=='['){
                if(sb.length()>0) arr.add(addT(stck.size())+sb.toString());
                arr.add(addT(stck.size())+ch);
                stck.push(1);
                sb=new StringBuilder();
            }
            else if(ch=='}' || ch==']'){
                if(sb.length()>0) arr.add(addT(stck.size())+sb.toString());
                stck.pop();
                if((i+1)<A.length() && A.charAt(i+1)==','){
                    arr.add(addT(stck.size())+ch+',');
                    i++;
                }
                else arr.add(addT(stck.size())+ch);
                sb=new StringBuilder();
            }
            else if(ch==','){
                arr.add(addT(stck.size())+sb.toString()+',');
                sb=new StringBuilder();
            }
            else if(ch!=' '){
                sb.append(""+ch);
            }
        }
        
        return arr.toArray(new String[arr.size()]);
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        String A=ob.next();
        String[] res=prettyJSON(A);
        for(String s:res){
            System.out.println(s);
        }
    }
}
