import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Input Format:

    First and only argument of input contains an integer array A
Output Format:

    return a single integer.
Constraints:

2 <= N <= 5 000 000  
0 <= A[i] <= INT_MAX
For Examples :

Example Input 1:
    A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Example Output 1:
    4
Explanation:
    4 occur exactly once
Example Input 2:
    A = [0, 0, 0, 1]
Example Output 2:
    1
 */
public class SingleNumber2_HashMap {
    public static int singleNumber(final int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<A.length;i++){
            if(map.get(A[i])!=null)
                map.put(A[i],map.get(A[i])+1);
            else
                map.put(A[i],1);
        }
        for (Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue()==1) return e.getKey();
        }
        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        int n=ob.nextInt();
        int A[]=new int[n];
        for(int i=0;i<n;i++)
            A[i]=ob.nextInt();

        System.out.println(singleNumber(A));
    }
}
