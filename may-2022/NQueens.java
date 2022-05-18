import java.util.ArrayList;
import java.util.Scanner;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 
 N Queens: Example 1

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,

There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
  ]
  */
class Position extends Object{
    int x,y;
    public Position(int _x,int _y){
        this.x=_x;
        this.y=_y;
    }
}

public class NQueens {
    static boolean compatible(ArrayList<Position> curSet,int n,int curX,int curY){
		for(Position node:curSet){
			if(curX==node.x || ( Math.abs(curY-node.y) == Math.abs(curX-node.x) ) )
				return false;
		}
		return true;
	}
	static void NQueensRecurser(int n,int curX,int curY,ArrayList<Position> curSet,ArrayList<ArrayList<String>> res){
		if(curY==n){
			ArrayList<String> temp=new ArrayList<String>();
			for(int i=0;i<n;i++){
				StringBuilder sb=new StringBuilder();
				Position pos=curSet.get(i);
				for(int j=0;j<n;j++){
					if(pos.x==j && pos.y==i)
						sb.append("Q");
					else	sb.append(".");
				}
				temp.add(sb.toString());
			}
			res.add(temp);
			return;
		}

		for(int i=0;i<n;i++){
			if(compatible(curSet,n,i,curY)){
				curSet.add(new Position(i,curY));
				NQueensRecurser(n,i,curY+1,curSet,res);
				curSet.remove(curSet.size()-1);
			}
		}
	}
	public static ArrayList<ArrayList<String>> solveNQueens(int a) {
		ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
		
		NQueensRecurser(a,0,0,new ArrayList<Position>(),res);
		
		return res;
	}
    
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        int A=ob.nextInt();

        for(ArrayList<String> list:solveNQueens(A))
            System.out.println(list.toString());
    }
}
