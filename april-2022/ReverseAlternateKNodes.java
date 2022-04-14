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
 * Problem Description

Given a linked list A of length N and an integer B.

You need to reverse every alternate B nodes in the linked list A.



Problem Constraints
1 <= N <= 105
1<= Value in Each Link List Node <= 103
1 <= B <= N
N is divisible by B


Input Format
First argument is the head pointer of the linkedlist A.

Second argument is an integer B.



Output Format
Return the head pointer of the final linkedlist as described.



Example Input
Input 1:

 A = 3 -> 4 -> 7 -> 5 -> 6 -> 6 -> 15 -> 61 -> 16
 B = 3
 Input 2:

 A = 1 -> 4 -> 6 -> 6 -> 4 -> 10
 B = 2


Example Output
Output 1:

 7 -> 4 -> 3 -> 5 -> 6 -> 6 -> 16 -> 61 -> 15
Output 2:

 4 -> 1 -> 6 -> 6 -> 10 -> 4


Example Explanation
Explanation 1:

 The linked list contains 9 nodes and we need to reverse alternate 3 nodes.
 First sublist of length 3  is 3 -> 4 -> 7 so on reversing it we get 7 -> 4 -> 3.
 Second sublist of length 3 is 5 -> 6 -> 6 we don't need to reverse it.
 Third sublist of length 3 is 15 -> 61 -> 16 so on reversing it we get 16 -> 61 -> 15.
Explanation 2:

 The linked list contains 6 nodes and we need to reverse alternate 2 nodes.
 First sublist of length 2 is 1 -> 4 so on reversing it we get 4 -> 1.
 Second sublist of length 2 is 6 -> 6 we don't need to reverse it.
 Third sublist of length 2 is 4 -> 10 so on reversing it we get 10 -> 4.
 */
public class ReverseAlternateKNodes {
    public static ListNode solve(ListNode A, int B) {
        int val=B;
        int i=0,len=0;
        ListNode prev=null,next=null,temp=A;
        ListNode head=null;
        ListNode toJoin=A,prevToJoin=null;
        while(temp!=null){
            if(val==0){
                val=B;
                if(i==0)    head=prev;
                
                if((i&1)==0){
                    if(prevToJoin!=null)    prevToJoin.next=prev;
                    toJoin.next=temp;
                }    
                toJoin=temp;
                i++;
            }
            
            val--;
            if((i&1)==0){
                next=temp.next;
                temp.next=prev;

                prev=temp;
                temp=next;
            }
            else{
                prevToJoin=prev=temp;
                temp=temp.next;
            }
            len++;
        }
        if(i==0)    head=prev;
        if(len!=B && (i&1)==0){
            if(prevToJoin!=null)    prevToJoin.next=prev;
            toJoin.next=temp;
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
        int B=ob.nextInt();

        printLinkedList("Linked List is : ",head);
        
        ListNode res=solve(head,B);

        printLinkedList("Reverse Alternate K Nodes Linked List is :",res);

    }
}
