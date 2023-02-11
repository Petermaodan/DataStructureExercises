package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取
 我们定义递归函数 dfs(target, combine, idx) 表示当前在 candidates 数组的第 idx 位，还剩 target 要组合，已经组合的列表为 combine。递归的终止条件为 target <= 0 或者 candidates 数组被全部用完。那么在当前的函数中，每次我们可以选择跳过不用第 idx 个数，即执行 dfs(target, combine, idx + 1)。也可以选择使用第 idx 个数，即执行 dfs(target - candidates[idx], combine, idx)，注意到每个数字可以被无限制重复选取，因此搜索的下标仍为 idx。

 更形象化地说，如果我们将整个搜索过程用一个树来表达，即如下图呈现，每次的搜索都会延伸出两个分叉，直到递归的终止条件，这样我们就能不重复且不遗漏地找到所有可行解

 */
public class it_39_组合总和 {
    public static void main(String[] args) {
        int[] candidates ={2,3,6,7};
        int target = 7;
        List<List<Integer>> res=new it_39_组合总和().combinationSum(candidates,target);
        ListUtil.arrayTwo(res);


    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> combine=new ArrayList<>();
        int idx=0;
        dfs(candidates,target,ans,combine,idx);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        //终止条件
        if (idx==candidates.length){
            return;
        }
        if (target==0){
            //ArrayList​(Collection<? extends E> c)->构造一个包含指定集合的元素的列表，按照它们由集合的迭代器返回的顺序。
            //这里一定要new一个新的对象，combine是共用的
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        //每次搜索都会延伸出两个分支，这样可以避免重复
        //跳过选择
        dfs(candidates,target,ans,combine,idx+1);
        //选择当前数
        if (target-candidates[idx]>=0){
            //选择
            combine.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],ans,combine,idx);
            //撤销选择
            combine.remove(combine.size()-1);
        }
    }

}
