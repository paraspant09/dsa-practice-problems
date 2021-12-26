import java.util.Scanner;

/*
Problem Description

Given an integer array A of size N.

You can pick B elements from either left or right end of the array A to get maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then

You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you picked.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [1, 2]
 B = 1


Example Output
Output 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Pick element 2 from end as this is the maximum we can get
*/
public class PickFromBothSides {
    public static int solve(int[] A, int B) {
        
        int curIndex=B-1;
        int sum=0;
        
        for(int i=0;i<B;i++){
            sum+=A[i];
        }
        
        int max=sum;
        while(curIndex>=0){
            
            sum-=A[curIndex];
            sum+=A[A.length - (B - curIndex)];
            
            max=Math.max(max,sum);

            curIndex--;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        int val=ob.nextInt();

        System.out.println(solve(Array,val));
    }
}
