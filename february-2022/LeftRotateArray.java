import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LeftRotateArray {
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        List<Integer> res=new ArrayList<Integer>(Collections.nCopies(a.size(), 0));
        int inPos=0;
        for(int i=0;i<a.size();i++){
            inPos=((i-d)>=0)? (i-d)%a.size() : a.size()-((-(i-d))%a.size());
            res.set(inPos, a.get(i));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        int N=ob.nextInt();
        int k=ob.nextInt();

        List<Integer> A=new ArrayList<Integer>();
        for(int i=0;i<N;i++){
            A.add(ob.nextInt());
        }
        for (Integer a : rotLeft(A,k)) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
