import java.util.Arrays;
import java.util.Scanner;

public class RightRotateArray {
    public static void rotate(int[] nums, int k) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[(i+k)%nums.length]=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int N=ob.nextInt();
        int k=ob.nextInt();

        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=ob.nextInt();
        }
    	rotate(A,k);
        System.out.println(Arrays.toString(A));
    }
}
