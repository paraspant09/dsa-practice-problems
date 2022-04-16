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
 * Merge two sorted linked lists and return it as a new list. 

The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode l1=A,l2=B;
        ListNode res=new ListNode(-1),head=res;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                res.next=l2;
                l2=l2.next;
            }
            else{
                res.next=l1;
                l1=l1.next;
            }
            res=res.next;
        }
        while(l1!=null){
            res.next=l1;
            l1=l1.next;
            res=res.next;
        }
        while(l2!=null){
            res.next=l2;
            l2=l2.next;
            res=res.next;
        }

        return head.next;
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

        int N2=ob.nextInt();
        ListNode B=new ListNode(-1),head2=B;

        for(int i=0;i<N2;i++){
            B.next=new ListNode(ob.nextInt());
            B=B.next;
        }

        printLinkedList("Linked List A is : ",head.next);
        printLinkedList("Linked List B is : ",head2.next);
        
        ListNode res=mergeTwoLists(head.next,head2.next);

        printLinkedList("Merged List is :",res);

    }
}
