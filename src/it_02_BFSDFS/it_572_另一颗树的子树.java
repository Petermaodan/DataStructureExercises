package it_02_BFSDFS;

import it_Base.ITreeNode;

/**
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 * 我们又需要做一次深度优先搜索来检查，即让两个指针一开始先指向该节点和 tt 的根，然后「同步移动」两根指针来「同步遍历」这两棵树，判断对应位置是否相等。
 *

 */
public class it_572_另一颗树的子树 {
//    public static void main(String[] args) {
////        Integer[] nums1={10,12,6,8,3,11};
////        Integer[] nums2={10,12,6,8};
////        ITreeNode.makeTree(nums1);
////        ITreeNode.makeTree(nums2);
////        boolean res=new it_572_另一颗树的子树()
////    }

    public boolean isSubtree(ITreeNode root, ITreeNode subRoot) {

         return dfs(root,subRoot);

    }

    private boolean dfs(ITreeNode root, ITreeNode subRoot) {
        if (root==null)return false;
        return check(root,subRoot)||dfs(root.left,subRoot)||dfs(root.right,subRoot);
    }

    private boolean check(ITreeNode root, ITreeNode subRoot) {
        if (root==null&&subRoot==null)return true;
        if (root==null||subRoot==null||root.val!=subRoot.val)return false;
        return check(root.left,subRoot.left)&&check(root.right,subRoot.right);
    }
}
