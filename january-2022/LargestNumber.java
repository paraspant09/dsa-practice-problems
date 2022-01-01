import java.util.Scanner;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static void SortArray(int[] A,int i,int j){
        if(i<j){
            int mid=(j+i)/2;
            SortArray(A,i,mid);
            SortArray(A,mid+1,j);
            Merge(A,i,mid,mid+1,j);
        }
    }

    public static void Merge(int[] A,int a0,int an,int b0,int bn){
        int n1=an-a0+1;
        int n2=bn-b0+1;

        int L[] = new int[n1];
        int R[] = new int[n2];
  
        for (int i = 0; i < n1; i++)
            L[i] = A[a0 + i];
        for (int j = 0; j < n2; j++)
            R[j] = A[b0 + j];

        int i=0,j=0,k=a0;
        
        while(i< n1 && j< n2){
            String val1=""+L[i]+""+R[j];
            String val2=""+R[j]+""+L[i];

            Long one=Long.parseLong(val1);
            Long two=Long.parseLong(val2);

            if(one>two){
                A[k++]=L[i++];
            }
            else{
                A[k++]=R[j++];
            }
        }

        while(i< n1){
            A[k++]=L[i++];
        }
        while(j< n2){
            A[k++]=R[j++];
        }
    }
    
    public static String largestNumber(final int[] A) {
        SortArray(A,0,A.length-1);

        String res="";
        boolean chk=true;

        for(int i=0;i<A.length;i++){
            if(chk && A[i]==0) continue;
            else    chk=false;
            res+=A[i];
        }

        if(res=="") res="0";
        
        return res;
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        System.out.println(largestNumber(Array));
    }
}
