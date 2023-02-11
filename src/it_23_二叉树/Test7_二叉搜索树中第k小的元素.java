package it_23_二叉树;

import it_Base.ITreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）
 *
 * 利用二叉搜索树中序遍历升序的特性
 */
public class Test7_二叉搜索树中第k小的元素 {
    public static void main(String[] args) {
        Integer[] rootval={5,3,6,2,4, 8, 7,1};
        ITreeNode root=ITreeNode.makeTree(rootval);

        int res=new Test7_二叉搜索树中第k小的元素().kthSmallest(root,3);
        System.out.println(res);

    }

    public int kthSmallest(ITreeNode root, int k) {
        traverse(root,k);
        return res;
    }
    // 记录结果
    int res=0;
    // 记录当前元素的排名
    int rank=0;

    public void traverse(ITreeNode root, int k) {
        if (root==null)return;
        traverse(root.left,k);
        /* 中序遍历代码位置 */
        rank++;
        if (rank==k){
            res=root.val;
        }
        traverse(root.right,k);

    }


}
