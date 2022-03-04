import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 

Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.

For example, given array S = {-1 0 1 2 -1 -4},

A solution set is:

  (-1, 0, 1)

  (-1, -1, 2)
 */
public class ThreeSumZero {
    public static int[][] threeSum(int[] A) {
        Arrays.sort(A);  

        int j=0,k=0;
        ArrayList<int[]> res=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<A.length-2;i++){
            j=i+1;
            k=A.length-1;
            while(j<k){
                long a=A[i],b=A[j],c=A[k];
                long diff=(a+b+c);
                if(diff==0){
                    String chk=a+","+b+","+c;
                    if(map.get(chk)==null){
                        res.add(new int[]{(int)a,(int)b,(int)c});
                    }
                    map.put(chk,1);
                }
                if(diff>0)  k--;
                else    j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int N=ob.nextInt();

        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=ob.nextInt();
        }

        int[][] res=threeSum(A);

        for(int[] a:res){
            System.out.println(Arrays.toString(a));
        }
    }
}
