package jianzhioffer2;

import it_Base.ITreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 */
public class it_45_二叉树最底层最右边的值 {
    public static void main(String[] args) {
        Integer[] nums={1,2,3,4,null,5,6,null,null,7};
        ITreeNode root = ITreeNode.makeTree(nums);
        int bottomLeftValue = new it_45_二叉树最底层最右边的值().findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }
    public int findBottomLeftValue(ITreeNode root) {
        Deque<ITreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
        int leftValue=root.val;
        while (!deque.isEmpty()){
            int size=deque.size();
            for (int i = 0; i < size; i++) {
                ITreeNode node = deque.pollFirst();
                if (i==0){
                    leftValue=node.val;
                }
                if (node.left!=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
            }
        }
        return leftValue;
    }
}
