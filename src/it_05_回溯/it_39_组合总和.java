package it_05_回溯;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。

 * 示例 1：
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]

 同样使用回溯的框架
 */
public class it_39_组合总和 {
    public static void main(String[] args) {
        int[] nums={2,3,6,7};
        List<List<Integer>> res = new it_39_组合总和().combinationSum(nums, 7);
        ListUtil.arrayTwo(res);

    }



    List<List<Integer>> res=new ArrayList<>();
    List<Integer> track=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length==0){
            res.add(track);
            return res;
        }
        //排序，减少回溯
        Arrays.sort(candidates);
        backtrack(candidates,target,0,0);
        return res;

    }

    private void backtrack(int[] candidates, int target, int sum, int idx) {
        //跳出递归
        if (sum==target){
            res.add(new ArrayList<>(track));
            return;
        }

        //因为可以重复取，所以从idx开始
        for (int i = idx; i <candidates.length ; i++) {
            int temp=sum+candidates[i];
            if (temp<=target){

                track.add(candidates[i]);
                //因为可以重复取，所以idx可以不用自增
                backtrack(candidates,target,temp,i);
                track.remove(track.size()-1);
            }else {
                break;
            }

        }
    }
}
