import java.util.ArrayList;
import java.util.Scanner;
/**
 * Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example:

Input :

    A : [1 3 5] 
    k : 4
Output : YES

as 5 - 1 = 4

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.
 */
public class Diffk {
    public static int diffPossible(ArrayList<Integer> A, int B) {
        int i=0,j=1;
        while(j<A.size()){
            int diff=Math.abs(A.get(j)-A.get(i));
            if(diff==B)  return 1;
            if((diff-B)>0){
                i++;
            } 
            else{
                j++;
            }   
            if(i==j)    j++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<Integer> a=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            a.add(ob.nextInt());
        }
        int B=ob.nextInt();
        
        System.out.println(diffPossible(a,B));
    }
}
