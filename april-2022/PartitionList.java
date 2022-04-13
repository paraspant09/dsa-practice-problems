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
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,

Given 1->4->3->2->5->2 and x = 3,

return 1->2->2->4->3->5.
 */
public class PartitionList {
    public static ListNode partition(ListNode A, int B) {
        ListNode tail=A;
        int len=0;
        if(A==null) return A;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        len++;
        ListNode temp=A,prev=null;
        while(len-->0){
            if(temp.val>=B && temp!=tail){
                if(prev!=null)  prev.next=temp.next;
                else    A=temp.next;

                tail.next=temp;
                tail=temp;
                tail.next=null;

                if(prev!=null)  temp=prev.next;
                else    temp=A;
            }
            else{
                prev=temp;
                temp=temp.next;
            }
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
        ListNode head=null,temp=null;

        head=new ListNode(ob.nextInt());
        for(int i=0;i<N-1;i++){
            temp=new ListNode(ob.nextInt());
            temp.next=head;
            head=temp;
        }
        int B=ob.nextInt();

        printLinkedList("Linked List is : ",head);
        
        ListNode res=partition(head,B);

        printLinkedList("Partition Linked List is :",res);

    }
}
