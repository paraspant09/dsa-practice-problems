import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
nums[i] - nums[j] == k
Notice that |val| denotes the absolute value of val.

 

Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:

Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:

Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
 

Constraints:

1 <= nums.length <= 104
-107 <= nums[i] <= 107
0 <= k <= 107
 */
class KDifferentPairs {
    public static int findPairs(int[] A, int B) {
        Map<Integer,Integer> tble=new HashMap<Integer,Integer>();
        int cnt=0;
        //we want to find A[j]-A[i]=B , we store A[i]+B in HashMap and finding A[j] in map
        for(int i=0;i<A.length;i++){
            int a=(int)tble.getOrDefault(A[i]+B, 0);
            tble.put(A[i]+B,a+1);
        }
        if(B==0){
             for (Map.Entry<Integer,Integer> set : tble.entrySet()) {
                 if(set.getValue()>1)
                     cnt++;
            }
        }
        else{
            for(int i=0;i<A.length;i++){
                if(tble.get(A[i])!=null){
                    cnt++;
                    tble.remove(A[i]);
                }
            }
        }
        
        return cnt;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int N=ob.nextInt();

        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=ob.nextInt();
        }
        int B=ob.nextInt();

        System.out.println(findPairs(A,B));
    }
}