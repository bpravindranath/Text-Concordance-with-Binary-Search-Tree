/**
 * Created by Barnabas_Ravindranath on 4/9/17.
 */

//node class
public class BSTNode {

    BSTNode left, right;
    public String word;
    public int frequency;

    //constructor
    public BSTNode(String s){
        left = null;
        right = null;
        frequency = 0;
        word = s;
    }

    //sets node to lef
    public void setLeft(BSTNode n){

        left = n;

    }
    //sets node to right node
    public void setRight(BSTNode n) {

        right = n;
    }

    //gets pointer to left node
    public BSTNode getLeft(){

        return left;

    }

    //gets pointer to right node
    public BSTNode getRight(){

        return right;

    }

    //increments the frequency of word
    public void increaseFrequency(int n) {

        frequency = frequency + n;

    }

    public int decreaseFrequency(int n) {

       return frequency = frequency - n;

    }

    //sets the string word to new string s t
    public void setString(String s) {

        word = s;

    }

    //returns frequency of an individual node
    public int getFrequency(){

        return frequency;

    }

    //returns word of an individual node
    public String getstring(){

        return word;

    }


}
