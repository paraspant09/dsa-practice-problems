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
 * Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3
 */
public class InsertionSortList {
    public static ListNode insertionSortList(ListNode A) {
        if(A==null) return A;
        ListNode next=A.next;
        ListNode dummy=new ListNode(-1),res=dummy;

        while(A!=null){
            next=A.next;
            dummy=res;
            while(dummy.next!=null && dummy.next.val<A.val){
                dummy=dummy.next;
            }
            A.next=dummy.next;
            dummy.next=A;

            A=next;
        }
        
        return res.next;
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
        
        ListNode res=insertionSortList(head.next);

        printLinkedList("Insertion Sorted List is :",res);

    }
}