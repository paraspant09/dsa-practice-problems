import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem Description

Given a binary array A and a number B, we need to find length of the longest subsegment of ‘1’s possible by changing at most B ‘0’s.



Problem Constraints
 1 <= N, B <= 105

 A[i]=0 or A[i]=1



Input Format
First argument is an binary array A.

Second argument is an integer B.



Output Format
Return a single integer denoting the length of the longest subsegment of ‘1’s possible by changing at most B ‘0’s.



Example Input
Input 1:

 A = [1, 0, 0, 1, 1, 0, 1]
 B = 1
Input 2:

 A = [1, 0, 0, 1, 0, 1, 0, 1, 0, 1]
 B = 2


Example Output
Output 1:

 4
Output 2:

 5


Example Explanation
Explanation 1:

 Here, we should only change 1 zero(0). Maximum possible length we can get is by changing the 3rd zero in the array,
 we get a[] = {1, 0, 0, 1, 1, 1, 1}
Explanation 2:

 Here, we can change only 2 zeros. Maximum possible length we can get is by changing the 3rd and 4th (or) 4th and 5th zeros.
 */
public class MaximumOnesAfterModification {
    public static int solve(ArrayList<Integer> A, int B) {
        int i=0,j=0;
        int leftZeroes=B+1;
        int firstZero=0;
        int max=Integer.MIN_VALUE;
        while(j<A.size()){
            leftZeroes=B+1;
            j=firstZero;
            i=j;
            while(j<A.size()){
                if(A.get(j)==0){
                    if(leftZeroes==B+1) firstZero=j+1;
                    leftZeroes--;
                } 
                if(leftZeroes==0){
                    break;
                }  
                j++;
            }
            max=Math.max(max,j-i);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<Integer> a=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            a.add(ob.nextInt());
        }
        int B=ob.nextInt();
        
        System.out.println(solve(a,B));
    }
}
