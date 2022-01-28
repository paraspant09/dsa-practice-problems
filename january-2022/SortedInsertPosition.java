import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem Description

Given a sorted array A and a target value B, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= 109



Input Format
First argument is array A.

Second argument is integer B.



Output Format
Return an integer, the answer to the problem.



Example Input
Input 1:

 A = [1, 3, 5, 6]
B = 5
Input 2:

 A = [1, 3, 5, 6]
B = 2


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 5 is found at index 2.
Explanation 2:

 2 will be inserted ar index 1.
 */
public class SortedInsertPosition {
	public static int searchInsert(ArrayList<Integer> a, int b) {
        int f=0,l=a.size()-1,m=0;
        while(f<=l){
            m=(f+l)/2;
            if(a.get(m)==b){
                return m;
            }
            else if(a.get(m)<b){
                if(f==l)    return m+1;
                f=m+1;
            }
            else{
                if(f==l)    return m;
                l=m-1;
            }
        }
        return m;
	}
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	ArrayList<Integer> Array=new ArrayList<Integer>(lengthOfArray);
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array.add(ob.nextInt());
    	}

        int B=ob.nextInt();

        System.out.println(searchInsert(Array,B));
    }
}
