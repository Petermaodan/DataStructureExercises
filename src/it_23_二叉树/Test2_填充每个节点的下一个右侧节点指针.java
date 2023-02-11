package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;

public class Test2_填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {
        Integer[] trees = {1, 2, 3, 4, 6, 7, 9};
        ITreeNode root = new ITreeNode().makeTree(trees);
        ArrayList<Integer> arrays = new ITreeNode().afterTraverse(root);
        for (Integer integer : arrays) {
            System.out.print(integer);
            System.out.print(" ");
        }
        ITreeNode root2 = new Test2_填充每个节点的下一个右侧节点指针().connect(root);
        ArrayList<Integer> arrays2 = new ITreeNode().afterTraverse(root);
        for (Integer integer : arrays2) {
            System.out.print(integer);
            System.out.print(" ");
        }
    }

    public ITreeNode connect(ITreeNode root) {
        if (root==null)return null;
        connectTwoNode(root.left,root.right);
        return root;
    }

    public void connectTwoNode(ITreeNode node1, ITreeNode node2) {
        if (node1==null||node2==null)return;

        //将两个节点连接
        node1.next=node2;
        //连接同一个父节点的两个子节点
        connectTwoNode(node1.left,node1.right);
        connectTwoNode(node2.left,node2.right);
        //连接不同父节点的两个子节点
        connectTwoNode(node1.right,node2.left);
    }
}
