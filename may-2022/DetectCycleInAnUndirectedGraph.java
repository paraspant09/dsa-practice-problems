import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Given an undirected graph with V vertices and E edges,
 *  check whether it contains any cycle or not. 
 * NOTE: The adjacency list denotes the edges of the graph where edges[i][0] and
 *  edges[i][1] represent an edge.
 * Expected Time Complexity: O(V + E)
 * Expected Space Complexity: O(V)
 * Constraints:
 * 1 ≤ V, E ≤ 105
 */
class NodeData {
    public int node, parent;
    public NodeData(int _node,int _parent) {
      this.node = _node;
      this.parent= _parent;
   }
}
public class DetectCycleInAnUndirectedGraph {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visitedNodes=new boolean[V];
        
        Queue<NodeData> q=new LinkedList<NodeData>();
        
        for(int i=0;i<V;i++){
            if(!visitedNodes[i]){
                q.add(new NodeData(i,-1));
                visitedNodes[i]=true;
                while(!q.isEmpty()){
                    NodeData node=q.poll();
                    
                    for(Integer adjacent:adj.get(node.node)){
                        if(!visitedNodes[adjacent]){
                            q.add(new NodeData(adjacent,node.node));
                            visitedNodes[adjacent]=true;
                        }
                        else if(!adjacent.equals(node.parent))
                            return true;
                    }
                }
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
            a.get(v).add(u);
        }
        
        boolean res=isCycle(V,a);
        if(res) System.out.println("There is a cycle.");
        else    System.out.println("There is no cycle.");
    }
}
