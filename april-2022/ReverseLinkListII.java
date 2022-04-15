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
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:

Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:

Given m, n satisfy the following condition:

1 ≤ m ≤ n ≤ length of list.

Note 2:

Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 */
public class ReverseLinkListII {
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode cur=null,prev=null,next=null,toJoin=null;
        ListNode temp=A,head=A;
        int s=1;
        while(temp!=null){
            if(s==B){
                cur=temp;
                toJoin=prev;
                
                while(s!=(C+1) && cur!=null){
                    next=cur.next;
                    cur.next=prev;

                    prev=cur;
                    cur=next;
                    s++;
                }
                temp.next=cur;
                if(toJoin!=null)    toJoin.next=prev;
                else    head=prev;
                break;
            }
            s++;
            prev=temp;
            temp=temp.next;
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
        ListNode head=null,temp=null;

        head=new ListNode(ob.nextInt());
        for(int i=0;i<N-1;i++){
            temp=new ListNode(ob.nextInt());
            temp.next=head;
            head=temp;
        }
        int m=ob.nextInt();
        int n=ob.nextInt();

        printLinkedList("Linked List is : ",head);
        
        ListNode res=reverseBetween(head,m,n);

        printLinkedList("Reverse Alternate K Nodes Linked List is :",res);

    }
}
