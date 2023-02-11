package jianzhioffer;

import it_Base.ITreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
使用后续遍历进行解题是关键，一般这种类型的题目-》需要涉及二叉树深度的题目
 */
public class it_55_2_平衡二叉树 {
    public static void main(String[] args) {
        Integer[] nums={3,9,20,null,null,15,7};
        ITreeNode root = ITreeNode.makeTree(nums);
        boolean res = new it_55_2_平衡二叉树().isBalanced(root);
        System.out.println(res);
    }

    public boolean isBalanced(ITreeNode root) {
        int res=recur(root);
        return res==-1?false:true;
    }

    private int recur(ITreeNode root) {
        if (root==null)return 0;
        int left=recur(root.left);
        if (left==-1)return -1;
        int right=recur(root.right);
        if (right==-1)return -1;
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
}
