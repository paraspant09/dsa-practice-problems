import java.util.Arrays;
import java.util.Scanner;

/**
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.

Note:

1. The replacement must be in-place, do **not** allocate extra memory.
2. DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
Input Format:

The first and the only argument of input has an array of integers, A.
Output Format:

Return an array of integers, representing the next permutation of the given array.
Constraints:

1 <= N <= 5e5
1 <= A[i] <= 1e9
Examples:

Input 1:
    A = [1, 2, 3]

Output 1:
    [1, 3, 2]

Input 2:
    A = [3, 2, 1]

Output 2:
    [1, 2, 3]

Input 3:
    A = [1, 1, 5]

Output 3:
    [1, 5, 1]

Input 4:
    A = [20, 50, 113]

Output 4:
    [20, 113, 50]
 */
public class NextPermutation {
    public static int[] nextPermutation(int[] A) {
        int len=A.length;
        if(len<=1)  return A;

        if(A[len-1]>A[len-2]){
            int tmp=A[len-1];
            A[len-1]=A[len-2];
            A[len-2]=tmp;
        }
        else{
            //next big(of A[len-3]) from right of it
            //if found replace current with it and arrange current and all in right except one choosen 
            //in ascending order in right of choosen
            // if not found repeat this for A[len-4] and so on 
            // if we are in the <0 position then reverse the array
            int pos=len-3;
            while(pos>=0){
                int cur =A[pos];
                int nxt=pos+1;
                int nextBig=A[nxt];
                while(++nxt<len){
                    if(A[nxt]<nextBig && cur<A[nxt])
                        nextBig=A[nxt];
                }
                //not found
                if(nextBig<=cur){
                    pos-=1;
                    continue;
                }
                //found
                int j=pos+1;
                while(j<len){
                    if(A[j]==nextBig){
                        if(j+1<len && A[j+1]==nextBig){
                            j++;
                            continue;   
                        }
                        
                        int tmp=A[j];
                        A[j]=A[pos];
                        A[pos]=tmp;
                        break;
                    }
                    j++;
                }
                //reverse from pos+1 to len-1
                int start=pos+1;
                int mid=((len-1-start)-(pos+1-start))/2;
                for(int i=0;i<=mid;i++){
                    int tmp=A[pos+1+i];
                    A[pos+1+i]=A[len-1-i];
                    A[len-1-i]=tmp;
                }
                A[pos]=nextBig;
                break;
            }
            if(pos<0){
                for(int i=0;i<=(len/2)-1;i++){
                    int tmp=A[i];
                    A[i]=A[len-1-i];
                    A[len-1-i]=tmp;
                }
            }

        }
        return A;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        System.out.println(Arrays.toString(nextPermutation(Array)));
    }
    
}
