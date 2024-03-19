import java.util.Scanner;

class BSTNode{
    int data;

    BSTNode left;

    BSTNode right;

    public BSTNode(int data){
        this.data = data;
    }
}


public class BinarySearchTreeExample {
    public static BSTNode BSTInsert(BSTNode root,int val){
        BSTNode newNode = new BSTNode(val);
        if(root == null){
            root = newNode;
            return root;
        }
        else if(root.data > val){
            root.left = BSTInsert(root.left,val);
        }
        else if(root.data < val){
            root.right = BSTInsert(root.right,val);
        }
        return root;
    }

    public static boolean searchBST(BSTNode root, int val){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        boolean ans1 = searchBST(root.left,val);
        boolean ans2 = searchBST(root.right,val);
        return ans1||ans2;
    }

    public static void BSTUpdate(BSTNode root,int oldVal, int newVal){
        if(root == null){
            return;
        }
        else if(root.data == oldVal){
            root.data = newVal;
        }
        else{
            BSTUpdate(root.left,oldVal,newVal);
            BSTUpdate(root.right,oldVal,newVal);
        }
    }

    public static BSTNode findMinimumBSTNode(BSTNode root){
        if(root.left == null){
            return root;
        }
        return findMinimumBSTNode(root.left);
    }

    //Step-2 Now try to delete the node from the tree
    public static BSTNode deleteBSTNode(BSTNode root,int val){
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
                BSTNode minNode = findMinimumBSTNode(root.right);
                root.data = minNode.data;
                root.right = deleteBSTNode(root.right,minNode.data);
            }
        }
        root.left = deleteBSTNode(root.left,val);
        root.right = deleteBSTNode(root.right,val);
        return root;
    }

    public static void printBSTTree(BSTNode root){
        if(root == null){
            return;
        }
        printBSTTree(root.left);
        System.out.print(root.data + " ");
        printBSTTree(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        BSTNode root = null;

        do {

            n = sc.nextInt();
            switch(n) {
                case 0 : break;

                case 1:
                    int num = sc.nextInt();
                    root = BSTInsert(root, num);

                    break;

                case 2:
                    int key = sc.nextInt();
                    int value = sc.nextInt();
                    BSTUpdate(root, key, value);

                    break;

                case 3:
                    int key1 = sc.nextInt();
                    root = deleteBSTNode(root,key1);

                    break;

                case 4:
                    int searchNum = sc.nextInt();
                    boolean res = searchBST(root, searchNum);

                    if(res) {
                        System.out.println("Node found");
                    }
                    else {
                        System.out.println("Node not found");
                    }

                    break;

                case 5:
                    printBSTTree(root);

                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }



        }while(n!=0);
        sc.close();

    }
}
