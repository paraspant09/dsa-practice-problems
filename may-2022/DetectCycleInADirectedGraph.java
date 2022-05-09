import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, 
 * check whether it contains any cycle or not.
 * Expected Time Complexity: O(V + E)
 * Expected Auxiliary Space: O(V)
 * Constraints:
 * 1 ≤ V, E ≤ 105
 */
public class DetectCycleInADirectedGraph {
    static boolean Dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visitedNodes,
    boolean[] pathNodes,int node){
        visitedNodes[node]=true;
        pathNodes[node]=true;
        
        boolean isCycle=false;
        for(Integer adjacent:adj.get(node)){
            //if adjacent node(& after all this) is already checked for a cycle 
            if(!visitedNodes[adjacent]){
                isCycle |=Dfs(adj,visitedNodes,pathNodes,adjacent);
            }
            //if adjacent node is already in current path then it is cycle
            else if(pathNodes[adjacent])
                isCycle |=true;
        }
        
        pathNodes[node]=false;
        
        return isCycle;
    }
    // Function to detect cycle in a directed graph.
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visitedNodes=new boolean[V];
        boolean[] pathNodes=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visitedNodes[i]){
                if(Dfs(adj,visitedNodes,pathNodes,i))
                    return true;
            }
        }
        return false;
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
        
        boolean res=isCyclic(V,a);
        if(res) System.out.println("There is a cycle.");
        else    System.out.println("There is no cycle.");
    }
}
