/**
 * Created by Barnabas_Ravindranath on 4/9/17.
 */



import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.String;


public class CONCORD {

    private static LinkedList<String> words;

    public static void main(String[] args) {

        //creates an Object of the Class Binary Search Tree
        BinarySearchTree node = new BinarySearchTree();

        //Creates new Linked List
        words = new LinkedList<>();

        //calls the method to create linked list of words from input file
        words = Create_List("concordinput.txt");

        //loop to add words to linkedlist
        while(!words.isEmpty()){

            //search Binary Search Tree and returns true if word is already in the Tree and then will
            // increment the word frequency by 1 and remove the word from list
            if(node.search(words.peek(), 1)) words.pop();

            //if thw word is not in the Binary Search Tree, then the insertnode method is called
            else node.insertnode(words.pop());

        }

            System.out.println("\t\t\t\t\tIn-Order Traversal Method \n");

        //Displays the Binary Search Tree in In-Order Traversal Method
        node.inorder(); System.out.println("\n\n");

            System.out.println("\t\t\t\t\tPre-Order Traversal Method \n");

        ///Displays the Binary Search Tree in Pre-Order Traversal Method
        node.preorder(); System.out.println("\n\n");

        //counts and prints the total amount of nodes in a Binary Search Tree
        System.out.println("The total amount of nodes is: " + node.countNodes() + "\n");

        //Retrieves and prints the Max Depth in a Binary Search Tree
        System.out.println("The max depth is: " + node.maxDepth() + "\n");

        //Calls method to delete node with a frequency of 1 and then Displays the Binary Search Tree
        // in In-Order Traversal Method
        node.delete("SHIPPED"); node.inorder(); System.out.println("\n");

        //Calls method to delete node with a frequency of does not delete node
        // but rather deletes by decreasing the frequency,
        // and then Displays the Binary Search Tree in In-Order Traversal Method
        node.delete("MY"); node.inorder();

    }

    // Creates and Returns a Linked List of words from the file
    public static LinkedList Create_List(String file){


        Scanner scan = null;

        LinkedList<String> w = new LinkedList<>();

        try {
            scan = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //will scan line and remove any object starting with non-alphabetical character(number or symbol).
        while (scan.hasNext()) {

            String line = scan.next();

                if (line.charAt(0) >= 'A' && line.charAt(0) <= 'Z'){

                    line = line.replaceAll("\\p{P}", "");

                    w.add(line);
                }
        }

        return w;
    }



}
