package jianzhioffer2;

import it_Base.ITreeNode;

/**
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 *
 */
public class it_53_二叉搜索树中的中序后继 {
    ITreeNode res;
    int flag=0;
    public ITreeNode inorderSuccessor(ITreeNode root, ITreeNode p) {
        if (root==null){
            return null;
        }
        inorderSuccessor(root.left,p);
        if (p.val<root.val&&++flag==1){
            res=root;
        }
        inorderSuccessor(root.right,p);
        return res;
    }
}
