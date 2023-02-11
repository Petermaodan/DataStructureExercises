package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 * 回溯
 */
public class it_46_全排列 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List lists=new it_46_全排列().permute(nums);
        ListUtil.arrayTwo(lists);

    }

    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track=new LinkedList<>();
        backtrack(track,nums);
        return res;
    }

    public void backtrack(LinkedList<Integer> track,int[] nums){
        if(track.size()==nums.length){
            //创建一个新的对象->track是重复用的
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(track.contains(nums[i])){
                //关键点，若存在重复，就跳过
                continue;
            }
            //选择
            track.add(nums[i]);
            backtrack(track,nums);
            //撤销选择
            track.removeLast();
        }
    }
}
