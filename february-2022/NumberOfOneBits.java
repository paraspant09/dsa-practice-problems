import java.util.Scanner;
/**
 * Problem Description

Write a function that takes an integer and returns the number of 1 bits it has.


Problem Constraints
1 <= A <= 109


Input Format
First and only argument contains integer A


Output Format
Return an integer as the answer


Example Input
Input1:
    11


Example Output
Output1:
3


Example Explanation
Explaination1:
11 is represented as 1101 in binary 
 */
public class NumberOfOneBits {
    public static int numSetBits(long a) {
        int count=0;
        while(a>0){
            if((a & 1) == 1)  count++;
            a=a>>1;
        }
        return count;
	}
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        long A=ob.nextLong();

        System.out.println(numSetBits(A));
    }
}
