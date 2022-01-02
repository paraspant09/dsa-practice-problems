import java.util.Scanner;

/**
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]
 */
public class RotateMatrix {
    public static void recurse(int[][] a,int sr,int r,int sc,int c){
        //base
        if(sr>=r && sc>=c)  return;
        //mid 
        for(int i=0;i<c-sc;i++){
            int tmp=a[sr+i][c];
            a[sr+i][c]=a[sr][sc+i]; 

            int tmp2=a[r][c-i];
            a[r][c-i]=tmp;

            tmp=a[r-i][sc];
            a[r-i][sc]=tmp2;
            
            a[sr][sc+i]=tmp;
        }
        //recurse
        recurse(a,sr+1,r-1,sc+1,c-1);
    }

	public static void rotate(int[][] a) {
        int r=a.length;
        int c=a[0].length;
        if(r==c)
            recurse(a,0,r-1,0,c-1);
        else if(r>c)
            recurse(a,0,c-1,0,c-1);
        else
            recurse(a,0,r-1,0,r-1);

	}

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int r=ob.nextInt();
        int c=ob.nextInt();
    		    
    	int[][] Array=new int[r][c];
    		    
    	for (int i=0; i<r ;i++ ){
            for (int j=0; j<c ;j++ ){
                Array[i][j]=ob.nextInt();
            }
    	}

        rotate(Array);

        for (int i=0; i<r ;i++ ){
            for (int j=0; j<c ;j++ ){
                System.out.print(Array[i][j]+" ");;
            }
            System.out.println();
    	}
    }
}
