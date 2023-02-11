package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;

public class Test5_从中序与后续遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        ArrayList<Integer> arrays= ITreeNode.sequenceTraverse(new Test5_从中序与后续遍历序列构造二叉树().buildTree(postorder,inorder));
        for (Integer array : arrays) {
            System.out.print(array);
            System.out.print(" ");
        }
    }

    public ITreeNode buildTree(int[] postorder, int[] inorder) {
        return build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    private ITreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart>postEnd)return null;

        System.out.println("postStart"+postStart);
        System.out.println("postEnd"+postEnd);
        int rootVal=postorder[postEnd];

        int index=-1;
        for (int i = inStart; i <=inEnd; i++) {
            if (inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        ITreeNode root=new ITreeNode(rootVal);
        int leftSize=index-inStart;
        root.left=build(inorder,inStart,index-1,
                postorder,postStart,postStart+leftSize-1);
        root.right=build(inorder,index+1,inEnd,
                postorder,postStart+leftSize,postEnd-1);
        return root;
    }
//    public ITreeNode build2(int[] inorder, int inStart, int inEnd,
//                   int[] postorder, int postStart, int postEnd) {
//
//        if (postStart>postEnd) {
//            return null;
//        }
//        // root 节点对应的值就是后序遍历数组的最后一个元素
//        int rootVal = postorder[postEnd];
//        // rootVal 在中序遍历数组中的索引
//        int index = 0;
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == rootVal) {
//                index = i;
//                break;
//            }
//        }
//        // 左子树的节点个数
//        int leftSize = index - inStart;
//        ITreeNode root = new ITreeNode(rootVal);
//        // 递归构造左右子树
//        root.left = build(inorder, inStart, index - 1,
//                postorder, postStart, postStart + leftSize - 1);
//
//        root.right = build(inorder, index + 1, inEnd,
//                postorder, postStart + leftSize, postEnd - 1);
//        return root;
//    }
}
