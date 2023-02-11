package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.IListNode;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 *
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * 输出：true
 * 解释：每一层的节点值分别是：
 * 0 层：[1]
 * 1 层：[10,4]
 * 2 层：[3,7,9]
 * 3 层：[12,8,6,2]
 * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
 */
public class it_1609_奇偶树 {
    public static void main(String[] args) {
        Integer[] nums={2,12,8,5,9,null,null,18,16};
        ITreeNode root = ITreeNode.makeTree(nums);
        boolean res = new it_1609_奇偶树().isEvenOddTree(root);
        System.out.println(res);
    }
    public boolean isEvenOddTree(ITreeNode root) {
        if (root==null)return true;
        Queue<ITreeNode> queue=new LinkedList<>();
        queue.add(root);
        int high=0;
        while (!queue.isEmpty()){
            int curLen=queue.size();
            List<Integer> tempList=new ArrayList<>();
            for (int i = 0; i < curLen; i++) {
                ITreeNode node = queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                tempList.add(node.val);
            }
            ListUtil.arrayOne(tempList);
            boolean flag=check(high,tempList);
            if (flag){
                high++;
            }else {
                return false;
            }
        }
        return true;
    }

    private boolean check(int high, List<Integer> tempList) {
        int size = tempList.size();
        //奇数层
        if (high%2==0){
            if (size==1)return tempList.get(0)%2==1;
            for (int i = 0; i < size-1; i++) {
                if (tempList.get(i)<tempList.get(i+1)&&tempList.get(i)%2==1&&tempList.get(i+1)%2==1){
                    continue;
                }else {
                    return false;
                }
            }

        }
        //偶数层
        else {
            if (size==1)return tempList.get(0)%2==0;
            for (int i = 0; i < size-1; i++) {
                if (tempList.get(i)>tempList.get(i+1)&&tempList.get(i)%2==0&&tempList.get(i+1)%2==0){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
