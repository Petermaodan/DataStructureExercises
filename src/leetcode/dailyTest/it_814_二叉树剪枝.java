package leetcode.dailyTest;

import it_Base.ITreeNode;

/**
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 *
 */
public class it_814_二叉树剪枝 {
    public static void main(String[] args) {

    }
    public ITreeNode pruneTree(ITreeNode root) {
          return dfs(root);
    }

    private ITreeNode dfs(ITreeNode root) {
        if (root==null)return null;
        root.left=dfs(root.left);
        root.right=dfs(root.right);
        if (root.val==0&&root.left==null&&root.right==null){
            root=null;
        }
        return root;
    }
}
