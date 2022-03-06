import java.util.ArrayList;
import java.util.Scanner;

/**
 * Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,

Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(ArrayList<Integer> a) {
        int i=0,j=1;
        Integer cur=a.get(i);
		while(i<a.size() && j<a.size()){
            int A=a.get(i);
            int B=a.get(j);
			if(A!=B || cur!=null){
				i++;
				a.set(i,B);
                if(A!=B)  cur=a.get(j);
                else    cur=null;
			}
			j++;
		}
		return i+1;
	}
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<Integer> A=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            A.add(ob.nextInt());
        }
        int lst=removeDuplicates(A);
        for(int i=0;i<lst;i++){
            System.out.print(A.get(i)+",");
        }
    }
}
