import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s  conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d.
 */
public class PrimeSum {

    public static int[] primesum(int A) {
        boolean[] tble=new boolean[A+1];
        for(int i=2;i<=A;i++){
            tble[i]=true;
        }
        
        for(int i=2;i*i<=A;i++){
            if(tble[i]){
                for(int j=i*i;j<=A;j+=i){
                    tble[j]=false;
                }
            }
        }
        int[] res=new int[2];

        for(int i=2;i<=A;i++){
            if(tble[i] && tble[A-i]){
                res[0]=A-i;
                res[1]=i;

                // return res;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int A=ob.nextInt();
    		    
    	System.out.println(Arrays.toString(primesum(A)));
    }
}
