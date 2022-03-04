import java.util.Arrays;
import java.util.Scanner;
/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 

Return the sum of the three integers.

Assume that there will only be one solution

Example: 

given array S = {-1 2 1 -4}, 

and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
public class ThreeSum {
    public static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);

        int j=0,k=0;
        long min=Integer.MAX_VALUE,minSum=0;
        for(int i=0;i<A.length-2;i++){
            j=i+1;
            k=A.length-1;
            long tst=B-A[i];
            while(j<k){
                long diff=(A[j]+A[k]-tst);
                if(min > Math.abs(diff)){
                    minSum=A[i]+A[j]+A[k];
                    min=Math.abs(diff);
                }
                if(diff>0)  k--;
                else    j++;
            }
        }
        return (int)minSum;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int N=ob.nextInt();

        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=ob.nextInt();
        }
        int B=ob.nextInt();

        System.out.println(threeSumClosest(A,B));
    }
}
