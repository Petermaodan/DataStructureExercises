package jianzhioffer;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 经典的层序遍历
 */

public class it_32_1_从上到下打印二叉树 {
    public static void main(String[] args) {
        Integer[] nums={3,9,20,15,7};
        ITreeNode root = ITreeNode.makeTree(nums);
        int[] res = new it_32_1_从上到下打印二叉树().levelOrder(root);
        ListUtil.arrayOneNums(res);

    }
    public int[] levelOrder(ITreeNode root) {
        if (root==null)return new int[]{};
        List<Integer> res=new ArrayList<>();
        Queue<ITreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int curLen=queue.size();
            for (int i = 0; i < curLen; i++) {
                ITreeNode node = queue.poll();
                res.add(node.val);
                if (node.left!=null)queue.add(node.left);
                if (node.right!=null)queue.add(node.right);
            }
        }
        int[] result=new int[res.size()];
        for (int i = 0; i <res.size() ; i++) {
            result[i]=res.get(i);
        }
        return result;
    }
}
