package niuke;

import it_Base.ITreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7}
 *
 * 使用，使用栈和队列来实现
 */
public class it_23_二叉树的之字形层序遍历 {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (ITreeNode root) {
        // write code here
        // write code here
        // write code here
        ArrayList<ArrayList<Integer>> ret=new ArrayList<>();
        if (root==null)return ret;

        //队列实现树的层序遍历
        Queue<ITreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int count=1;//通过奇偶性判断所处的位置是第几层
        while (!queue.isEmpty()){
            ArrayList<Integer> subRet=new ArrayList<>();
            int currentRetSize=queue.size();
            for (int i = 0; i < currentRetSize; i++) {
                ITreeNode node=queue.poll();
                subRet.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            //判断奇偶，是否要翻转链表
            if ( count%2==1){
                ret.add(subRet);
                count++;
            }else {
                Collections.reverse(subRet);
                ret.add(subRet);
                count++;
            }
        }
        return ret;
    }
}
