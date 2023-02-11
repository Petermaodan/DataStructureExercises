package it_05_回溯;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class it_47_全排列2 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> res = new it_47_全排列2().permuteUnique(nums);
        ListUtil.arrayTwo(res);
    }

    List<List<Integer>> res=new ArrayList<>();
    List<Integer> track=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length==0){
            res.add(track);
            return res;
        }
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        backtrack(nums,0,used);
        return res;
    }

    private void backtrack(int[] nums, int idx,boolean[] used) {
        if (idx==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]||(i>0&&nums[i]==nums[i-1]&&!used[i-1])){
                continue;
            }
            used[i]=true;
            track.add(nums[i]);
            backtrack(nums,idx+1,used);
            track.remove(track.size()-1);
            used[i]=false;
        }
    }
}
