package it_23_二叉树;

import it_Base.ITreeNode;

/**
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 对于每一个节点root，代码值检查了它的左右孩子节点是否符合左小右大的原则；
 * 但是根据 BST 的定义，root的整个左子树都要小于root.val，整个右子树都要大于root.val。
 *
 * 我们通过使用辅助函数，增加函数参数列表，在参数中携带额外信息，将这种约束传递给子树的所有节点，这也是二叉树算法的一个小技巧吧
 */
public class Test9_验证二叉搜索树 {
    public static void main(String[] args) {
        Integer[] rootval={5,1,4,null,null,3,6};
        ITreeNode root=ITreeNode.makeTree(rootval);
        boolean res=new Test9_验证二叉搜索树().isValidBST(root);
        System.out.println(res);
    }

    public boolean isValidBST(ITreeNode root) {
        return isValidBST(root,null,null);

    }

    private boolean isValidBST(ITreeNode root, ITreeNode min, ITreeNode max) {
        if (root==null)return true;
        if (max!=null&&root.val>=max.val)return false;
        if (min!=null&&root.val<=min.val)return false;

        return isValidBST(root.left,min,root)&&isValidBST(root.right,root,max);
    }
}
