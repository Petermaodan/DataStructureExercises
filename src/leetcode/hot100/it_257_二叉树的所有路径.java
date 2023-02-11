package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。 
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 */
public class it_257_二叉树的所有路径 {
    public static void main(String[] args) {
        Integer[] tree = {1, 2, 3, null, 5};
        ITreeNode root = ITreeNode.makeTree(tree);
        List<String> res = new it_257_二叉树的所有路径().binaryTreePaths(root);
        ListUtil.arrayOneString(res);


    }

    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(ITreeNode root) {
        backtrack(root, "");
        return res;
    }

    private void backtrack(ITreeNode root, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }


        backtrack(root.left, path + root.val+"->");

        backtrack(root.right, path + root.val+"->");

    }
}
