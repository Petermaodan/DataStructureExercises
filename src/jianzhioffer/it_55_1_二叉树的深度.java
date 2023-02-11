package jianzhioffer;

import it_Base.ITreeNode;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class it_55_1_二叉树的深度 {
    public static void main(String[] args) {
        Integer[] nums={3,9,20,null,null,15,7};
        ITreeNode root = ITreeNode.makeTree(nums);
        int res = new it_55_1_二叉树的深度().maxDepth(root);
        System.out.println(res);
    }

    public int maxDepth(ITreeNode root) {
        if (root==null)return 0;
        //实际上是后序遍历
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
