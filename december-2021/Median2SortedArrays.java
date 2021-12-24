import java.util.*;

class Median2SortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        int len=nums1.length+nums2.length;
        int[] res=new int[len];
        while(i< nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j])
                res[k++]=nums1[i++];
            else
                res[k++]=nums2[j++];
        }
        
        if(i < nums1.length)
            while(i< nums1.length)
                res[k++]=nums1[i++];
        else
            while(j< nums2.length)
                res[k++]=nums2[j++];
        
        // System.out.println(Arrays.toString(res));
        int mid=len/2;
        double median=(len%2==0)? (res[mid-1]+res[mid])/2.0 : res[mid];
        return median;
    }
    public static void main(String[] args) {
        try {
            Scanner ob=new Scanner(System.in);

            int lengthOfArray1=ob.nextInt();
                    
            int[] Array1=new int[lengthOfArray1];
                    
            for (int i=0; i<lengthOfArray1 ;i++ ){
                Array1[i]=ob.nextInt();
            }

            int lengthOfArray2=ob.nextInt();
                    
            int[] Array2=new int[lengthOfArray2];
                    
            for (int i=0; i<lengthOfArray2 ;i++ ){
                Array2[i]=ob.nextInt();
            }

            double n=findMedianSortedArrays(Array1,Array2);

            System.out.println(n);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}