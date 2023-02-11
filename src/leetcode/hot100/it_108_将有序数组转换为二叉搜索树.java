package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 分析：BST的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树。
 * 因此我们可以以升序序列中的任一个元素作为根节点，以该元素左边的升序序列构建左子树，
 * 以该元素右边的升序序列构建右子树，这样得到的树就是一棵二叉搜索树啦～ 又因为本题要求高度平衡，因此我们需要选择升序序列的中间元素作为根节点奥～
 *
 */
public class it_108_将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        ITreeNode node = new it_108_将有序数组转换为二叉搜索树().sortedArrayToBST(nums);
        ArrayList<Integer> arrayList = ITreeNode.sequenceTraverse(node);
        ListUtil.arrayOne(arrayList);
    }
    public ITreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }

    private ITreeNode dfs(int[] nums, int lo, int hi) {
        if (lo>hi)return null;
        int mid=(lo+hi)/2;
        ITreeNode root=new ITreeNode(nums[mid]);
        root.left=dfs(nums,lo,mid-1);
        root.right=dfs(nums,mid+1,hi);
        return root;
    }
}
