import java.util.*;

public class RemoveDuplicatesSorted {
    public static int removeDuplicates(int[] nums) {
        int len=nums.length;
        int count=1;
        int cur_i=1;
        int cur_val=len>0 ? nums[0]:0;
        
        for(int i=1;i<len;i++){
            if(nums[i]!=cur_val){
                nums[cur_i++]=nums[i];
                cur_val=nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);

        int lengthOfArray=ob.nextInt();
    		    
    	int[] Array=new int[lengthOfArray];
    		    
    	for (int i=0; i<lengthOfArray ;i++ ){
    	    Array[i]=ob.nextInt();
    	}

        int n=removeDuplicates(Array);

        for (int i=0; i<n ;i++ ){
    	    System.out.print(Array[i]+" ");
    	}
        System.out.println();
    }
}
