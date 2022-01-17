import java.util.Scanner;

/**
 * Problem Description

Given an integer A you need to find the Ath fibonacci number modulo 109 + 7.

The first fibonacci number F1 = 1

The first fibonacci number F2 = 1

The nth fibonacci number Fn = Fn-1 + Fn-2 (n > 2)



Problem Constraints
1 <= A <= 109.



Input Format
First argument is an integer A.



Output Format
Return a single integer denoting Ath fibonacci number modulo 109 + 7.



Example Input
Input 1:

 A = 4
Input 2:

 A = 3


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 F3 = F2 + F1 = 1 + 1 = 2
 F4 = F3 + F2 = 2 + 1 = 3
Explanation 2:

 F3 = F2 + F1 = 1 + 1 = 2
 */
public class FindNthFibonacci {
    public static long mod(long m){
        return m%1000000007;
    }
    public static int solve(int A) {
        int t=(int)(Math.log(A)/Math.log(2));
        int p=(int)Math.pow(2,t);
        int r=A-p;
        long a0=1,a1=1,b0=1,b1=0;
        long A0=1,A1=1,B0=1,B1=0;

        while(t-->0){
            A0=mod(mod(a0*a0)+mod(a1*b0));
            A1=mod(mod(a0*a1)+mod(a1*b1));
            B0=mod(mod(b0*a0)+mod(b1*b0));
            B1=mod(mod(b0*a1)+mod(b1*b1));

            a0=A0;
            a1=A1;
            b0=B0;
            b1=B1;
        }

        while(r-->0){
            A0=mod(a0+a1);
            A1=a0;
            B0=mod(b0+b1);
            B1=b0;

            a0=A0;
            a1=A1;
            b0=B0;
            b1=B1;
        }
        return (int)a1;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int k=ob.nextInt();

        System.out.println(solve(k));
    }
}

