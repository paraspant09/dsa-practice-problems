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
Detect And Remove Loop In A Linked List,
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example:

Input: 


              ______
             |     |
             \/    |
    1 -> 2 -> 3 -> 4


Return the node corresponding to node 3. 
 */
public class DetectAndRemoveLoopInALinkedList {
    public static ListNode removeLoop(ListNode a){
        ListNode slow=a,fast=a,temp=a;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                slow=a;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                //Remove the loop
                int i=1;
                while(!(i==0 && temp.next==slow)){
                    if(temp.next==slow) i--;
                    temp=temp.next;
                }
                temp.next=null;
                return slow;
            }
        }
        return null;
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
        int pos=ob.nextInt();
        ListNode A=new ListNode(-1),head=A;

        for(int i=0;i<N;i++){
            A.next=new ListNode(ob.nextInt());
            A=A.next;
        }
        printLinkedList("Linked List With Loop is : ",head.next);
        int i=0;
        ListNode temp=head.next;
        while (i!=pos && temp!=null) {
            i++;
            temp=temp.next;
        }
        A.next=temp;
        System.out.println("-->Loop To the "+(pos+1)+" th Node: "+temp+" ,With value="+temp.val);
        
        ListNode loopPlace=removeLoop(head.next);
        if(loopPlace==null) System.out.println("No Cycle.");
        else    System.out.println("Cycle at node = "+loopPlace+" ,With value="+loopPlace.val);

        printLinkedList("Detect And Remove Loop In A Linked List is :",head.next);

    }
}