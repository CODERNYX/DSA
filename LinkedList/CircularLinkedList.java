class CLLNode{
    int data;
    CLLNode next;

    public CLLNode(int data){
        this.data = data;
    }
}


public class CircularLinkedList {

    static CLLNode insertRear(CLLNode head,int val){
        CLLNode newNode = new CLLNode(val);
        if(head == null){
            head = newNode;
            head.next = head;
            return head;
        }
        CLLNode curr = head;
        while(curr.next != head){
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = head;
        return head;
    }

    static CLLNode insertFront(CLLNode head,int val){
        CLLNode newNode = new CLLNode(val);
        if(head == null){
            head = newNode;
            head.next = head;
            return head;
        }
        newNode.next = head;
        CLLNode curr = head;
        while(curr.next != head){
            curr = curr.next;
        }
        curr.next = newNode;
        head = newNode;
        return head;
    }

    static CLLNode deleteRear(CLLNode head){
        if(head == null){
            return null;
        }
        CLLNode prev = null;
        CLLNode curr = head;
        while(curr.next != head){
            prev = curr;
            curr = curr.next;
        }
        prev.next = head;
        return head;
    }

    static CLLNode deleteFront(CLLNode head){
        if(head == null){
            return null;
        }
        CLLNode curr = head;
        while(curr.next != head){
            curr = curr.next;
        }
        curr.next = head.next;
        head = head.next;
        return head;
    }

    static void displayDLL(CLLNode head){

        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        CLLNode curr = head;
        System.out.print(curr.data + "->");
        curr = curr.next;
        while(curr != head){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("HEAD OF THE LIST");
    }


    public static void main(String[] args) {
        CLLNode head = null;
        head = insertRear(head,10);
        head = insertRear(head,20);
        head = insertRear(head,30);
        head = insertRear(head,40);
        head = insertRear(head,50);
        displayDLL(head);

        head = insertFront(head,60);
        head = insertFront(head,70);
        head = insertFront(head,80);
        head = insertFront(head,90);
        head = insertFront(head,100);
        displayDLL(head);

        /*head = deleteRear(head);
        displayDLL(head);

        head = deleteRear(head);
        displayDLL(head);*/

        head = deleteFront(head);
        displayDLL(head);

        head = deleteFront(head);
        displayDLL(head);
    }
}
