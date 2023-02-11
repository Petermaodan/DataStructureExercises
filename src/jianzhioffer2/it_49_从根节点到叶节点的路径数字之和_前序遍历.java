package jianzhioffer2;

import it_Base.ITreeNode;
import leetcode.dailyTest.it_1022_从根到叶的二进制数之和;

/**
 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 *
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 */
public class it_49_从根节点到叶节点的路径数字之和_前序遍历 {
    public static void main(String[] args) {
        Integer[] nums={1,2,3};
        ITreeNode root = ITreeNode.makeTree(nums);
        int res = new it_49_从根节点到叶节点的路径数字之和_前序遍历().sumNumbers(root);
        System.out.println(res);
    }
    int res=0;
    public int sumNumbers(ITreeNode root) {
        dfs(root,0);
        return res;
    }

    private void dfs(ITreeNode root, int temp) {
        if (root==null){
           return;
        }
        temp=temp*10+root.val;
        if (root.left!=null){
            dfs(root.left,temp);
        }
        if (root.right!=null){
            dfs(root.right,temp);
        }
        if(root.left==null&&root.right==null){
            res+=temp;
        }
    }
}
