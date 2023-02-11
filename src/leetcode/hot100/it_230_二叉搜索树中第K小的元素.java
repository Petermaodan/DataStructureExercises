package leetcode.hot100;

import it_Base.ITreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 利用二叉搜索树中序遍历有序的特性，
 */
public class it_230_二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        Integer[] nums={5,3,6,2,4,null,null,1};
        ITreeNode root = ITreeNode.makeTree(nums);
        int k=3;
        int res = new it_230_二叉搜索树中第K小的元素().kthSmallest(root, k);
        System.out.println(res);
    }

    int res=0;
    int count=0;
    public int kthSmallest(ITreeNode root, int k) {
        if (root==null)return -1;
        findK(root,k);
        return res;
    }

    private void findK(ITreeNode root, int k) {
        //使用二叉搜索树中序遍历的特性
        //跳出递归
        if (root==null)return;
        findK(root.left,k);
        count++;
        if (count==k){
            res=root.val;
        }
        findK(root.right,k);
    }
}
