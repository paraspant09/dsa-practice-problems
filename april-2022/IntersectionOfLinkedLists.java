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
 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 */
public class IntersectionOfLinkedLists {
    public static ListNode getIntersectionNode(ListNode a, ListNode b) {
		ListNode l1=a,l2=b,l;
		int sizel1=0,sizel2=0;
		while(l1!=null){
			sizel1++;
			l1=l1.next;
		}
		while(l2!=null){
			sizel2++;
			l2=l2.next;
		}
		l1=a;
		l2=b;
		int skip=Math.max(sizel1,sizel2)-Math.min(sizel1,sizel2);

		if(sizel1>sizel2)	l=l1;
		else	l=l2;
		while(skip>0 && l!=null){
			skip--;
			l=l.next;
		}
		if(sizel1>sizel2)	l1=l;
		else	l2=l;

		while(l1!=null && l2!=null){
			if(l1==l2)
				return l1;
			l1=l1.next;
			l2=l2.next;
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

        int N3=ob.nextInt();
        ListNode C=new ListNode(-1),head3=C;

        for(int i=0;i<N3;i++){
            C.next=new ListNode(ob.nextInt());
            C=C.next;
        }

        A.next=head3.next;
        B.next=head3.next;

        printLinkedList("Linked List A is : ",head.next);
        printLinkedList("Linked List B is : ",head2.next);
        
        ListNode res=getIntersectionNode(head.next,head2.next);

        printLinkedList("Intersection of Linked Lists is :",res);

    }
}