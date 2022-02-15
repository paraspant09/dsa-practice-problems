import java.util.Scanner;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **

ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.
 */
public class ZigzagString {
    public static String convert(String A, int B) {
        int len=A.length();
        if(len<=B)  return A;
        if(B==1)    return A;
        char[][] tb=new char[B][len];
        for(int i=0;i<B;i++){
            for(int j=0;j<len;j++){
                tb[i][j]='\0';
            }
        }

        int k=0,l=0;
        for(int i=0;i<len;i++){
            tb[l][i]=A.charAt(i);
            k=(k+1)%(2*B-2);
            if(k>=B) l=(2*B-2)-k;
            else l=k;
        }
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<B;i++){
            for(int j=0;j<len;j++){
                if(tb[i][j]!='\0')
                    sb.append(tb[i][j]);
            }
        }

        return sb.toString();

    }
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        String A=ob.next();
        int B=ob.nextInt();
        
        System.out.println(convert(A,B));
    }
}
