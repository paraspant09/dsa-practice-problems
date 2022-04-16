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
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,

Given 1->1->2, return 1->2.

Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode A) {
        if(A==null) return A;
        ListNode cur=A.next,prev=A;
        int val=A.val;
        while(cur!=null){
            if(cur.val!=val){
                val=cur.val;
                prev=cur;
            }
            else{
                prev.next=cur.next;       
            }
            
            cur=cur.next;
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

        int N=ob.nextInt();
        ListNode A=new ListNode(-1),head=A;

        for(int i=0;i<N;i++){
            A.next=new ListNode(ob.nextInt());
            A=A.next;
        }

        printLinkedList("Linked List is : ",head.next);
        
        ListNode res=deleteDuplicates(head.next);

        printLinkedList("Remove Duplicates From Sorted List is :",res);

    }
}
