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
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.
 */
public class RemoveNthNodeFromListEnd {

    static int size(ListNode A){
        int i=0;
        while(A!=null){
            A=A.next;
            i++;
        }
        return i;
    }
    public static ListNode removeNthFromEnd(ListNode A, int B) {
        int nodeToDelete=size(A)-B,i=0;
        if(nodeToDelete<0)  return A.next;
        ListNode cur=A,prev=null;

        while(cur!=null){
            if(i==nodeToDelete){
                if(prev!=null){
                    prev.next=cur.next;
                    return A;
                }
                return cur.next;
            }
            i++;
            prev=cur;
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
        int B=ob.nextInt();

        printLinkedList("Linked List is : ",head.next);
        
        ListNode res=removeNthFromEnd(head.next,B);

        printLinkedList("Remove Nth Node From List End List is :",res);

    }
}