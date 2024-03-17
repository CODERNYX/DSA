class SLLNode{
    int data;
    SLLNode next;

    public SLLNode(int data){
        this.data = data;
    }
}


public class SinglyLinkedList {

    static SLLNode insertRear(SLLNode head,int val){
        SLLNode newNode = new SLLNode(val);
        if(head==null){
            head = newNode;
            return head;
        }
        SLLNode curr = head;
        while(curr.next !=  null){
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = null;
        return head;
    }

    static void displaySLL(SLLNode head){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        SLLNode curr = head;
        while(curr!=null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    static SLLNode insertFront(SLLNode head, int val){
        SLLNode newNode = new SLLNode(val);
        if(head == null){
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    static SLLNode deleteRear(SLLNode head){
        if(head == null){
            return null;
        }
        SLLNode curr = head, prev = null;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }

    static SLLNode deleteFront(SLLNode head){
        if(head == null){
            return null;
        }
        SLLNode curr = head;
        head = curr.next;
        curr.next = null;
        return head;
    }

    public static void main(String[] args) {
        SLLNode head = null;
        head = insertRear(head,10);
        head = insertRear(head,20);
        head = insertRear(head,30);
        head = insertRear(head,40);
        head = insertRear(head,50);
        displaySLL(head);

        head = insertFront(head,60);
        head = insertFront(head,70);
        head = insertFront(head,80);
        head = insertFront(head,90);
        head = insertFront(head,100);
        displaySLL(head);

        /*head = deleteRear(head);
        displaySLL(head);

        head = deleteRear(head);
        displaySLL(head);*/

        head = deleteFront(head);
        displaySLL(head);

        head = deleteFront(head);
        displaySLL(head);
    }
}
