package jianzhioffer2;

import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 * 示例 1：
 * <p>
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 */
public class it_56_二叉搜索树中两个节点之和 {
    public static void main(String[] args) {
        Integer[] nums = {8, 6, 10, 5, 7, 9, 11};
        int k = 12;
        ITreeNode root = ITreeNode.makeTree(nums);
        boolean res = new it_56_二叉搜索树中两个节点之和().findTarget(root, k);
        System.out.println(res);
    }

    List<Integer> list = new ArrayList<>();

    public boolean findTarget(ITreeNode root, int k) {
        dfs(root);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l) + list.get(r) == k) {
                return true;
            } else if (list.get(l) + list.get(r) > k) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    private void dfs(ITreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
