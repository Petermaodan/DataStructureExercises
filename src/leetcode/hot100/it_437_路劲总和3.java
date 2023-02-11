package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *

 前缀和＋回溯
 */

public class it_437_路劲总和3 {
    public static void main(String[] args) {
        Integer[] nums = {10,5,-3,3,2,null,11,3,-2,null,1};
        ITreeNode root=ITreeNode.makeTree(nums);
        List res=ITreeNode.sequenceTraverse(root);
        ListUtil.arrayOne(res);

        int result=new it_437_路劲总和3().pathSum(root,8);
        System.out.println(result);
    }
    public int pathSum(ITreeNode root, int targetSum) {
        //HashMap储存前缀和，value储存出现次数
        Map<Integer,Integer> prefixSumCount=new HashMap<>();
        //base case 前缀和为0的有一条
        prefixSumCount.put(0,1);
        return recurPathSum(root,prefixSumCount,targetSum,0);
    }

    private int recurPathSum(ITreeNode node, Map<Integer, Integer> prefixSumCount, int targetSum, int currSum) {
        //跳出递归
        if (node==null){
            return 0;
        }
        int res=0;//统计路径数
        currSum+=node.val;//当前节点的前缀和
        //获取满足条件的路径，即当前路径和减去目标数据，且存在的路径和
        res+=prefixSumCount.getOrDefault(currSum-targetSum,0);
        //对当前节点的路径和进行保存
        prefixSumCount.put(currSum,prefixSumCount.getOrDefault(currSum,0)+1);
        //对左右子树进行搜索
        res+=recurPathSum(node.left,prefixSumCount,targetSum,currSum);
        res+=recurPathSum(node.right,prefixSumCount,targetSum,currSum);
        //回溯，撤销之前的动作，避免其他对子树结果造成影响
        prefixSumCount.put(currSum,prefixSumCount.get(currSum)-1);

        return res;
    }
}
