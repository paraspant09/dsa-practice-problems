import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem Description

Given a character matrix of size N x M in the form of a string array A of size N where A[i] denotes ith row.

Each character in the matrix consists any one of the following three characters {'r', 'g', 'b'} where 'r' denotes red color similarly 'g' denotes green color and 'b' denotes blue color.

You have to find the area of the largest triangle that has one side parallel to y-axis i.e vertical and the color of all three vertices are different.

NOTE:

If the area comes out to be a real number than return the ceil of that number.


Problem Constraints
2 <= N, M <= 103

A[i][j] = 'r' or A[i][j] = 'g' or A[i][j] = 'b'



Input Format
First and only argument is an string array A of size N denoting the 2D character matrix.



Output Format
Return a single integer denoting the area of the largest triangle that has one side parallel to y-axis i.e vertical and the color of all three vertices are different.

If the area comes out to be a real number than return the ceil of that number.



Example Input
Input 1:

 A = ["rrrrr", "rrrrg", "rrrrr", "bbbbb"]
Input 2:

 A = ["rrr", "rrr", "rrr", "rrr"]


Example Output
Output 1:

 10
Output 2:

 0


Example Explanation
Explanation 1:

 The maximum area of triangle is 10.
 Triangle coordinates are (0,0) containing r, (1,4) containing g, (3,0) containing b.
 
Explanation 2:

 All cells have same color so no triangle possible so we will return 0
 */
class ColorMatrix{
    int[][] matrix;
    ColorMatrix(){
        matrix=new int[3][2];
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                matrix[i][j]=-1;
            }
        }
    }
}
class Color{
    boolean[] matrix;
    Color(){
        matrix=new boolean[3];
    }
}
public class MaximumAreaOfTriangle {
    public static int solve(ArrayList<String> A) {
        ColorMatrix[] colorData=new ColorMatrix[A.get(0).length()];
        Color[] colorPresence=new Color[A.get(0).length()];
        for(int k=0;k<A.get(0).length();k++){
            colorData[k]=new ColorMatrix();
            colorPresence[k]=new Color();
        }
        int i=0,j=0;
        for(String s:A){
            j=0;
            for(char color:s.toCharArray()){
                if(color=='r')  colorPresence[j].matrix[0]=true;
                if(color=='g')  colorPresence[j].matrix[1]=true;
                if(color=='b')  colorPresence[j].matrix[2]=true;

                if(color=='r' && colorData[j].matrix[0][0]==-1)
                    colorData[j].matrix[0][0]=i;
                if(color=='g' && colorData[j].matrix[1][0]==-1)
                    colorData[j].matrix[1][0]=i;
                if(color=='b' && colorData[j].matrix[2][0]==-1)
                    colorData[j].matrix[2][0]=i;
                
                if(color=='r')
                    colorData[j].matrix[0][1]=i;
                if(color=='g')
                    colorData[j].matrix[1][1]=i;
                if(color=='b')
                    colorData[j].matrix[2][1]=i;
                j++;
            }
            i++;
        }
        int maxArea=0;
        
        for(i=0;i<A.get(0).length();i++){
            ColorMatrix data=colorData[i];
            for(j=0;j<A.get(0).length();j++){
                if(i==j)    continue;
                Color cP=colorPresence[j];
                int length=(j>i) ? (j-i+1) : (i-j+1);
                if(data.matrix[1][1]!=-1 && data.matrix[0][0]!=-1){
                    int rg=data.matrix[1][1]-data.matrix[0][0];
                    if(rg>0 && cP.matrix[2]==true){
                        maxArea=Math.max(maxArea,length*(rg+1));
                    }
                }    
                if(data.matrix[2][1]!=-1 && data.matrix[0][0]!=-1){
                    int rb=data.matrix[2][1]-data.matrix[0][0];
                    if(rb>0 && cP.matrix[1]==true){
                        maxArea=Math.max(maxArea,length*(rb+1));
                    }
                }
                if(data.matrix[0][1]!=-1 && data.matrix[1][0]!=-1){
                    int gr=data.matrix[0][1]-data.matrix[1][0];
                    if(gr>0 && cP.matrix[2]==true){
                        maxArea=Math.max(maxArea,length*(gr+1));
                    }
                }
                if(data.matrix[2][1]!=-1 && data.matrix[1][0]!=-1){
                    int gb=data.matrix[2][1]-data.matrix[1][0];
                    if(gb>0 && cP.matrix[0]==true){
                        maxArea=Math.max(maxArea,length*(gb+1));
                    }
                }
                if(data.matrix[0][1]!=-1 && data.matrix[2][0]!=-1){
                    int br=data.matrix[0][1]-data.matrix[2][0];
                    if(br>0 && cP.matrix[1]==true){
                        maxArea=Math.max(maxArea,length*(br+1));
                    }
                }
                if(data.matrix[1][1]!=-1 && data.matrix[2][0]!=-1){
                    int bg=data.matrix[1][1]-data.matrix[2][0];
                    if(bg>0 && cP.matrix[0]==true){
                        maxArea=Math.max(maxArea,length*(bg+1));
                    }
                } 

            }
        }
        return (int)Math.ceil((double)maxArea/2);
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<String> A=new ArrayList<String>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            A.add(ob.next());
        }

        System.out.println(solve(A));
    }
}
