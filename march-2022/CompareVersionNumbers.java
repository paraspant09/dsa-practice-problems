import java.util.Scanner;

/**
 * Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.

The . character does not represent a decimal point and is used to separate number sequences.

For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
public class CompareVersionNumbers {
    public static int compare(String A,String B){
        int i=0,k=0;
        while(k<A.length() && Integer.parseInt(""+A.charAt(k))==0)  k++;
        A=A.substring(k);
        k=0;
        while(k<B.length() && Integer.parseInt(""+B.charAt(k))==0)  k++;
        B=B.substring(k);

        if(A.length()>B.length())   return 1;
        if(A.length()<B.length())   return -1;

        while(i<A.length() && (Integer.parseInt(""+A.charAt(i))==Integer.parseInt(""+B.charAt(i)))) i++;
        if(i>=A.length())   return 0;
        int a=Integer.parseInt(""+A.charAt(i));
        int b=Integer.parseInt(""+B.charAt(i));

        if(a>b) return 1;
        else if(a<b) return -1;
        else    return 0;
    }
    public static int compareVersion(String A, String B) {
        String[] ver1=A.split("\\.");
        String[] ver2=B.split("\\.");
        if(ver1.length == 1){
            ver1=new String[] { ver1[0], "0", "0" };
        }
        else if(ver1.length == 2){
            ver1=new String[] { ver1[0], ver1[1], "0" };
        }
        if(ver2.length == 1){
            ver2=new String[] { ver2[0], "0", "0" };
        }
        else if(ver2.length == 2){
            ver2=new String[] { ver2[0], ver2[1], "0" };
        }

        int one=compare(ver1[0],ver2[0]);
        if(one==0){
            int two=compare(ver1[1],ver2[1]);
            if(two==0){
                return compare(ver1[2],ver2[2]);
            }
            return two;
        }

        return one;

    }
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        
        String A=ob.next();
        String B=ob.next();

        System.out.println(compareVersion(A,B));
    }
}

