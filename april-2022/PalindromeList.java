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
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.
 */
public class PalindromeList {
    public static int lPalin(ListNode A) {
        ListNode rev=A,temp=A.next,temp2=null;
        while(temp!=null){
            temp2=new ListNode(temp.val);
            temp2.next=rev;
            rev=temp2;
            temp=temp.next;
        }
        while(A!=null){
            if(A.val!=rev.val)  return 0;
            A=A.next;
            rev=rev.next;
        }
        return 1;
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
        
        if(lPalin(head)==1)
            System.out.println("List is a palndrome.");
        else
            System.out.println("List is not a palndrome.");

    }
}
