package jianzhioffer2;

import BaseUtil.ListUtil;
import it_05_回溯.it_40_数组总和2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 思路，采用回溯方法解决
 */
public class it_82_含有重复元素集合的组合 {
    public static void main(String[] args) {
        int[] nums={10,1,2,7,6,1,5};
        List<List<Integer>> res = new it_82_含有重复元素集合的组合().combinationSum2(nums, 8);
        ListUtil.arrayTwo(res);
    }
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> track=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates==null){
            return res;
        }
        Arrays.sort(candidates);
        boolean[] used=new boolean[candidates.length];
        dfs(candidates,target,used,0,0);
        return res;
    }

    private void dfs(int[] candidates, int target, boolean[] used, int idx, int sum) {
        if (sum==target){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            //同一树层相同的要排除，通过!used[i-1]判断是否从是同一树层
            //used[i-1]==true则表面是在同一树根上，而不是同一树层
            if (i>idx&&candidates[i-1]==candidates[i]&&!used[i-1]){
                continue;
            }
            int temp=sum+candidates[i];
            if (sum<=target){
                used[i]=true;
                track.add(candidates[i]);
                dfs(candidates, target, used, i+1, temp);
                track.remove(track.size()-1);
                used[i]=false;
            }else {
                break;
            }
        }
    }
}
