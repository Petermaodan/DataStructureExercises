package leetcode.dailyTest;

import it_Base.ITreeNode;

import java.util.*;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 */
public class it_1022_从根到叶的二进制数之和 {
    public static void main(String[] args) {
        Integer[] nums={1,0,1,0,1,0,1};
        ITreeNode root = ITreeNode.makeTree(nums);
        int res = new it_1022_从根到叶的二进制数之和().sumRootToLeaf2(root);
        System.out.println(res);
    }

    //迭代
    private int sumRootToLeaf2(ITreeNode root) {
        int ans = 0;
        Deque<ITreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            ITreeNode poll = d.pollFirst();
            if (poll.left != null) {
                poll.left.val = (poll.val << 1) + poll.left.val;
                d.addLast(poll.left);
            }
            if (poll.right != null) {
                poll.right.val = (poll.val << 1) + poll.right.val;
                d.addLast(poll.right);
            }
            if (poll.left == null && poll.right == null) ans += poll.val;
        }
        return ans;

    }


    //递归
    int ans=0;
    public int sumRootToLeaf(ITreeNode root) {
        dfs(root,0);
        return ans;
    }

    private void dfs(ITreeNode root, int ncur) {
        int temp=(ncur<<1)+root.val;
        if (root.left!=null){
            dfs(root.left,temp);
        }
        if (root.right!=null){
            dfs(root.right,temp);
        }
        if (root.right==null&&root.left==null){
            ans+=temp;
        }
    }
}
