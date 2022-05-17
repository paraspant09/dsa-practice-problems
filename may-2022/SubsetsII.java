import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :

If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]
 */
public class SubsetsII {
    static void subsets(ArrayList<Integer> A,ArrayList<Integer> curSet,ArrayList<ArrayList<Integer>> res,int i){
        if(i==A.size()){
            ArrayList<Integer> arr=new ArrayList<>(curSet);
            if(!res.contains(arr)){
                res.add(arr);
            }
            return;
        }

        subsets(A,curSet,res,i+1);

        curSet.add(A.get(i));
        subsets(A,curSet,res,i+1);
        curSet.remove(curSet.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        subsets(A,new ArrayList<Integer>(),res,0);
        Collections.sort(res,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> one,ArrayList<Integer> two){
                int i=0;
                while(i<one.size() && i<two.size() && one.get(i).equals(two.get(i)) ){
                    i++;
                }
                if(i==one.size() && i<two.size())    return -1;
                else if(i==two.size() && i<one.size())    return 1;
                else if(i==one.size() && i==two.size())    return 0;
                return one.get(i)>two.get(i)?1:-1;
            }
        });
        return res;
    }
    
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<Integer> A=new ArrayList<Integer>();
        int N=ob.nextInt();

        for(int i=0;i<N;i++){
            A.add(ob.nextInt());
        }
        for(ArrayList<Integer> list:subsetsWithDup(A))
            System.out.println(list.toString());
    }
}