package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。

 */
public class Test8_把二叉搜索树转换为累加树 {
    public static void main(String[] args) {
        Integer[] rootval={4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        ITreeNode root=ITreeNode.makeTree(rootval);
        ITreeNode res=new Test8_把二叉搜索树转换为累加树().convertBST(root);
        ArrayList<Integer> arrayList=ITreeNode.sequenceTraverse(res);
        for (Integer integer : arrayList) {
            System.out.print(integer+" ");
        }
    }

    public ITreeNode convertBST(ITreeNode root) {
        traverse(root);
        return root;
    }
    //外部的累加变量
    int sum=0;
    public void traverse(ITreeNode root) {
        if (root==null)return;

        //改变中序遍历的顺序
        traverse(root.right);

        //将累加值赋给root.val
        sum+=root.val;
        root.val=sum;

        traverse(root.left);

    }


}
