package jianzhioffer;

import it_02_BFSDFS.it_572_另一颗树的子树;
import it_Base.ITreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 这题和子树存在不同，这题是子结构

 */
public class it_26_树的子结构 {
    public static void main(String[] args) {
        Integer[] nums1={10,12,6,8,3,11};
        Integer[] nums2={10,12,6,8};
        ITreeNode A = ITreeNode.makeTree(nums1);
        ITreeNode B = ITreeNode.makeTree(nums2);
        boolean res=new it_26_树的子结构().isSubStructure(A,B);
        System.out.println(res);
    }

    public boolean isSubStructure(ITreeNode A, ITreeNode B) {
        if (B==null||A==null)return false;
        //实际上是先序遍历的那种感觉
        return check(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);

    }


    private boolean check(ITreeNode A, ITreeNode B) {
        //超过B的叶子节点，不一定要同时到达叶子节点，包含在其中也可以
        //超过就可以返回了，跳出递归，表明其是子树
        if (B==null)return true;
        if (A==null||A.val!=B.val)return false;
        return check(A.left,B.left)&&check(A.right,B.right);
    }
}
