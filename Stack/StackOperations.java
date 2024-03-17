class Stack{
    int[] arr;
    int top = -1;

    public Stack(int n){
        arr = new int[n];
    }

    boolean isEmpty(){
        return top == -1;
    }

    boolean isFull(){
        return top==arr.length-1;
    }

    public void push(int n){
        if(isFull()){
            System.out.println("The stack is full. Cannot insert " + n);
            return;
        }
        top++;
        arr[top] = n;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("The Stack is empty");
            return -1;
        }
        return arr[top--];
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[top];
    }
}


public class StackOperations {
    public static void main(String[] args) {
        Stack t = new Stack(5);
        t.push(1);
        t.push(12);
        t.push(20);
        t.push(23);
        t.push(6);
        t.push(8);
        System.out.println("The top element is " + t.peek());
        System.out.println("The poped element is " + t.pop());
        System.out.println("The poped element is " + t.pop());
        System.out.println("The poped element is " + t.pop());
        System.out.println("The poped element is " + t.pop());
        System.out.println("The poped element is " + t.pop());
        System.out.println("The poped element is " + t.pop());
        System.out.println("End of the program");
    }
}
