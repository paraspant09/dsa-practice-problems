import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given an array with n objects colored red, white or blue, 

sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]
 */
public class SortByColor {
    public static void sortColors(ArrayList<Integer> a) {
		int i=0,j=a.size()-1;
		int[] arr=new int[a.size()];
		for(int k=0;k<a.size();k++){
			int val=a.get(k);
			if(val==0)	arr[i++]=0;
			if(val==2)	arr[j--]=2;
		}
		while(i<=j){
			arr[i++]=1;
		}
		for(int k=0;k<a.size();k++){
			a.set(k,arr[k]);
		}
	}
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<Integer> a=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            a.add(ob.nextInt());
        }
        sortColors(a);
        
        System.out.println(a.toString());
    }
}
