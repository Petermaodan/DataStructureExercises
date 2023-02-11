package jianzhioffer;

import it_Base.ITreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 采用先序遍历来解决
 */
public class it_68_2_二叉树的最近公共祖先 {
    public ITreeNode lowestCommonAncestor(ITreeNode root, ITreeNode p, ITreeNode q) {
        //总共有四种情况，分别判断p,q在root的那一边，不同的边导致返回的值不同
        //跳出递归
        if (root==null||root==p||root==q)return root;
        //递归
        ITreeNode left=lowestCommonAncestor(root.left,p,q);
        ITreeNode right=lowestCommonAncestor(root.right,p,q);
        //第一种，左右子树都不包含，返回null
        if (left==null&&right==null)return null;
        //2、left为空，right不为空,返回left
        if (left!=null&&right==null)return left;
        //3\为2的相反
        if (left==null&&right!=null)return  right;
        //4\同时不为空,返回中间的跟节点即可if (left!=null&&right!=null)
        return root;
    }
}
