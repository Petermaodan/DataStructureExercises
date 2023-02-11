package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

 */
public class it_95_不同的二叉搜索树2 {
    public static void main(String[] args) {
        List<ITreeNode> list = new it_95_不同的二叉搜索树2().generateTrees(3);
        for (ITreeNode node : list) {
            ArrayList<Integer> list1 = ITreeNode.sequenceTraverse(node);
            ListUtil.arrayOne(list1);
        }

    }

    //方法一；递归求解
    public List<ITreeNode> generateTrees(int n) {
        if (n==0)return new ArrayList<>();
        return gTrees(1,n);
    }

    private List<ITreeNode> gTrees(int start, int end) {
        List<ITreeNode> ans=new ArrayList<>();

        //没有数字，插入null
        if (start>end){
            ans.add(null);
            return ans;
        }
        //start和end相等，将当前数字插入树中
        if (start==end){
            ITreeNode temp=new ITreeNode(start);
            ans.add(temp);
            return ans;
        }

        //常规情况
        for (int i = start; i <=end ; i++) {
            List<ITreeNode> LeftTrees=gTrees(start,i-1);
            List<ITreeNode> RightTrees=gTrees(i+1,end);

            //将左右子树合并
            for (ITreeNode leftTree : LeftTrees) {
                for (ITreeNode rightTree : RightTrees) {
                    ITreeNode root=new ITreeNode(i);
                    root.left=leftTree;
                    root.right=rightTree;

                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
