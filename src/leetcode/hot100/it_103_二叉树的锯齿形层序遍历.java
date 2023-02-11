package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class it_103_二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {
        Integer[] nums={3,9,20,null,null,15,7};
        ITreeNode root = ITreeNode.makeTree(nums);
        List<List<Integer>> lists = new it_103_二叉树的锯齿形层序遍历().zigzagLevelOrder(root);
        ListUtil.arrayTwo(lists);
    }
    public List<List<Integer>> zigzagLevelOrder(ITreeNode root) {
        if (root==null)return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Queue<ITreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=0;
        while (!queue.isEmpty()){
            List<Integer> subTree=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                ITreeNode node = queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                subTree.add(node.val);
            }
            if (count%2==1){
                Collections.reverse(subTree);
            }
            res.add(subTree);
            count++;
        }
        return res;
    }
}
