package jianzhioffer;

import it_Base.ITreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 和树的子结构类似
 */
public class it_28_对称的二叉树 {

    public static void main(String[] args) {
        Integer[] nums={1,2,2,null,3,null,3};
        ITreeNode root=ITreeNode.makeTree(nums);
        boolean res=new it_28_对称的二叉树().isSymmetric(root);
        System.out.println(res);
    }


    public boolean isSymmetric(ITreeNode root) {
        //使用递归实现
        return root==null?true:recur(root.left,root.right);
    }

    public boolean recur(ITreeNode L, ITreeNode R) {
        if (L==null&&R==null)return true;
        if (L==null||R==null||L.val!=R.val)return false;
        //递归调用，这里非常关键
        return recur(L.left,R.right)&&recur(L.right,R.left);
    }
}
