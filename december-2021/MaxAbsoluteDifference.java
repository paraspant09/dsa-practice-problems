import java.util.Scanner;

/**
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.

f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
 */
public class MaxAbsoluteDifference {
    public static int plusOne(int[] A) {
        int max1=Integer.MIN_VALUE,min1=Integer.MAX_VALUE;
        int max2=Integer.MIN_VALUE,min2=Integer.MAX_VALUE;

        for(int i=0;i<A.length;i++){
            int b=A[i]+(i+1);
            int c=A[i]-(i+1);
            max1=Math.max(max1,b);
            max2=Math.max(max2,c);

            min1=Math.min(min1,b);
            min2=Math.min(min2,c);

        }

        return Math.max(Math.abs(max1-min1),Math.abs(max2-min2));
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        System.out.println(plusOne(Array));
    }
}
