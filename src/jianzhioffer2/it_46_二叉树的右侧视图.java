package jianzhioffer2;

import it_Base.ITreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]

 */
public class it_46_二叉树的右侧视图 {
    public static void main(String[] args) {

    }
    public List<Integer> rightSideView(ITreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<ITreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
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
                if (i==size-1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
