import java.util.Scanner;

/**
 * Problem Description

Given a numeric string A representing a large number you need to find the next smallest palindrome greater than this number.



Problem Constraints
1 <= |A| <= 100

A doesn't start with zeroes and always contain digits from 0-9.



Input Format
First and only argument is an string A.



Output Format
Return a numeric string denoting the next smallest palindrome greater than A.



Example Input
Input 1:

 A = "23545"
Input 2:

 A = "999"


Example Output
Output 1:

 "23632"
Output 2:

 "1001"
 */
public class NextSmallestPalindrome {
    public static String solve(String A) {
        StringBuilder sb=new StringBuilder(A);
        int len=A.length(); 

        int mid=(len/2),val=0;
        boolean chk=false;
        int l=(len&1)==0?0:1;
        for(int i=mid-1;i>=0;i--){
            if(Integer.parseInt(""+sb.charAt(i))<Integer.parseInt(""+sb.charAt(mid+l))){
                chk=true;
                break;
            }
            else if(Integer.parseInt(""+sb.charAt(i))>Integer.parseInt(""+sb.charAt(mid+l))){
                break;
            }
            l++;
        }
        if(mid+l == len) chk=true;
        
        for(int i=0;i<(len/2);i++){
            sb.setCharAt(len-1-i,sb.charAt(i));
        }

        if(!chk)    return sb.toString();
        if((len&1)==1){
            val=(Integer.parseInt(""+sb.charAt(mid))+1)%10;
            sb.setCharAt(mid,(""+val).charAt(0));
        }

        if(val==0){
            int k=(len&1)==0?0:1;
            int i=mid-1;
            for(;i>=0;i--){
                val=(Integer.parseInt(""+sb.charAt(i))+1)%10;
                sb.setCharAt(i,(""+val).charAt(0));
                sb.setCharAt(mid+k,(""+val).charAt(0));
                k++;
                if(val!=0)  break;
            }
            if(val==0 && i<0){
                sb.setCharAt(sb.length()-1,'1');
                return "1"+sb.toString();
            }  
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        String str=ob.next();
    		    
        System.out.println(solve(str));
    }
}
