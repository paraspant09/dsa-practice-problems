import java.util.Arrays;
import java.util.Scanner;

/**
 * You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.

Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.
 */
public class MaxContinuousSeriesOf1s {

    public static int[] maxone(int[] A, int B) {
        int i=0,j=0,max=0,t=0,s=0,e=0,nexti=0;
        //shift the  start pointer whenever we find numOfZeroes>B
        //and store the current range
        while(i<A.length){
            t=B+1;
            while(j<A.length){
                if(A[j]==0){
                    if(t==B+1)  nexti=j+1;
                    t--;
                }
                if(t==0)    break;
                j++;
            }
            if(j-i > max){
                max=j-i;
                s=i;
                e=j;
            }
            if(j>=A.length) break;
            i=nexti;
            j=i;
        }
        
        int[] res=new int[max];
        int ind=0;
        for(int k=s;k<e;k++){
            res[ind++]=k;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int N=ob.nextInt();
        int[] A=new int[N];

        for(int i=0;i<N;i++){
            A[i]=ob.nextInt();
        }

        int B=ob.nextInt();
        int[] res=maxone(A,B);
        System.out.println(Arrays.toString(res));
    }
}