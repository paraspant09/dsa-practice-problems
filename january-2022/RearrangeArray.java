import java.util.Arrays;
import java.util.Scanner;

/**
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
Lets say N = size of the array. Then, following holds true :

All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
 */
public class RearrangeArray {
	public static void arrange(int[] a) {
        int n=a.length;

        for(int i=0;i<n;i++){
            a[i]= a[i]+((a[a[i]]%n)*n);
        }

        for(int i=0;i<n;i++){
            a[i]= a[i]/n;
        }
        
	}
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int n=ob.nextInt();

        int[] A=new int[n];

        for (int i=0; i<n ;i++ ){
            A[i]=ob.nextInt();
    	}

        arrange(A);
        System.out.println(Arrays.toString(A));
    }
}
