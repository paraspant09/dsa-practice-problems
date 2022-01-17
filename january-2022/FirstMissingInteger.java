import java.util.Scanner;

/**
 * Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingInteger {
    public static int firstMissingPositive(int[] A) {
        int N=A.length;
        //find 1
        boolean chk=false;
        for(int i=0;i<N;i++){
            if(A[i]==1){
                chk=true;
            }
        }

        if(!chk)    return 1;
        int sum=0;

        for(int i=0;i<N;i++){
            sum+=A[i];
            if(A[i]<1 || A[i]>N){
                A[i]=0;
            }
        }

        if(sum==(N*(N+1)/2))    return N+1;

        // System.out.println(Arrays.toString(A));
        
        for(int i=0;i<N;i++){
            int val=A[i];
            if(val==0 || val==(i+1))  continue;
            A[i]=0;
            if(A[val-1]==0 || A[val-1]==val){
                A[val-1]=val;
            }
            else{
                int j=val-1;
                while((A[j]!=val) && (A[j]!=0)){
                    int tmp=A[j];
                    A[j]=val;
                    val=tmp;
                    j=val-1;
                }
                A[j]=val;
            }
        }
        // System.out.println(Arrays.toString(A));

        for(int i=0;i<N;i++){
            if(A[i]==0) return i+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        System.out.println(firstMissingPositive(Array));
    }
}
