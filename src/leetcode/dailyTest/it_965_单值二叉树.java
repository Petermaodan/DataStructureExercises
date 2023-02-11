package leetcode.dailyTest;

import it_Base.ITreeNode;

/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class it_965_单值二叉树 {
    public static void main(String[] args) {
        Integer[] trees={1,1,1,1,1,null,1};
        ITreeNode root = ITreeNode.makeTree(trees);
        boolean res = new it_965_单值二叉树().isUnivalTree(root);
        System.out.println(res);
    }

    public boolean isUnivalTree(ITreeNode root) {
        if (root==null)return true;
        int num=root.val;
        return dfs(root,num);
    }

    private boolean dfs(ITreeNode root, int num) {
        if (root==null)return true;
        if (root.val!=num){
            return false;
        }
        return dfs(root.left,num)&&dfs(root.right,num);
    }
}
