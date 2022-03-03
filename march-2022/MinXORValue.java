import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

Input Format:

    First and only argument of input contains an integer array A
Output Format:

    return a single integer denoting minimum xor value
Constraints:

2 <= N <= 100 000  
0 <= A[i] <= 1 000 000 000
For Examples :

Example Input 1:
    A = [0, 2, 5, 7]
Example Output 1:
    2
Explanation:
    0 xor 2 = 2
Example Input 2:
    A = [0, 4, 7, 9]
Example Output 2:
    3
 */
public class MinXORValue {
    public static int findMinXor(int[] A) {
        Arrays.sort(A);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.length-1;i++){
            min=Math.min(min,A[i]^A[i+1]);
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int N=ob.nextInt();

        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=ob.nextInt();
        }

        System.out.println(findMinXor(A));
    }
}