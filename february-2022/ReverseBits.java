import java.util.Scanner;
/**
 * Problem Description

Reverse the bits of an 32 bit unsigned integer A.



Problem Constraints
0 <= A <= 232



Input Format
First and only argument of input contains an integer A.



Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.



Example Input
Input 1:

 0
Input 2:

 3


Example Output
Output 1:

 0
Output 2:

 3221225472


Example Explanation
Explanation 1:

        00000000000000000000000000000000

=>      00000000000000000000000000000000
Explanation 2:

        00000000000000000000000000000011    
=>      11000000000000000000000000000000
 */
public class ReverseBits {
    public static long reverse(long a) {
        long res=0;
        
        int i=0;
        while(i<32){
            if((a&1)==1){
                res=res|1;
            }
            if(i!=31){
                res=res<<1;
                a=a>>1;
            }
            i++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        long A=ob.nextLong();

        System.out.println(reverse(A));
    }
}
