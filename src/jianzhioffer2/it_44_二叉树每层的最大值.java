package jianzhioffer2;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 *  
 *
 * 示例1：
 *
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 */
public class it_44_二叉树每层的最大值 {
    public static void main(String[] args) {
        Integer[] root = {1,3,2,5,3,null,9};
        ITreeNode node = ITreeNode.makeTree(root);
        List<Integer> list = new it_44_二叉树每层的最大值().largestValues(node);
        ListUtil.arrayOne(list);
    }
    public List<Integer> largestValues(ITreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<ITreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
        int maxValue=Integer.MIN_VALUE;
        while (!deque.isEmpty()){
            int size=deque.size();
            for (int i = 0; i < size; i++) {
                ITreeNode node = deque.pollFirst();
                if (node.left!=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
                maxValue=Math.max(maxValue,node.val);
                if (i==size-1){
                    res.add(maxValue);
                    maxValue=Integer.MIN_VALUE;
                }
            }
        }
        return res;
    }
}
