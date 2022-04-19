import java.util.Scanner;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { 
        val = x; 
        next = null; 
    }
}

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public static ListNode rotateRight(ListNode A, int B) {
        if(A==null) return A;
        ListNode cur=A,last=null;
        int size=0;
        while(cur!=null){
            size++;
            last=cur;
            cur=cur.next;
        }
        
        B=B%size;
        if(B==0)    return A;
        B=size-B;
        
        last.next=A;
        cur=A;
        while(--B>0 && cur!=null){
            cur=cur.next;
        }
        last=cur.next;
        cur.next=null;
        return last;
    }
    public static void printLinkedList(String str,ListNode head){
        System.out.println(str);
        while(head!=null){
            System.out.print(head.val+" -> ");
            head=head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int N1=ob.nextInt();
        ListNode A=new ListNode(-1),head=A;

        for(int i=0;i<N1;i++){
            A.next=new ListNode(ob.nextInt());
            A=A.next;
        }

        int B=ob.nextInt();

        printLinkedList("Linked List is : ",head.next);
        
        ListNode res=rotateRight(head.next,B);

        printLinkedList("Rotate List, Linked Lists is :",res);

    }
}
