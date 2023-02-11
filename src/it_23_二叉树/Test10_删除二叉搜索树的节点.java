package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 *
 00
 */
public class Test10_删除二叉搜索树的节点 {
    public static void main(String[] args) {
        Integer[] rootval={5,3,6,2,4,null,7};
        ITreeNode root=ITreeNode.makeTree(rootval);
        ITreeNode rootresult=new Test10_删除二叉搜索树的节点().deleteNode(root,3);
        ArrayList<Integer> arrayList=ITreeNode.sequenceTraverse(rootresult);
        for (Integer integer : arrayList) {
            System.out.print(integer+" ");
        }


    }

    public ITreeNode deleteNode(ITreeNode root, int key) {
        if (root==null)return null;
        if (root.val==key){
            //三种情况分析，第一种无子孩子和第二种有一个子孩子可以合并到一起
            if (root.left==null)return root.right;
            if (root.right==null)return root.left;

            //第三种情况有两个子孩子，稍微复杂一点，需要寻找右子树中的最小值来替换他，右子树中的最小值在左左子树
            //找到替换的值
            ITreeNode minNode=getMin(root.right);
            //替换
            root.val=minNode.val;
            //删除替换的值
            root.right=deleteNode(root.right, minNode.val);
        }else if (root.val>key){
            root.left=deleteNode(root.left, key);
        }else if (root.val<key){
            root.right=deleteNode(root.right, key);
        }
        return root;
    }

    private ITreeNode getMin(ITreeNode root) {
        while (root.left!=null)root=root.left;
        return root;
    }
}
