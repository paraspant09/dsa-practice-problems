import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: 
for this problem, following are some good questions to ask :

Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Input Format
First argument is an array of digits.



Output Format
Return the array of digits after adding one.



Example Input
Input 1:

[1, 2, 3]


Example Output
Output 1:

[1, 2, 4]


Example Explanation
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
public class AddOneToNumber {
    public static int[] plusOne(int[] A) {
        int num,i;
        
        for(i=A.length-1;i>=0;i--){
            num=(A[i]+1)%10;
            A[i]=num;
            if(num!=0)  break;
        }
        
        int j;

        for(j=0;j<A.length;j++){
            if(A[j]!=0){
                break;
            }
        }
        if(j==A.length) j=0;

        int[] b;
        int k=0;

        if(i<0 && A[0]==0){
            b = new int[A.length - j +1];
            b[k++]=1;
        }
        else
            b= new int[A.length - j];
        
        for(;k<b.length;k++){
            b[k]=A[j++];
        }
   
        return b;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        System.out.println(Arrays.toString(plusOne(Array)));
    }
}
