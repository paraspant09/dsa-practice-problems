import java.util.Scanner;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { 
        val = x; 
        next = null; 
    }
}

/**Problem Description

Given a linked list A , reverse the order of all nodes at even positions.



Problem Constraints
1 <= Size of linked list <= 100000



Input Format
First and only argument is the head of the Linked-List A.



Output Format
Return the head of the new linked list.



Example Input
Input 1:

A = 1 -> 2 -> 3 -> 4
Input 2:

A = 1 -> 2 -> 3


Example Output
Output 1:

 1 -> 4 -> 3 -> 2
Output 2:

 1 -> 2 -> 3


Example Explanation
Explanation 1:

Nodes are positions 2 and 4 have been swapped.
Explanation 2:

No swapping neccassary here.
 */
public class EvenReverse {
    public static ListNode solve(ListNode A) {
        ListNode temp=A,temp2=null;
        ListNode evenList=null,newNode=null;
        int i=0;
        while(temp!=null){
            if((i&1)==1){
                newNode=new ListNode(temp.val);
                if(evenList!=null)  newNode.next=evenList;
                evenList=newNode;
            }
            i++;
            temp=temp.next;
        }
        temp=A;
        temp2=evenList;
        i=0;
        while(temp!=null){
            if((i&1)==1){
                temp.val=temp2.val;
                temp2=temp2.next;
            }
            temp=temp.next;
            i++;
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

        printLinkedList("Linked List is : ",head);
        
        ListNode res=solve(head);

        printLinkedList("Even Reverse Linked List is :",res);

    }
}
