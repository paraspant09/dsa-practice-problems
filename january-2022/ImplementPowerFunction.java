import java.util.Scanner;

/**
 *  
 

Implement pow(x, n) % d.
In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.



Problem Constraints
-109 <= x <= 109
0 <= n <= 109
1 <= d <= 109


Example Input
x = 2
n = 3
d = 3


Example Output
2


Example Explanation
23 % 3 = 8 % 3 = 2.


 */
public class ImplementPowerFunction {
	public static long mod(long x,int d){
		return x%d;
	}
	public static long power(int x,int n,int d){
		if(x==0)	return 0;
		if(n==0)	return 1;
		long half=mod(power(x,n/2,d),d);
		if((n&1)==0){
			return mod(half * half,d);
		}
		else{
			return mod(mod(x*half,d) * half,d);
		}
	}
	public static int pow(int x, int n, int d) {
		long res=power(x,n,d);
		if(res<0)	return d - (-x)%d;
		return (int)(res);
	}
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int x=ob.nextInt();
        int n=ob.nextInt();
        int d=ob.nextInt();
    		
        System.out.println(pow(x,n,d));
    }
}
