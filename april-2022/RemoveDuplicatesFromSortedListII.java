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
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,

Given 1->2->3->3->4->4->5, return 1->2->5.

Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode A) {
        if(A==null) return A;
        ListNode cur=A.next,prev=A,preprev=null,head=A;
        boolean toDelete=false;
        while(cur!=null){
            if(prev.val!=cur.val){
                if(toDelete){
                    if(preprev!=null)   preprev.next=cur;
                    else    head=cur;
                    
                    prev=cur;
                    toDelete=false;
                }
                else{
                    preprev=prev;
                    prev=prev.next;
                }
            }
            else    toDelete=true;
            
            cur=cur.next;
        }
        if(toDelete){
            if(preprev!=null)   preprev.next=cur;
            else    head=cur;
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
