import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Given a string A representing an absolute path for a file (Unix-style).

Return the string A after simplifying the absolute path.

Note:

Absolute path always begin with ’/’ ( root directory ).

Path will not have whitespace characters.




Input Format

The only argument given is string A.
Output Format

Return a string denoting the simplified absolue path for a file (Unix-style).
For Example

Input 1:
    A = "/home/"
Output 1:
    "/home"

Input 2:
    A = "/a/./b/../../c/"
Output 2:
    "/c"
 */
public class SimplifyDirectoryPath {
    public static String simplifyPath(String A) {
        //Double ended queue can be used as stack normal push and pop from last
        //and as queue using polllast from starting
        if(A==null) return A;
        Deque<String> stck = new ArrayDeque<String> ();
        String[] folders = A.split("/");
        StringBuilder sb=new StringBuilder();
        
        for(String folder:folders){
            if(!folder.isEmpty() && !folder.equals(".")){
                if(folder.equals("..")){
                    if(!stck.isEmpty())    stck.pop();
                }
                else{
                    stck.push(folder);
                }
            }
        }
        
        if(stck.isEmpty())  return "/";
        while(!stck.isEmpty()){
            sb.append("/"+stck.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        String A=ob.next();
        String res=simplifyPath(A);
        System.out.println("Simplified Directory Path: "+res);
    }
}
