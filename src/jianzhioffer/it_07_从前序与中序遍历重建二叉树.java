package jianzhioffer;

import it_23_二叉树.Test4_从前序与中序遍历序列构造二叉树;
import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class it_07_从前序与中序遍历重建二叉树 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        ArrayList<Integer> arrays=ITreeNode.sequenceTraverse(new it_07_从前序与中序遍历重建二叉树().buildTree(preorder,inorder));
        for (Integer array : arrays) {
            System.out.print(array);
            System.out.print(" ");
        }


    }

    public ITreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    private ITreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart>preEnd)return null;
        int preValue=preorder[preStart];
        //找到中序遍历根节点的索引
        int index=0;
        //中序遍历在inStart到inEnd的范围内寻找
        for (int i = inStart; i <=inEnd; i++) {
            if (inorder[i]==preValue){
                index=i;
                break;
            }
        }
        ITreeNode root=new ITreeNode(preValue);
        int leftSize=index-inStart;
        root.left=buildTree(preorder,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        root.right=buildTree(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);

        return root;
    }

}
