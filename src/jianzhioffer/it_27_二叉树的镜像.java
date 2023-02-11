package jianzhioffer;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class it_27_二叉树的镜像 {

    public static void main(String[] args) {
        Integer[] nums={4,2,7,1,3,6,9};
        ITreeNode root=ITreeNode.makeTree(nums);
        ITreeNode res=new it_27_二叉树的镜像().mirrorTree2(root);

        ArrayList<Integer> list = ITreeNode.sequenceTraverse(root);

        ListUtil.arrayOne(list);
    }

    public ITreeNode mirrorTree(ITreeNode root) {
        dfs(root);
        return root;
    }


    private void dfs(ITreeNode root) {
        if (root==null)return;
        //采用后序遍历从下到上进行交换
        dfs(root.left);
        dfs(root.right);
        ITreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }


    public ITreeNode mirrorTree2(ITreeNode root){
        if (root==null)return null;
        Stack<ITreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            ITreeNode node = stack.pop();
            if (node.left!=null)stack.add(node.left);
            if (node.right!=null)stack.add(node.right);
            //交换子树
            ITreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
        }
        return root;
    }
}
