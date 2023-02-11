package it_05_回溯;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 */
public class it_40_数组总和2 {
    public static void main(String[] args) {
        int[] nums={10,1,2,7,6,1,5};
        List<List<Integer>> res = new it_40_数组总和2().combinationSum2(nums, 8);
        ListUtil.arrayTwo(res);

    }



    List<List<Integer>> res=new ArrayList<>();
    List<Integer> track=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length==0){
            res.add(track);
            return res;
        }
        Arrays.sort(candidates);
        boolean[] used=new boolean[candidates.length];
        backtrack(candidates,target,used,0,0);
        return res;
    }

    private void backtrack(int[] candidates, int target, boolean[] used, int sum, int idx) {
        if (sum==target){
            res.add(new ArrayList<>(track));
            //跳出递归
            return;
        }
        for (int i =idx; i < candidates.length; i++) {
            //同一树层相同的要排除，通过!used[i-1]判断是否从是同一树层
            if (i>idx&&candidates[i-1]==candidates[i]&&!used[i-1]){
                continue;
            }
            int temp=sum+candidates[i];
            if (temp<=target){
                used[i]=true;
                track.add(candidates[i]);
                backtrack(candidates,target, used, temp,i+1);
                track.remove(track.size()-1);
                used[i]=false;
            }else {
                break;
            }
        }
    }
}
