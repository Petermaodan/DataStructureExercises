package jianzhioffer;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *
 */
public class it_32_3_从上到下打印二叉树3 {
    public static void main(String[] args) {
        Integer[] nums={3,9,20,null,null,15,7};
        ITreeNode root = ITreeNode.makeTree(nums);
        ListUtil.arrayTwo(new it_32_3_从上到下打印二叉树3().levelOrder(root));
    }
    public List<List<Integer>> levelOrder(ITreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<ITreeNode> queue=new LinkedList<>();
        if (root!=null)queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> subLevel=new ArrayList<>();
            int currentLevelSize=queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                ITreeNode node=queue.poll();
                subLevel.add(node.val);
                if (node.left!=null)queue.add(node.left);
                if (node.right!=null)queue.add(node.right);
            }
            //奇数层，需要翻转
            if ((res.size()&1)==1){
                //链表的翻转
                Collections.reverse(subLevel);
            }
            res.add(subLevel);
        }
        return res;
    }
}
