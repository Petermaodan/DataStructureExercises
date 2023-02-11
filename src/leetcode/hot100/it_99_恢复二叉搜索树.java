package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.IListNode;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * 示例 1：
 *
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 *
 */
public class it_99_恢复二叉搜索树 {
    public static void main(String[] args) {
        Integer[] nums={1,3,null,null,2};
        ITreeNode node = ITreeNode.makeTree(nums);
        new it_99_恢复二叉搜索树().recoverTree(node);
        ArrayList<Integer> arrayList = ITreeNode.sequenceTraverse(node);
        ListUtil.arrayOne(arrayList);
    }
    //方法一，利用二叉搜索树的中序遍历有序先找到两个错位的值，之后再交换两个节点
    //第一个错位的值前一个比后一个大，取前一个，后一个错位的值，前一个比后一个大，取后一个值
    public void recoverTree(ITreeNode root) {
        List<ITreeNode> list=new ArrayList<>();
        dfs(root,list);
        ITreeNode x=null;
        ITreeNode y=null;
        for (int i = 0; i < list.size()-1; i++) {
            //寻找交换的节点
            if (list.get(i).val>list.get(i+1).val){
                y=list.get(i+1);
                if (x==null){
                    x=list.get(i);
                }
            }
        }
        if (x!=null&&y!=null){
            int temp=x.val;
            x.val=y.val;
            y.val=temp;
        }
    }
    private void dfs(ITreeNode root, List<ITreeNode> list) {
        //中序遍历，有序添加到list中
        if (root==null)return;
        dfs(root.left,list);
        list.add(root);
        dfs(root.right,list);
    }
}
