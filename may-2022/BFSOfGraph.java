import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Given a directed graph. The task is to do Breadth First Traversal of this graph
 *  starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v and 
find the BFS traversal of the graph starting from the 0th vertex, 
from left to right according to the graph. Also, you should only take nodes
 directly or indirectly connected from Node 0 in consideration.
 
Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V, E ≤ 104
 */
public class BFSOfGraph {
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visitedNodes=new boolean[V];
        Queue<Integer> q=new LinkedList<Integer>();
 
        ArrayList<Integer> res=new ArrayList<Integer>();
        q.add(0);
        visitedNodes[0]=true;
        int node=0;
        while(!q.isEmpty()){
            node=q.poll();
            res.add(node);
            
            for(Integer adjacent:adj.get(node)){
                if(!visitedNodes[adjacent]){
                    visitedNodes[adjacent]=true;
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
        
        ArrayList<Integer> res=bfsOfGraph(V,a);
        for(Integer num:res){
            System.out.print(num+",");
        }
        System.out.println();
    }
}