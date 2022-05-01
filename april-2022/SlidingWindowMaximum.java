import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array of integers A.  There is a sliding window of size B which 

is moving from the very left of the array to the very right. 

You can only see the w numbers in the window. Each time the sliding window moves 

rightwards by one position. You have to find the maximum for each window. 

The following example will give you more clarity.

The array A is [1 3 -1 -3 5 3 6 7], and B is 3.

Window position	Max
———————————-	————————-
[1  3  -1] -3  5  3  6  7	3
1 [3  -1  -3] 5  3  6  7	3
1  3 [-1  -3  5] 3  6  7	5
1  3  -1 [-3  5  3] 6  7	5
1  3  -1  -3 [5  3  6] 7	6
1  3  -1  -3  5 [3  6  7]	7
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

Note: If B > length of the array, return 1 element with the max of the array.




Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1]
For Example

Input 1:
    A = [1, 3, -1, -3, 5, 3, 6, 7]
    B = 3
Output 1:
    C = [3, 3, 5, 5, 6, 7]
 */
public class SlidingWindowMaximum {
    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        Deque<Integer> q= new ArrayDeque<Integer>();
        for(int i=0;i<B;i++){
            while(!q.isEmpty() && A.get(q.peekLast())<A.get(i)){
                q.pollLast();
            }
            q.addLast(i);
        }
        for(int i=B;i<A.size();i++){
            
            res.add(A.get(q.peekFirst()));
            
            if((i-B)==q.peekFirst())  q.pollFirst();
            
            while(!q.isEmpty() && A.get(q.peekLast())<A.get(i)){
                q.pollLast();
            }
            q.addLast(i); 
        }
        res.add(A.get(q.peekFirst()));
        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        List<Integer> A=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            A.add(ob.nextInt());
        }
        int B=ob.nextInt();

        System.out.println(slidingMaximum(A,B).toString());
    }
}
