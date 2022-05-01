import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *Problem Description

Given an integer array A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Problem Constraints
1 <= |A| <= 100000

Input Format
The only argument given is integer array A.

Output Format
Return the total water it is able to trap after raining.

Example Input
Input 1:

 A = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Input 2:

 A = [1, 2]

Example Output
Output 1:

 6
Output 2:

 0

Example Explanation
Explanation 1:

 In this case, 6 units of rain water (blue section) are being trapped.
Explanation 2:

 No water is trapped.
 */
public class RainWaterTrapped {
    public static int trap(final List<Integer> A) {
        int totalWaterCanBeStored=0;
        int[] suffixHighest=new int[A.size()];
        suffixHighest[A.size()-1]=A.get(A.size()-1);
        for(int i=A.size()-2;i>=0;i--){
            suffixHighest[i]=Math.max(suffixHighest[i+1],A.get(i));
        }
        int curMax=A.get(0);
        for(int i=1;i<A.size();i++){
            curMax=Math.max(curMax,A.get(i));
            totalWaterCanBeStored+=(Math.min(curMax,suffixHighest[i])-A.get(i));
        }
        return totalWaterCanBeStored;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        List<Integer> A=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            A.add(ob.nextInt());
        }

        System.out.println(trap(A));
    }
}