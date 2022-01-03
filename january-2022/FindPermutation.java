import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes

Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]
 */
public class FindPermutation {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> nextPermutation(final String A, int B) {
        ArrayList<Integer> arr=new ArrayList<>();
        int[] stack=new int[B];
        for(int i=0;i<B;i++){
            stack[i]=i+1;
        }
        int s=0,e=B-1;

        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(ch=='I'){
                arr.add(stack[s++]);
            }
            else{
                arr.add(stack[e--]);
            }
        }
        arr.add(stack[s]);
        return arr;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        String str=ob.next();

        int n=ob.nextInt();
    		    
        System.out.println(nextPermutation(str,n).toString());
    }
}
