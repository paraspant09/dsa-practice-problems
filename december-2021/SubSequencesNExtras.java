import java.util.*;

public class SubSequencesNExtras {	

    public static void recurse(String str,int i,String res){
        if(i==str.length()){
            System.out.println(res);
            return;
        }    

        recurse(str,i+1,res);
        recurse(str,i+1,res+str.charAt(i));
    }

    public static void recurseArray(int[] A,int N,int i,int[] res){
        if(i==N){
            for (int j=0; j<res.length ;j++ ){
                if(res[j]!=0)   System.out.print(res[j]+" ");
    		}
            System.out.println();
            return;
        }    
        recurseArray(A,N,i+1,res);
        int[] chnged=new int[N];
        System.arraycopy(res, 0, chnged, 0, chnged.length);
        chnged[i]=A[i];
        recurseArray(A,N,i+1,chnged);
    }

    public static void recurseArrayList(int[] A,int N,int i,ArrayList<Integer> res){
        if(i==N){
            for (int j=0; j<res.size() ;j++ ){
                System.out.print(res.get(j)+" ");
    		}
            System.out.println();
            return;
        }    
        recurseArrayList(A,N,i+1,res);
        res.add(A[i]);
        recurseArrayList(A,N,i+1,res);
        res.remove(res.size()-1);
    }

    public static void recurseArrayListWithK(int[] A,int N,int i,ArrayList<Integer> res,int k){
        if(i==N || res.size()==k){
            if(res.size()==k){
                for (int j=0; j<res.size() ;j++ ){
                    System.out.print(res.get(j)+" ");
                }
                System.out.println();
            }
            return;
        }    
        recurseArrayListWithK(A,N,i+1,res,k);
        res.add(A[i]);
        recurseArrayListWithK(A,N,i+1,res,k);
        res.remove(res.size()-1);
    }

    public static void minimumSubsequence(int[] A,int N,int i,ArrayList<Integer> res,int k,int[] min){
        if(i==N || res.size()==k){
            if(res.size()==k){
                int tmp=0;
                for (int j=0; j<res.size() ;j++ ){
                    tmp+=res.get(j);
                }
                min[0]=Math.min(min[0],tmp);
            }
            return;
        }    
        minimumSubsequence(A,N,i+1,res,k,min);
        res.add(A[i]);
        minimumSubsequence(A,N,i+1,res,k,min);
        res.remove(res.size()-1);

    }

    public static void allMinimumSubsequence(int[] A,int N,int i,ArrayList<Integer> res,int k,int[] min,int[] count){
        if(i==N || res.size()==k){
            if(res.size()==k){
                int tmp=0;
                for (int j=0; j<res.size() ;j++ ){
                    tmp+=res.get(j);
                }
                if(tmp<min[0]){
                    min[0]=tmp;
                    count[0]=1;
                }
                else if(tmp==min[0])
                    count[0]++;
            }
            return;
        }    
        allMinimumSubsequence(A,N,i+1,res,k,min,count);
        res.add(A[i]);
        allMinimumSubsequence(A,N,i+1,res,k,min,count);
        res.remove(res.size()-1);

    }

    public static int nCr(int n,int r){
        int[][] A=new int[n+1][r+1];
        int k=0;
        for (int i=0; i<=n ;i++ ){
            A[i][0]=1;
            if(k<=r){
                A[0][k]=1;
                A[i][k]=1;
                k++;
            }
        }

        for (int i=1; i<=n ;i++ ){
            for (int j=1; j<=r && j<=i ;j++ ){
                if(i!=j)
                    A[i][j]=A[i-1][j-1]+A[i-1][j];
            }
    	}
        
        return A[n][r];
    }
    public static void main(String args[]){
        try{
			Scanner ob=new Scanner(System.in);

            int N=ob.nextInt();
            int k=ob.nextInt();
            // String str=ob.next();

    		    
    		// int[] A=new int[N];
    		    
    		// for (int i=0; i<N ;i++ ){
    		//     A[i]=ob.nextInt();
    		// }
    	    
    	    // recurse(str,0,"");
            // recurseArray(A, N, 0, new int[N]);
            // recurseArrayList(A, N, 0, new ArrayList<>());
            // recurseArrayListWithK(A, N, 0, new ArrayList<>(),k);
            // int[] min=new int[1];
            // min[0]=Integer.MAX_VALUE;
            // minimumSubsequence(A, N, 0, new ArrayList<>(), k, min);
            // int[] count=new int[1];
            // allMinimumSubsequence(A, N, 0, new ArrayList<>(), k, min, count);
            // System.out.println(Arrays.toString(count));
            System.out.println(nCr(N,k));

		}catch(Exception e){
			return;
		}
    }
}