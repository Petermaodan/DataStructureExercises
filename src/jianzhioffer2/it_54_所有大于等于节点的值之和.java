package jianzhioffer2;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 */
public class it_54_所有大于等于节点的值之和 {
    public static void main(String[] args) {
        Integer[] nums={4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        ITreeNode root = ITreeNode.makeTree(nums);
        ITreeNode node = new it_54_所有大于等于节点的值之和().convertBST(root);
        ArrayList<Integer> arrayList = ITreeNode.sequenceTraverse(node);
        ListUtil.arrayOne(arrayList);
    }

    int curSum=0;
    public ITreeNode convertBST(ITreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(ITreeNode root) {
        if (root==null){
            return;
        }
        dfs(root.right);
        int temp=curSum+root.val;
        root.val=temp;
        curSum=temp;
        dfs(root.left);
    }
}
