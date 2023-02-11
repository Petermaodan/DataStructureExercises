package leetcode.hot100;

import it_Base.ITreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class it_543_二叉树的直径 {

    public static void main(String[] args) {
        Integer[] nums={1,2,3,4,5,null,null};
        ITreeNode root=ITreeNode.makeTree(nums);
        int res=new it_543_二叉树的直径().diameterOfBinaryTree(root);
        System.out.println(res);

    }

    int ans;

    public int diameterOfBinaryTree(ITreeNode root) {
        ans=1;
        depth(root);
        return ans-1;
    }

    private int depth(ITreeNode root) {
        if (root == null) {
         return 0;
        }
        int left=depth(root.left);
        int right=depth(root.right);
        //更新ans
        ans=Math.max(ans,left+right+1);
        //返回当前节点深度最大值
        return Math.max(left,right)+1;
    }
}
