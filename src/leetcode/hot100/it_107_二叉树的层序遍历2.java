package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层序遍历为：
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class it_107_二叉树的层序遍历2 {
    public static void main(String[] args) {
        Integer[] nums={3,9,20,null,null,15,7};
        ITreeNode node = ITreeNode.makeTree(nums);
        List<List<Integer>> lists = new it_107_二叉树的层序遍历2().levelOrderBottom(node);
        ListUtil.arrayTwo(lists);
    }
    public List<List<Integer>> levelOrderBottom(ITreeNode root) {
        if (root==null)return new ArrayList<>();
        Stack<List<Integer>> stack=new Stack<>();
        List<List<Integer>> res=new ArrayList<>();
        Queue<ITreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int curLen=queue.size();
            List<Integer> ans=new ArrayList<>();
            for (int i = 0; i < curLen; i++) {
                ITreeNode node = queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                ans.add(node.val);
            }
            stack.add(ans);
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
