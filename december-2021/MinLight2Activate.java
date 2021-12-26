import java.util.Scanner;

/*
There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.

All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].

Initially all lights are off.

Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.



Problem Constraints
1 <= N <= 1000

1 <= B <= 1000



Input Format
First argument is an integer array A where A[i] is either 0 or 1.

Second argument is an integer B.



Output Format
Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.


Example Input
Input 1:

A = [ 0, 0, 1, 1, 1, 0, 0, 1].
B = 3
Input 2:

A = [ 0, 0, 0, 1, 0].
B = 3


Example Output
Output 1:

2
Output 2:

-1


Example Explanation
Explanation 1:

In the first configuration, Turn on the lights at 3rd and 8th index.
Light at 3rd index covers from [ 1, 5] and light at 8th index covers [ 6, 8].
Explanation 2:

In the second configuration, there is no light which can light the first corridor.
*/
public class MinLight2Activate {
    public static int solve(int[] A, int B) {
        int num=0;
        int prev=0;
        int i;

        if( A.length < B){
            for(int k=0;k<A.length;k++){
                if(A[k]==1)
                    return 1;
            }
            return -1;
        }

        for(i=B-1;i<A.length;i+=( 2*(B-1) + 1 )){
            if(A[i] != 1){
                int j=i-1;
                while(j>prev){
                    if(A[j]==1){
                        i=j;
                        break;
                    }
                    j--;
                }
                if(j<=prev)  return -1;
            }
            num++;
            prev=i;
        }
        
        if(prev+B-1 >= A.length-1)   return num;

        if( prev+B-1 < A.length-1 ){
            i=A.length-1;
            while(i>prev){
                if(A[i]==1)
                    return num+1;
                i--;
            }
            return -1;
        }

        return num;
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
