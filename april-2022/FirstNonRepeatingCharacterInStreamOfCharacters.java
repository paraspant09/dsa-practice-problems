import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Problem Description

Given a string A denoting a stream of lowercase alphabets. You have to make new string B.

B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found then append '#' at the end of B.

Problem Constraints
1 <= length of the string <= 100000

Input Format
The only argument given is string A.

Output Format
Return a string B after processing the stream of lowercase alphabets A.

Example Input
Input 1:

 A = "abadbc"
Input 2:

 A = "abcabc"

Example Output
Output 1:

 "aabbdd"
Output 2:

 "aaabc#"


Example Explanation
Explanation 1:

    "a"      -   first non repeating character 'a'
    "ab"     -   first non repeating character 'a'
    "aba"    -   first non repeating character 'b'
    "abad"   -   first non repeating character 'b'
    "abadb"  -   first non repeating character 'd'
    "abadbc" -   first non repeating character 'd'
Explanation 2:

    "a"      -   first non repeating character 'a'
    "ab"     -   first non repeating character 'a'
    "abc"    -   first non repeating character 'a'
    "abca"   -   first non repeating character 'b'
    "abcab"  -   first non repeating character 'c'
    "abcabc" -   no non repeating character so '#'
 */
public class FirstNonRepeatingCharacterInStreamOfCharacters {
    public static String solve(String A) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        Queue<Character> q=new LinkedList<Character>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            map.put((char)('a'+i),0);
        }
        for(char ch:A.toCharArray()){
            map.put(ch,map.get(ch)+1);
            if(map.get(ch)<=1)    q.add(ch);
            
            while(!q.isEmpty() && map.get(q.peek())>1){
                q.poll();
            }
            if(q.isEmpty())    sb.append("#");
            else    sb.append(q.peek());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        String A=ob.next();

        System.out.println(solve(A));
    }
}
