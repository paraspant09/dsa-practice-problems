import java.util.Scanner;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1
 */
class InnerMinStack {
    Stack<Integer> stck;
    Stack<Integer> minstck;
    public InnerMinStack() {
        stck=new Stack<Integer>();
        minstck=new Stack<Integer>();
    }
    //push in the min stack only when x<=top of minstack
    //because whenever a greater than minstack top is pop from stack then
    //no minstack still hav min on top and when there are multiple min in stack then 
    //min stack contains all the mins
    public void push(int x) {
        if(minstck.isEmpty() || x<=minstck.peek()){
            minstck.push(x);
        }
        stck.push(x);
    }
    
    public int pop() {
        if(!stck.isEmpty()){
            int val=stck.pop();
            if(val==minstck.peek()) return minstck.pop();
        }
        return -1;
    }
    
    public int top() {
        if(!stck.isEmpty())
            return stck.peek();
        return -1;
    }
    
    public int getMin() {
        if(!minstck.isEmpty())
            return minstck.peek();
        return -1;
    }
}
public class MinStack {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);

        int M=ob.nextInt();
        int N=ob.nextInt();
        String[] op=new String[M];    //["push","push","push","getMin","pop","top","getMin"]
        int[] val=new int[N];   //[-2,0,-3]

        for(int i=0;i<M;i++){
            op[i]=ob.next();
        }
        for(int i=0;i<N;i++){
            val[i]=ob.nextInt();
        }
        InnerMinStack stack=new InnerMinStack();
        int j=0;
        for(int i=0;i<M;i++){
            if(op[i].equals("push")){
                System.out.println(val[j]+" is pushed into stack.");
                stack.push(val[j++]);
            }
            else if(op[i].equals("getMin")){
                System.out.println(stack.getMin()+" is minimum in stack.(If -1 then it means stack is empty)");
            }
            else if(op[i].equals("pop")){
                System.out.println(stack.pop()+" is popped from stack.(If -1 then it means stack is empty)");
            }
            else if(op[i].equals("top")){
                System.out.println(stack.top()+" is in top of stack.(If -1 then it means stack is empty)");
            }
        }
    }
}
