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

You need to find the value of the Bth node from the middle towards the beginning of the Linked List A.

If no such element exists, then return -1.

NOTE:

Position of middle node is: (N/2)+1, where N is the total number of nodes in the list.


Problem Constraints
1 <= N <= 105
1<= Value in Each Link List Node <= 103
1 <= B <= 105


Input Format
First argument is the head pointer of the linkedlist A.

Second argument is an integer B.



Output Format
Return an integer denoting the value of the Bth from the middle towards the head of the linked list A. If no such element exists, then return -1.



Example Input
Input 1:

 A = 3 -> 4 -> 7 -> 5 -> 6 -> 1 6 -> 15 -> 61 -> 16
 B = 3
 Input 2:

 A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 B = 2
 Input 3:

 A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 B = 10


Example Output
Output 1:

 4
 Output 2:

 14
 Output 3:

 -1


Example Explanation
Explanation 1:

 The Middle of the linked list is the node with value 6.
 The 1st node from the middle of the linked list is the node with value 5.
 The 2nd node from the middle of the linked list is the node with value 7.
 The 3rd node from the middle of the linked list is the node with value 4.
 So we will output 4.
Explanation 2:

 The Middle of the linked list is the node with value 16.
 The 1st node from the middle of the linked list is the node with value 6.
 The 2nd node from the middle of the linked list is the node with value 14.
 So we will output 14.
Explanation 3:

 The Middle of the linked list is the node with value 16.
 There are only 3 nodes to the left of the middle node and we need to find the 10th node which doesn't exist so we will return -1.
 */
public class KthNodeFromMiddle {
    public static int solve(ListNode A, int B) {
        ListNode temp=A;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int mid=len/2 + 1;
        int toFind=mid-B;
        if(toFind<=0)   return -1;
        temp=A;
        while(temp!=null){
            toFind--;
            if(toFind==0){
                return temp.val;
            }
            temp=temp.next;
        }
        return 0;
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

        int K=ob.nextInt();

        printLinkedList("Linked List is : ",head);

        System.out.println("Kth Node from Middle is :"+solve(head,K));

    }
}
