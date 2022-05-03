import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Nth Row Of Pascal Triangle 2nd Method in O(N) time annd O(1) space:-
 * Using Formula :- nCr = nCr-1 * (N-r+1)/r and nC0 =1
 */
public class NthRowOfPascalTriangle2ndMethod {
    public static List<Integer> getRow(int k) {
        List<Integer> res=new ArrayList<Integer>();
        long prev=1;
        res.add((int)prev);

        for(int i=1;i<=k;i++){
            prev=prev*(k-i+1)/i;
            res.add((int)prev);
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        int N=ob.nextInt();

        System.out.println(getRow(N).toString());
    }
}
