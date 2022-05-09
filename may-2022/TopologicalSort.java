import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, 
 * Find any Topological Sorting of that Graph.
 * Expected Time Complexity: O(V + E).
 * Expected Auxiliary Space: O(V).
 * Constraints:
 * 2 ≤ V ≤ 104
 * 1 ≤ E ≤ (N*(N-1))/2
 */
public class TopologicalSort {
    static void findInDegree(int V, ArrayList<ArrayList<Integer>> adj,int[] inDeg){
        for(ArrayList<Integer> node:adj){
            for(Integer adjacent:node){
                inDeg[adjacent]+=1;
            }
        }
    }
    static ArrayList<Integer> findMinInDegreeNode(int V,int[] inDeg){
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<V;i++){
            if(inDeg[i]==0){
                res.add(i);
            }
        }
        return res;
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] res=new int[V];
        int[] inDeg=new int[V];
        Queue<Integer> q=new LinkedList<Integer>();
        findInDegree(V,adj,inDeg);
        for(Integer minInDegNodes:findMinInDegreeNode(V,inDeg)){
            q.add(minInDegNodes);
        }
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            res[i++]=node;
            
            for(Integer adjacent:adj.get(node)){
                inDeg[adjacent]-=1;
                if(inDeg[adjacent]==0){
                    q.add(adjacent);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        int V=ob.nextInt();
        int E=ob.nextInt();
        for(int i=0;i<V;i++){
            a.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            int u=ob.nextInt();
            int v=ob.nextInt();
            a.get(u).add(v);
        }
        
        int[] res=topoSort(V,a);
        System.out.println(Arrays.toString(res));
    }
}
