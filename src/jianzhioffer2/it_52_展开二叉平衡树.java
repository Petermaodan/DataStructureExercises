package jianzhioffer2;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 */
public class it_52_展开二叉平衡树 {
    public static void main(String[] args) {
        Integer[] nums={5,3,6,2,4,null,8,1,null,null,null,7,9};
        ITreeNode root = ITreeNode.makeTree(nums);
        ITreeNode res = new it_52_展开二叉平衡树().increasingBST2(root);
        ArrayList<Integer> list = ITreeNode.sequenceTraverse(res);
        ListUtil.arrayOne(list);
    }

    //在中序遍历的过程中改变节点指向，在中序遍历过程中要得到上一个节点的引用
    ITreeNode preNode;
    private ITreeNode increasingBST2(ITreeNode root) {
        ITreeNode dummyNode=new ITreeNode(-1);
        preNode=dummyNode;
        inorder2(root);
        return dummyNode.right;
    }

    private void inorder2(ITreeNode root) {
        if (root==null){
            return;
        }
        inorder2(root.left);
        preNode.right=root;
        root.left=null;

        preNode=root;
        inorder2(root.right);
    }


    List<Integer> list=new ArrayList<>();
    public ITreeNode increasingBST(ITreeNode root) {
        inorder(root);
        ITreeNode res=new ITreeNode(-1);
        ITreeNode cur=res;
        for (Integer node : list) {
            cur.right=new ITreeNode(node);
            cur=cur.right;
        }
        return res.right;
    }

    private void inorder(ITreeNode root) {
        if (root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
