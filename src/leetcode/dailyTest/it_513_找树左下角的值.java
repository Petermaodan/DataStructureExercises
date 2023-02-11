package leetcode.dailyTest;

import it_Base.ITreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 */
public class it_513_找树左下角的值 {
    public static void main(String[] args) {
        Integer[] nums={1,2,3,4,null,5,6,null,null,7};
        ITreeNode node = ITreeNode.makeTree(nums);
        int leftValue = new it_513_找树左下角的值().findBottomLeftValue(node);
        System.out.println(leftValue);
    }

    public int findBottomLeftValue(ITreeNode root) {
        Deque<ITreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
        int leftValue = root.val;
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
