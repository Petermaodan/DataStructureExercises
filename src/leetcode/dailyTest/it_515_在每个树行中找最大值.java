package leetcode.dailyTest;

import it_Base.ITreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class it_515_在每个树行中找最大值 {
    public static void main(String[] args) {

    }
    public List<Integer> largestValues(ITreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<ITreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size=deque.size();
            int maxValue=Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                ITreeNode node = deque.pollFirst();
                if (node.left!=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
                maxValue=Math.max(node.val,maxValue);
            }
            res.add(maxValue);
        }
        return res;
    }
}
