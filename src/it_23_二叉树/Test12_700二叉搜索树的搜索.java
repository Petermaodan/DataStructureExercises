package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;

public class Test12_700二叉搜索树的搜索 {
    public static void main(String[] args) {
        Integer[] rootval = {4, 2, 7, 1, 3};
        ITreeNode root = ITreeNode.makeTree(rootval);
        ITreeNode rootresult =new Test12_700二叉搜索树的搜索().searchBST(root,1);
        ArrayList<Integer> arrayList = ITreeNode.sequenceTraverse(rootresult);
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
    }

    public ITreeNode searchBST(ITreeNode root, int val) {
        if (root==null||root.val==val)return root;
        return val<root.val?searchBST(root.left,val):searchBST(root.right,val);
    }
}
