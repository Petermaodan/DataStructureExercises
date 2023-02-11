package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * <p>
 * 同样利用遍历的框架
 */
public class Test11_701二叉搜索树中的插入操作 {
    public static void main(String[] args) {
        Integer[] rootval = {4, 2, 7, 1, 3};
        ITreeNode root = ITreeNode.makeTree(rootval);
        ITreeNode rootresult = new Test11_701二叉搜索树中的插入操作().insertIntoBST(root,5);
        ArrayList<Integer> arrayList = ITreeNode.sequenceTraverse(rootresult);
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
    }

    public ITreeNode insertIntoBST(ITreeNode root, int val) {
        if (root==null){
            return new ITreeNode(val);
        }
        //二叉搜索树不会插入相同的值
        if (root.val>val){
            root.left=insertIntoBST(root.left,val);
        }else if (root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}
