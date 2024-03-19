import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BTNode{
    int data;

    BTNode left;

    BTNode right;

    public BTNode(int data){
        this.data = data;
    }
}


public class BinaryTreeExample {

    //Inserting into the binary tree
    public static BTNode insertBT(BTNode root,int val){
        BTNode newNode = new BTNode(val);
        if(root == null){
            root = newNode;
            return root;
        }
        if(root.left == null){
            root.left=insertBT(root.left,val);
        }
        else if(root.right == null){
            root.right = insertBT(root.right,val);
        }
        else{
            root.left = insertBT(root.left,val);
        }
        return root;
    }

    //Searching for a node in the binary tree
    public static boolean BTSearch(BTNode root,int val){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        boolean ans1 = BTSearch(root.left,val);
        boolean ans2 = BTSearch(root.right,val);
        return ans1||ans2;
    }

    //Updating a node in the Binary Tree
    public static void BTUpdate(BTNode root,int oldVal, int newVal){
        if(root == null){
            return;
        }
        else if(root.data == oldVal){
            root.data = newVal;
        }
        else{
            BTUpdate(root.left,oldVal,newVal);
            BTUpdate(root.right,oldVal,newVal);
        }
    }

    //Deleting a node from the binary search tree

    //Step-1 Find the minimum valued node in the binary tree
    public static BTNode findMinimum(BTNode root){
        if(root.left == null){
            return root;
        }
        return findMinimum(root.left);
    }

    //Step-2 Now try to delete the node from the tree
    public static BTNode deleteNode(BTNode root,int val){
        if(root == null){
            return null;
        }
        if(root.data == val){
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                BTNode minNode = findMinimum(root.right);
                root.data = minNode.data;
                root.right = deleteNode(root.right,minNode.data);
            }
        }
        root.left = deleteNode(root.left,val);
        root.right = deleteNode(root.right,val);
        return root;
    }

    //Displaying the binary tree using BFS
    public static void printTree(BTNode root){
        Queue<BTNode> qbfs = new LinkedList<>();
        qbfs.add(root);
        while(!qbfs.isEmpty()){
            BTNode temp = qbfs.remove();
            System.out.println(temp.data + " ");
            if(temp.left != null)
                qbfs.add(temp.left);
            if(temp.right != null)
                qbfs.add(temp.right);

        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        BTNode root = null;

        do {

            n = sc.nextInt();
            switch(n) {
                case 0 : break;

                case 1:
                    int num = sc.nextInt();
                    root = insertBT(root, num);

                    break;

                case 2:
                    int key = sc.nextInt();
                    int value = sc.nextInt();
                    BTUpdate(root, key, value);

                    break;

                case 3:
                    int key1 = sc.nextInt();
                    root = deleteNode(root,key1);

                    break;

                case 4:
                    int searchNum = sc.nextInt();
                    boolean res = BTSearch(root, searchNum);

                    if(res) {
                        System.out.println("Node found");
                    }
                    else {
                        System.out.println("Node not found");
                    }

                    break;

                case 5:
                    printTree(root);

                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }



        }while(n!=0);
        sc.close();
    }

}
