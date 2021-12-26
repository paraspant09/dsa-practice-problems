import java.util.Scanner;
/*
You are in an infinite 2D grid where you can move in any of the 8 directions

 (x,y) to 
    (x-1, y-1), 
    (x-1, y)  , 
    (x-1, y+1), 
    (x  , y-1),
    (x  , y+1), 
    (x+1, y-1), 
    (x+1, y)  , 
    (x+1, y+1) 
You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in which you can achieve it. You start from the first point.

NOTE: This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.



Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.



Output Format
Return an Integer, i.e minimum number of steps.



Example Input
Input 1:

 A = [0, 1, 1]
 B = [0, 1, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Given three points are: (0, 0), (1, 1) and (1, 2).
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
*/
public class MinStepsInfiniteGrid {
    public static int findMinNumOfSteps(int x1,int y1,int x2,int y2){
        int diff=Math.abs(x2 - x1) - Math.abs(y2 - y1);
        int rem= diff>0? Math.abs(x2 - x1) : Math.abs(y2 - y1);
        return Math.abs(rem);
    }

    public static int coverPoints(int[] A, int[] B) {
        int steps=0;
        for(int i=0;i<A.length-1;i++){
            int x1=A[i];
            int y1=B[i];
            int x2=A[i+1];
            int y2=B[i+1];

            steps+=findMinNumOfSteps(x1,y1,x2,y2);
        }
        return steps;
    }
    
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        int lengthOfArray2=ob.nextInt();
    		    
    	int[] Array2=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray2 ;i++ ){
    	    Array2[i]=ob.nextInt();
    	}

        System.out.println(coverPoints(Array,Array2));
    }
}
