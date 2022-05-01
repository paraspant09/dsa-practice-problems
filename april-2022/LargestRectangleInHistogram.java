import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Problem Description
Given an array of integers A .

A represents a histogram i.e A[i] denotes height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000000



Input Format
The only argument given is the integer array A.



Output Format
Return the area of largest rectangle in the histogram.



Example Input
Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2.
 */
public class LargestRectangleInHistogram {
    public static int largestRectangleArea(ArrayList<Integer> A) {
        int N=A.size();
        Stack<Integer> stck=new Stack<Integer>();
        int max=Integer.MIN_VALUE;
        int right=0;
        int height=0,left=0;
        //Storing in increasing order and popping whenever a lower is coming 
        //width of popped element is left value of that value in stack 
        for(;right<N;right++){
            while(!stck.isEmpty() && A.get(right)<=A.get(stck.peek())){
                height=A.get(stck.pop());
                left= (stck.size()==0)?0:stck.peek()+1;
                max=Math.max(max,height*(right-left));
            }
            stck.push(right);
        }
        while(!stck.isEmpty()){
            height=A.get(stck.pop());
            left= (stck.size()==0)?0:stck.peek()+1;
            max=Math.max(max,height*(right-left));
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<Integer> A=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            A.add(ob.nextInt());
        }

        System.out.println(largestRectangleArea(A));
    }
}
