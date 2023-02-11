package leetcode.moni;

import it_Base.ITreeNode;

public class it_2_计算二叉搜索树任意两节点差绝对值的最小值 {
    public static void main(String[] args) {
        Integer[] nums={543,384,652,null,445,null,699};
        ITreeNode root=ITreeNode.makeTree(nums);
        int res=new it_2_计算二叉搜索树任意两节点差绝对值的最小值().getMinimumDifference(root);
        System.out.println(res);

    }
    public int getMinimumDifference(ITreeNode root) {

        if (root==null){
            return Integer.MAX_VALUE;
        }
        int rightValue;
        int leftValue;

        if (root.right!=null){
            ITreeNode rightRoot=root.right;
            ITreeNode rightleftRoot=rightRoot;
            while (rightleftRoot.left!=null){
                rightleftRoot=rightleftRoot.left;
            }
            rightValue=Math.abs(rightleftRoot.val-root.val);
        }else {
            rightValue=Integer.MAX_VALUE;
        }
        if (root.left!=null){
            ITreeNode leftRoot=root.left;
            ITreeNode leftrightRoot=leftRoot;

            while (leftrightRoot.right!=null){
                leftrightRoot=leftrightRoot.right;
            }
            leftValue=Math.abs(leftrightRoot.val-root.val);
        }else {
            leftValue=Integer.MAX_VALUE;
        }

        int min=Math.min(rightValue,leftValue);

        //递归查找左右子树
        int left=getMinimumDifference(root.left);
        int right=getMinimumDifference(root.right);
        return Math.min(min,Math.min(left,right));
    }
}
