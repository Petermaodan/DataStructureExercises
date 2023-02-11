package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;

public class Test4_最大二叉树 {
    public static void main(String[] args) {
        int[] nums={3,2,1,6,0,5};
        ITreeNode root=new Test4_最大二叉树().constructMaximumBinaryTree(nums);
        ArrayList<Integer> arrays=ITreeNode.sequenceTraverse(root);
        for (Integer integer : arrays) {
            System.out.print(integer);
            System.out.print(" ");
        }


    }
    public  ITreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }

    public ITreeNode build(int[] nums, int lo, int hi) {
        //base case:lo>hi时，nums is empty
        if (lo>hi)return null;

        //找到数组中的最大值
        int index=-1;int maxval=Integer.MIN_VALUE;
        for (int i = lo; i <=hi; i++) {
            if (nums[i]>maxval){
                maxval=nums[i];
                index=i;
            }
        }
        ITreeNode root=new ITreeNode(maxval);

        //递归调用构造左右子树
        root.left=build(nums,lo,index-1);
        root.right=build(nums,index+1,hi);
        return root;

    }
}
