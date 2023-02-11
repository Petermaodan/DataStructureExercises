package it_23_二叉树;


import it_Base.ITreeNode;

import java.util.ArrayList;

public class Test4_从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        ArrayList<Integer> arrays=ITreeNode.sequenceTraverse(new Test4_从前序与中序遍历序列构造二叉树().buildTree(preorder,inorder));
        for (Integer array : arrays) {
            System.out.print(array);
            System.out.print(" ");
        }


    }

    public ITreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    public ITreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart>preEnd)return null;
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal=preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index=0;
        for (int i = inStart; i <=inEnd ; i++) {
            if (inorder[i]==rootVal){
            index=i;
            //防止多余操作
            break;
            }
        }
        ITreeNode root=new ITreeNode(rootVal);
        int leftSize=index-inStart;
        root.left=build(preorder,preStart+1,preStart+leftSize,
                inorder,inStart,index-1);
        root.right=build(preorder,preStart+leftSize+1,preEnd,
                inorder,index+1,inEnd);
        return root;
    }
}
