import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Description

Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.



Input Format
First and only argument is an integer array A.



Output Format
Return 1 if any such integer p is found else return -1.



Example Input
Input 1:

 A = [3, 2, 1, 3]
Input 2:

 A = [1, 1, 3, 3]


Example Output
Output 1:

 1
Output 2:

 -1


Example Explanation
Explanation 1:

 For integer 2, there are 2 greater elements in the array. So, return 1.
Explanation 2:

 There is no such integer exists.
 */
public class NobleInteger {
    public static int solve(int[] A) {
        int len=A.length;
        Arrays.sort(A);
        
        for(int i=0;i<len;i++){
            if(A[i]==(len-1-i)){
                if((i+1)!= len && A[i+1]==A[i])
                    continue;
                return 1;
            }
        }
        return -1;
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
