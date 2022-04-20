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
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,

Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapListNodesInPairs {
    public static ListNode swapPairs(ListNode A) {
        if(A==null || A.next==null) return A;
        ListNode next=null,head=A.next;
        while(A!=null && A.next!=null){
            next=A.next.next;

            A.next.next=A;

            if(next!=null && next.next!=null)    A.next=next.next;
            else    A.next=next;
            A=next;
        }
        return head;
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

        printLinkedList("Linked List is : ",head.next);
        
        ListNode res=swapPairs(head.next);

        printLinkedList("Swap List Nodes In Pairs, List is :",res);

    }
}
