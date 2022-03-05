import java.util.ArrayList;
import java.util.Scanner;
/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.

TIP: C users, please malloc the result into a new array and return the result.

If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

Example :

Input : 
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]
 */
public class MergeTwoSortedListsII {
    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i=0,j=0;
        while(i<a.size() && j<b.size()){
            if(a.get(i)>b.get(j)){
                a.add(i,b.get(j));
                j++;
            }
            i++;
        }
        while(j<b.size()){
            a.add(b.get(j));
            j++;
        }
	}
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<Integer> A=new ArrayList<Integer>();
        ArrayList<Integer> B=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            A.add(ob.nextInt());
        }
        int M=ob.nextInt();

        for(int i=0;i<M;i++){
            B.add(ob.nextInt());
        }
        merge(A,B);

        System.out.println(A.toString());
    }
}
