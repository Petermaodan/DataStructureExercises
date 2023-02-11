package jianzhioffer2;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *

 */
public class it_83_没有重复元素的全排列 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> permute = new it_83_没有重复元素的全排列().permute(nums);
        ListUtil.arrayTwo(permute);
    }
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> track=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums);
            track.remove(track.size()-1);
        }
    }
}
