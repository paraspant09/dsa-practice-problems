import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Problem Description

Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example:

Input:
    A: [1 2 3 3 4 5 6]
    B: [3 3 5]


Output: [3 3 5]



Input:
    A: [1 2 3 3 4 5 6]
    B: [3 5]



Output: [3 5]

NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays should be included multiple times in the final output. 
 */
public class IntersectionOfSortedArrays {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> res=new ArrayList<Integer>();

        int i=0,j=0;
        while(i<A.size() && j<B.size()){
            if(A.get(i)<B.get(j)){
                i++;
            }
            else if(A.get(i)>B.get(j)){
                j++;
            }
            else{
                res.add(A.get(i));
                i++;
                j++;
            }
        }
        return res;
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

        System.out.println(intersect(A,B).toString());
    }
}
