class DLLNode{
    int data;
    DLLNode left;
    DLLNode right;

    public DLLNode(int data){
        this.data = data;
    }
}


public class DoublyLinkedList {

    static DLLNode insertRear(DLLNode head,int val){
        DLLNode newNode = new DLLNode(val);

        if(head == null){
            head = newNode;
            head.right = null;
            head.left = null;
            return head;
        }

        DLLNode curr = head;
        while(curr.right != null){
            curr = curr.right;
        }
        curr.right = newNode;
        newNode.left = curr;
        newNode.right = null;
        return head;
    }

    static DLLNode insertFront(DLLNode head,int val){
        DLLNode newNode = new DLLNode(val);
        if(head == null){
            head = newNode;
            head.right = null;
            head.left = null;
            return head;
        }

        newNode.right = head;
        head.left = newNode;
        head = newNode;
        return head;
    }

    static DLLNode deleteRear(DLLNode head){
        if(head == null){
            return null;
        }
        DLLNode curr = head;
        DLLNode prev = null;
        while(curr.right != null){
            prev = curr;
            curr = curr.right;
        }
        curr.left = null;
        prev.right = null;
        return head;

    }

    static DLLNode deleteFront(DLLNode head){
        if(head==null){
            return null;
        }
        DLLNode curr = head.right;
        curr.left = null;
        head.right = null;
        head = curr;
        return head;
    }

    static void display(DLLNode head){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        DLLNode curr = head;
        while(curr != null){
            System.out.print(curr.data + "->");
            curr = curr.right;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DLLNode head = null;
        head = insertRear(head,10);
        head = insertRear(head,20);
        head = insertRear(head,30);
        head = insertRear(head,40);
        head = insertRear(head,50);
        display(head);

        head = insertFront(head,60);
        head = insertFront(head,70);
        head = insertFront(head,80);
        head = insertFront(head,90);
        head = insertFront(head,100);
        display(head);

        /*deleteRear(head);
        display(head);

        deleteRear(head);
        display(head);*/

        head = deleteFront(head);
        display(head);

        head = deleteFront(head);
        display(head);
    }
}
