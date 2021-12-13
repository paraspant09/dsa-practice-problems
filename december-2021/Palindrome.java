import java.util.*;
class Palindrome {
    public static boolean isPalindrome(int x) {
        String str=Integer.toString(x);
        int len=str.length();
        for(int i=0;i<len;i++){
            if(str.charAt(i)!=str.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
    	    
    	int num=ob.nextInt();

        System.out.println(isPalindrome(num));
    }
}