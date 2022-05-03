import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Problem Description

Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
Sample Input:

[3 4 1 4 1]

Sample Output:

1

If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
 */
public class FindDuplicateInArray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int repeatedNumber(final List<Integer> A) {
        HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
        for(Integer num:A){
            if(!map.containsKey(num))
                map.put(num,true);
            else    return num;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        List<Integer> A=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            A.add(ob.nextInt());
        }

        System.out.println(repeatedNumber(A));
    }
}
