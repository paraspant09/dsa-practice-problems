import java.util.ArrayList;
import java.util.Scanner;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,

We get the following sequence (ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"

Good questions to ask the interviewer :

What if n is greater than 10. How should multiple digit numbers be represented in string?
In this case, just concatenate the number to the answer.

 so if n = 11, k = 1, ans = "1234567891011"

Whats the maximum value of n and k?
In this case, k will be a positive integer thats less than INT_MAX.

n is reasonable enough to make sure the answer does not bloat up a lot.
 */
public class KthPermutationSequence {
    static int factorial(int n){
        if(n>12)    return Integer.MAX_VALUE;
        int fact=1;
        for(int i=2;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
    static void permutations(ArrayList<Integer> A,int j,int n,int B,StringBuilder res){
        if(A.size()==0){
            return;
        }
        
        for(int i=0;i<A.size();i++){
            if( i==A.size()-1 || factorial(n-1)==Integer.MAX_VALUE ||(j+(i+1)*factorial(n-1)) >=B ){
                res.append(A.get(i).toString());

                A.remove(i);

                j+=i*factorial(n-1);
                permutations(A,j,n-1,B,res);

                break;
            }
        }
    }
    public static String getPermutation(int A, int B) {
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=1;i<=A;i++)    a.add(i);
        
        StringBuilder res=new StringBuilder();

        permutations(a,0,A,B,res);

        return res.toString();
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int A=ob.nextInt();
        int B=ob.nextInt();

        System.out.println(getPermutation(A,B));
    }
}