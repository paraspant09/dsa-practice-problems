import java.util.ArrayList;
import java.util.Scanner;
/**
 * Problem Description

Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.

Input Format:

The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
Output Format:

Return a 2-d matrix that satisfies the given conditions.
Constraints:

1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1], 
        [1, 1, 1]   ]


Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]



Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]



Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
 */
public class SetMatrixZeroes {
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        ArrayList<Integer> row=new ArrayList<>();
        ArrayList<Integer> col=new ArrayList<>();
        for(int i=0;i<a.size();i++){
            int rowsum=1;
            for(int j=0;j<a.get(0).size();j++){
                if(a.get(i).get(j)==0){
                    rowsum=0;
                    break;
                }
            }
            row.add(rowsum);
        }
        for(int i=0;i<a.get(0).size();i++){
            int colsum=1;
            for(int j=0;j<a.size();j++){
                if(a.get(j).get(i)==0){
                    colsum=0;
                    break;
                }
            }
            col.add(colsum);
        }
        for(int i=0;i<a.size();i++){
            for(int j=0;j<a.get(0).size();j++){
                if(row.get(i)==0 ||col.get(j)==0)
                    a.get(i).set(j,0);
            }
        }
	}
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int m=ob.nextInt();
        int n=ob.nextInt();

        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<m ;i++ ){
            arr.add(new ArrayList<Integer>());
        }
    		    
    	for (int i=0; i<m ;i++ ){
            for (int j=0; j<n ;j++ ){
                arr.get(i).add(ob.nextInt());
            }
    	}
        setZeroes(arr);
        for(ArrayList<Integer> a:arr)
            System.out.println(a.toString());
    }
}
