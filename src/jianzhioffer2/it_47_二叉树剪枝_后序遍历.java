package jianzhioffer2;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 *
 * 节点 node 的子树为 node 本身，以及所有 node 的后代。
 * 示例 1:
 *
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]

 */
public class it_47_二叉树剪枝_后序遍历 {
    public static void main(String[] args) {
        Integer[] nums={1,0,1,0,0,0,1};
        ITreeNode node = ITreeNode.makeTree(nums);
        ITreeNode root = new it_47_二叉树剪枝_后序遍历().pruneTree(node);
        ArrayList<Integer> list = ITreeNode.sequenceTraverse(root);
        ListUtil.arrayOne(list);
    }
    public ITreeNode pruneTree(ITreeNode root) {
        if (root==null){
            return null;
        }
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if (root.val==0&&root.left==null&&root.right==null){
            return null;
        }
        return root;
    }
}
