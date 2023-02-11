package jianzhioffer;

import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class it_32_2_从上到下打印二叉树2 {
    public List<List<Integer>> levelOrder(ITreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<ITreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                ITreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(ans);
        }
        return res;
    }
}
