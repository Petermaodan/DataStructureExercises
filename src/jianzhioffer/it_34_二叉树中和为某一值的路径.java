package jianzhioffer;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 因为是树，所以肯定会用到数的遍历
 * 前序遍历＋回溯
 */
public class it_34_二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        Integer[] nums={5,4,8,11,null,13,4,7,2,null,null,null,null,5,1};
        ITreeNode root = ITreeNode.makeTree(nums);
        List<List<Integer>> res = new it_34_二叉树中和为某一值的路径().pathSum(root, 22);
        ListUtil.arrayTwo(res);
    }


    List<List<Integer>> res=new ArrayList<>();
    List<Integer> track=new ArrayList<>();
    public List<List<Integer>> pathSum(ITreeNode root, int target) {
        backtrack(root,target);
        return res;

    }

    private void backtrack(ITreeNode root, int target) {
        //跳出递归
        if (root==null)return;
        //前序遍历
        track.add(root.val);
        int temp=target-root.val;
        if (temp==0&&root.right==null&&root.left==null){
            res.add(new ArrayList<>(track));
        }
        //遍历左右子树
        backtrack(root.left,temp);
        backtrack(root.right,temp);
        //回溯
        track.remove(track.size()-1);
    }
}
