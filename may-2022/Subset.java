import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Given a set of distinct integers, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
 */
public class Subset {
    static void findSubsets(ArrayList<Integer> A,int i,LinkedList<Integer> curSet,ArrayList<ArrayList<Integer>> res){
        if(i==A.size()){
            res.add(new ArrayList<Integer>(curSet));
            return;
        }
        findSubsets(A,i+1,curSet,res);
        curSet.add(A.get(i));
        findSubsets(A,i+1,curSet,res);
        curSet.remove(curSet.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        findSubsets(A,0,new LinkedList<Integer>(),res);
        for(ArrayList<Integer> resEl:res){
            Collections.sort(resEl);
        }
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> one, ArrayList<Integer> two) {
                int i=0;
                while(i<one.size() && i<two.size()){
                    if(one.get(i).equals(two.get(i)))
                        i++;
                    else 
                        return one.get(i).compareTo(two.get(i));
                }
                if(i>=one.size() && i>=two.size())  return 0;
                if(i>=one.size())    return -1;
                return 1;
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
        for(ArrayList<Integer> list:subsets(A))
            System.out.println(list.toString());
    }
}
