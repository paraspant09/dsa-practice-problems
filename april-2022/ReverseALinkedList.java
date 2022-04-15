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
 * Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 */
public class ReverseALinkedList {
    static ListNode reverse(ListNode A){
        ListNode prev=null,cur=A,next=null;

        while (cur!=null) {
            next=cur.next;
            cur.next=prev;

            prev=cur;
            cur=next;
        }

        return prev;
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
        ListNode head=null,temp=null;

        head=new ListNode(ob.nextInt());
        for(int i=0;i<N-1;i++){
            temp=new ListNode(ob.nextInt());
            temp.next=head;
            head=temp;
        }

        printLinkedList("Linked List is : ",head);
        
        ListNode res=reverse(head);

        printLinkedList("Reversed Linked List is :",res);

    }
}
