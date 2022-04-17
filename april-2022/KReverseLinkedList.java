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
 * Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

NOTE : The length of the list is divisible by K

Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.
 */
public class KReverseLinkedList {
    static ListNode reverse(ListNode A,int B){
        if(A==null) return null;

        ListNode cur=A,prev=null,next=null;
        int i=B;
        while(i-->0 && cur!=null){
            next=cur.next;
            cur.next=prev;

            prev=cur;
            cur=next;
        }
        A.next=reverse(cur,B);
        return prev;
    }
    public static ListNode reverseList(ListNode A, int B) {
        return reverse(A,B);
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
        
        ListNode res=reverseList(head.next,B);

        printLinkedList("K= "+B+" Reverse Linked List is :",res);

    }
}
