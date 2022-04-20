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
 * Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,

Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public static ListNode reorderList(ListNode A) {
        if(A==null) return A;
       //To reach the center of ist and reverse the right half of list
       //1->2->3->4 => 1->2->3<-4 => 1->4->2->3
       //One pointer from left one from right
       ListNode slow=A,fast=A,prev=null,next=null;
       while(slow!=null && fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
       }
       //reverse
       ListNode cur=slow;
       while(cur!=null){
           fast=cur.next;
           cur.next=prev;
           
           prev=cur;
           cur=fast;
       }
       cur=A;
       fast=prev;
       while(cur!=fast && cur.next!=fast){
           slow=cur.next;//2
           next=fast.next;//3
           fast.next=cur.next;//4->2
           cur.next=fast;//1->4
           
           cur=slow;
           fast=next;
       }
       return A;
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
        
        ListNode res=reorderList(head.next);

        printLinkedList("Reorder List is :",res);

    }
}
