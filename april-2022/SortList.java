import java.util.Scanner;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5
 */
public class SortList {
    static ListNode findMid(ListNode A){
        ListNode slow=A,fast=A,prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return prev;
    }
    static ListNode mergeSort(ListNode A){
        if (A.next == null)
            return A;
        ListNode m=findMid(A);
        ListNode temp=m.next;
        m.next=null;
        ListNode h1=mergeSort(A);
        ListNode h2=mergeSort(temp);
        return merge(h1,h2);
    }
    static ListNode merge(ListNode h1,ListNode h2){
        ListNode dummy=new ListNode(-1),res=dummy; 
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                dummy.next=h1;
                h1=h1.next;
            }
            else{
                dummy.next=h2;
                h2=h2.next;
            }
            dummy=dummy.next;
        }
        while(h1!=null){
            dummy.next=h1;
            h1=h1.next;
            dummy=dummy.next;
        }
        while(h2!=null){
            dummy.next=h2;
            h2=h2.next;
            dummy=dummy.next;
        }
        return res.next;
    }
    public static ListNode sortList(ListNode A) {
        return mergeSort(A);
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
        
        ListNode res=sortList(head.next);

        printLinkedList("Sorted List, Linked Lists is :",res);

    }
}
