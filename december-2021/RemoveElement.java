import java.util.*;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int len=nums.length;
        int count=0;
        int cur_i=0;
        
        for(int i=0;i<len;i++){
            if(nums[i]!=val){
                nums[cur_i++]=nums[i];
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

        int val=ob.nextInt();

        int n=removeElement(Array,val);

        for (int i=0; i<n ;i++ ){
    	    System.out.print(Array[i]+" ");
    	}
        System.out.println();
    }
}
