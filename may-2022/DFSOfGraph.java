import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use recursive approach to find the DFS traversal of the graph starting from
 the 0th vertex from left to right according to the graph..
Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V, E ≤ 104

 */
public class DFSOfGraph {
    static void dfs(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> res,
    boolean[] visitedNodes,Integer node){
        res.add(node);
        visitedNodes[node]=true;
        
        for(Integer adjacent:adj.get(node)){
            if(!visitedNodes[adjacent]){
                dfs(adj,res,visitedNodes,adjacent);
            }
        }
        
    }
    // Function to return a list containing the DFS traversal of the graph.
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visitedNodes=new boolean[V];
        ArrayList<Integer> res=new ArrayList<Integer>();
        dfs(adj,res,visitedNodes,0);
        
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
            a.get(v).add(u);
        }
        
        ArrayList<Integer> res=dfsOfGraph(V,a);
        for(Integer num:res){
            System.out.print(num+",");
        }
        System.out.println();
    }
}
