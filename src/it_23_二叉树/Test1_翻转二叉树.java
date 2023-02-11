package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;

public class Test1_翻转二叉树 {
    public static void main(String[] args) {
        Integer[] trees = {1, 2, 3, 4, 6, 7, 9};
        ITreeNode root = new ITreeNode().makeTree(trees);
        ArrayList<Integer> arrays = new ITreeNode().afterTraverse(root);
        for (Integer integer : arrays) {
            System.out.print(integer);
            System.out.print(" ");
        }
        System.out.println("================");
        ITreeNode root2=new Test1_翻转二叉树().invertTree(root);
        ArrayList<Integer> arrays2=new ITreeNode().afterTraverse(root2);
        for (Integer integer : arrays2) {
            System.out.print(integer);
            System.out.print(" ");
        }


    }

    //翻转二叉树就是要将左右节点进行翻转
    public ITreeNode invertTree(ITreeNode root) {

        //base case:
        if (root == null) return null;
        ITreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;


        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
