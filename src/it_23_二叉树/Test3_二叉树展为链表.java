package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 采用后序遍历的方式
 */
public class Test3_二叉树展为链表 {
    public static void main(String[] args) {
        Integer[] trees = {1, 2, 3, 4, 6, 7, 9};
        ITreeNode root = new ITreeNode().makeTree(trees);
        ArrayList<Integer> arrays = new ITreeNode().afterTraverse(root);
        for (Integer integer : arrays) {
            System.out.print(integer);
            System.out.print(" ");
        }

        new Test3_二叉树展为链表().flatten(root);
        System.out.println();
        ArrayList<Integer> arrays2 = new ITreeNode().afterTraverse(root);
        for (Integer integer : arrays2) {
            System.out.print(integer);
            System.out.print(" ");
        }




    }
    public void flatten(ITreeNode root) {
        //base case:
        if (root==null)return;

        flatten(root.left);
        flatten(root.right);

        //将子节点拉成链表
        ITreeNode left=root.left;
        ITreeNode right=root.right;

        //将左子树移到右边
        root.left=null;
        root.right=left;

        //将右子树接上
        ITreeNode p=root;
        while (p.right!=null){
            p=p.right;
        }
        p.right=right;
    }
}
