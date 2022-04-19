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
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list

So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */
public class AddTwoNumbersAsLists {
    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode res=new ListNode(-1),head=res;
        int num=0,carry=0;
        while(A!=null || B!=null){
            num=carry;
            if(A!=null) num+=A.val;
            if(B!=null) num+=B.val;
            carry=num/10;
            res.next=new ListNode(num%10);

            res=res.next;
            if(A!=null) A=A.next;
            if(B!=null) B=B.next;
        }
        if(carry!=0){
            res.next=new ListNode(1);
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
        
        ListNode res=addTwoNumbers(head.next,head2.next);

        printLinkedList("Add Two Numbers as List is :",res);

    }
}
