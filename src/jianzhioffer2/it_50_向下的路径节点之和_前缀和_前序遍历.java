package jianzhioffer2;

import it_Base.ITreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 */
public class it_50_向下的路径节点之和_前缀和_前序遍历 {
    public static void main(String[] args) {
        Integer[] nums = {10,5,-3,3,2,null,11,3,-2,null,1};
        int targetSum = 8;
        ITreeNode root = ITreeNode.makeTree(nums);
        int res = new it_50_向下的路径节点之和_前缀和_前序遍历().pathSum2(root, targetSum);
        System.out.println(res);
    }

    //方法二：前缀和
    Map<Long,Integer> prefix=new HashMap<>();
    int ret=0;
    private int pathSum2(ITreeNode root, int targetSum) {
        //起始值
        prefix.put(0L,1);
        //回溯
        dfs(root,0,targetSum);
        return ret;
    }

    private void dfs(ITreeNode root, long curValue, int targetSum) {
        if (root==null){
            return;
        }
        curValue+=root.val;
        ret+=prefix.getOrDefault(curValue-targetSum,0);
        prefix.put(curValue,prefix.getOrDefault(curValue,0)+1);

        dfs(root.left,curValue,targetSum);
        dfs(root.right,curValue,targetSum);
        prefix.put(curValue,prefix.getOrDefault(curValue,0)-1);
    }


    //方法一：遍历每个节点
    int res=0;
    public int pathSum(ITreeNode root, int targetSum) {
        if (root==null){
            return 0;
        }
        rootSum(root,targetSum);
        if (root.left!=null){
            pathSum(root.left,targetSum);
        }
        if (root.right!=null){
            pathSum(root.right,targetSum);
        }
        return res;
    }

    private void rootSum(ITreeNode root, int targetSum) {
        if (root==null){
            return;
        }
        if (root.val==targetSum){
            res++;
        }
        rootSum(root.left,targetSum-root.val);
        rootSum(root.right,targetSum-root.val);
    }
}
