import java.util.ArrayList;
import java.util.Scanner;

/**
 * Remove Element

Given an array and a value, remove all the instances of that value in the array. 

Also return the number of elements left in the array after the operation.

It does not matter what is left beyond the expected length.

Example:

If array A is [4, 1, 1, 2, 1, 3]

and value elem is 1, 

then new length is 3, and A is now [4, 2, 3]

Try to do it in less than linear additional space complexity.
 */
public class RemoveElementFromArray {
    public static int removeElement(ArrayList<Integer> a, int b) {
        int i=0,j=0;
        while(j<a.size()){
            int val=a.get(j);
            if(val!=b){
                a.set(i,val);
                i++;
            }
            j++;
        }
        return i;
	}
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<Integer> a=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            a.add(ob.nextInt());
        }
        int B=ob.nextInt();
        int lst=removeElement(a,B);
        for(int i=0;i<lst;i++){
            System.out.print(a.get(i)+",");
        }
    }
}
