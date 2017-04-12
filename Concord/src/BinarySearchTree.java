/**
 * Created by Barnabas_Ravindranath on 4/9/17.
 */

//Binary Search Tree Class
public class BinarySearchTree {

    private BSTNode root;

    //Main Constructor sets Root to Null
    public BinarySearchTree() {

        root = null;

    }

    //Returns True/False if tree is empty or not empty
    public boolean isEmpty() {

        return root == null;

    }

    //method that calls the private insertnode method
    public void insertnode(String s) {

        root = insertnode(root, s);

    }

    //recursively checks and places the new node in its correct order
    private BSTNode insertnode(BSTNode n, String s) {

        if (n == null) {
            n = new BSTNode(s);
            n.increaseFrequency(1);
        }

        else
            {

            if (s.compareTo(n.getstring()) < 0)

                n.left = insertnode(n.left, s);

            else if (s.compareTo(n.getstring()) > 0) {

                n.right = insertnode(n.right, s);

            }
            else {

                n.increaseFrequency(1);

            }

        }

        return n;
    }

    //function to find minimum value in the Binary Search tree
    private String findMinValue(BSTNode node){

        if(node != null) {

            while (node.left != null) {
                node = node.left;
            }

        }

        return node.getstring();
    }

    //Function to find maximum value in the Binary Search Tree
    private BSTNode findMax(BSTNode node){

        if(node != null) {

            while(node.right != null) node = node.right;
        }

        return node;
    }

    //Calls the private delete method
    public void delete(String s) {

       root =  delete(root, s);

    }

    //searches and deletes correct node
    private BSTNode delete(BSTNode n, String s) {

        BSTNode p, p2;

        //base case: if tree is empy
        if (root == null) return root;

        //recursively find node to delete
        if(s.compareTo(n.getstring()) < 0) {
            n.left = delete(n.getLeft(), s);

        }
        else if(s.compareTo(n.getstring()) > 0) {
            n.right = delete(n.getRight(), s);

        }

        //found node to be deleted
        else {

            if(n.frequency == 1) {
               // System.out.println("hi");

                //both if and else if statement delete node with one child
                if (n.left == null) return n.right;

                else if (n.right == null) return n.left;

                //Deletes node with two children by getting the in order successor
                else {

                    //the successor is the smallest value in the right subtree
                    n.word = findMinValue(n.right);

                    //deletes the inorder successor
                    n.right = delete(n.right, n.getstring());
                }
            }

            //decrease the frequency count of a the node to be deleted that appears more than once
            System.out.println("Node Frequency was decreased from " + n.getFrequency() + ": " + n.decreaseFrequency(1) + "\n");

        }

        return n;
    }

    //calls the private method count nodes and returns integer of how many nodes in Binary Tree
    public int countNodes() {

        return countNodes(root);

    }

    //recursively checks how many nodes in tree and returns integer
    private int countNodes(BSTNode r) {

        if (r == null)

            return 0;

        else {

            int l = 1;

            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());

            return l;
        }
    }

    //method to that calls private method search
    public boolean search(String val, int update) {

        return search(root, val, update);

    }

    //Function to search for an element recursively and will update frequency of element,
    // if element already exist in Binary Search Tree
    private boolean search(BSTNode r, String val, int update) {

        boolean found = false;

        while ((r != null) && !found) {

            if (val.compareTo(r.getstring()) < 0) {
                r = r.getLeft();

            } else if (val.compareTo(r.getstring()) > 0) {
                r = r.getRight();

            } else {

                if (update == 1) r.increaseFrequency(1);

                found = true;
                break;
            }

            found = search(r, val,  update);
        }
        return found;
    }

    //Calls private method that will display In-Order traversal method
    public void inorder() {

        inorder(root);

    }

    //Recursively displays the In-Order Traversal of the Binary Search Tree
    private void inorder(BSTNode r) {

        if (r != null) {

            inorder(r.getLeft());

            System.out.println(r.getstring() + " | Frequency: " + r.getFrequency());

            inorder(r.getRight());
        }
    }

    //Calls private method that will display Pre-Order traversal method
    public void preorder() {

        preorder(root);

    }

    //Recursively displays the Pre-Order Traversal of the Binary Search Tree
    private void preorder(BSTNode r) {

        if (r != null) {

            add_tab(get_node_depth(r.getstring()));

            System.out.println(r.getstring());

            preorder(r.getLeft());

            preorder(r.getRight());
        }
    }

    //Calls private method that will display Post-Order traversal method
    public void postorder() {
        postorder(root);
    }

    //Recursively displays the Post-Order Traversal of the Binary Search Tree
    private void postorder(BSTNode r) {
        if (r != null) {
            postorder(r.getLeft());

            postorder(r.getRight());

            System.out.println(r.getstring() + " | Frequency: " + r.getFrequency());

        }
    }

    //Calls private method to find maxdepth of Binary Search Tree and returns an integer of the max depth
    public int maxDepth() {
        return maxDepth(root);
    }

    //recursively checks for maxdepth of binary search tree
    private int maxDepth(BSTNode node) {

        if (node != null)

            return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));

        else

            return 0;
    }

    //calls private method to get a single nodes depth in the Binary Search Tree and returns an integer of depth
    public int get_node_depth(String val) {

        return get_node_depth(root, val, 0);

    }

    //recursively finds an individual nodes depth
    private int get_node_depth(BSTNode r, String val, int level) {


        if (r == null) return 0;

        else {

            if (val.compareTo(r.getstring()) < 0) return get_node_depth(r.getLeft(), val, (level + 1));

            else if (val.compareTo(r.getstring()) > 0) return get_node_depth(r.getRight(), val, (level + 1));

            else return level;

            }

        }

    //prints n tabs according to an individual nodes depth
    public void add_tab(int x){

        for(int y = 0; y <= x; y++){

            System.out.print("\t" + "- ");

        }
    }


}

