import java.util.Scanner;

/**
 * Given n non-negative integers a1, a2, ..., an,

where each represents a point at coordinate (i, ai).

'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).

Note: You may not slant the container.

Example :

Input : [1, 5, 4, 3]
Output : 6

Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3. 
So total area = 3 * 2 = 6
 */
public class ContainerWithMostWater {
    static int findArea(int a,int b,int dist){
        return dist*Math.min(a,b);
    }
    public static int maxArea(int[] A) {
        int i=0,j=1,max=0,nexti=A.length;
        while(i<A.length && j<A.length){
            nexti=A.length;
            while(j<A.length){
                if(nexti==A.length && A[j]>A[i])   nexti=j;
                max=Math.max(max,findArea(A[i],A[j],j-i));
                j++;
            }
            i=nexti;
            j=i+1;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int N=ob.nextInt();
        int[] A=new int[N];

        for(int i=0;i<N;i++){
            A[i]=ob.nextInt();
        }

        System.out.println("Max area: "+maxArea(A));
    }
}
