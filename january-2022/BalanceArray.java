import java.util.Scanner;
/**
 * Problem Description

Given an integer array A of size N. You need to count the number of special elements in the given array.

A element is special if removal of that element make the array balanced.

Array will be balanced if sum of even index element equal to sum of odd index element.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A of size N.



Output Format
Return an integer denoting the count of special elements.



Example Input
Input 1:

 A = [2, 1, 6, 4]
Input 2:

 A = [5, 5, 2, 5, 8]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 After deleting 1 from array : {2,6,4}
    (2+4) = (6)
 Hence 1 is the only special element, so count is 1
Explanation 2:

 If we delete A[0] or A[1] , array will be balanced
    (5+5) = (2+8)
 So A[0] and A[1] are special elements, so count is 2.
 */
public class BalanceArray {
    public static int solve(int[] A) {
        int len=A.length;
        int reSum=0,roSum=0;
        for(int i=1;i<len;i++){
            if((i&1)==0)    roSum+=A[i];
            else    reSum+=A[i];
        }

        int count=0;
        int leSum=0,loSum=0;
        int right,left;
        for(int i=0;i<len-1;i++){

            right=(reSum+leSum);
            left=(roSum+loSum);

            if(right==left)
                count++;
            
            if(((i+1)&1)==0){
                roSum-=A[i+1];
                loSum+=A[i];
            }
            else{
                reSum-=A[i+1];
                leSum+=A[i];
            }
        }

        if((reSum+leSum)==(roSum+loSum))
            count++;

        return count;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        System.out.println(solve(Array));
    }
}
