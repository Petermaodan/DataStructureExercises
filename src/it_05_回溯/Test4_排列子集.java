package it_05_回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 问题很简单，输入一个不包含重复数字的数组，要求算法输出这些数字的所有子集。
 */
public class Test4_排列子集 {
    public static void main(String[] args) {
        int[] nums={1,2,3};

        List<List<Integer>> res=new Test4_排列子集().subsets(nums);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer);
            }
            System.out.println();
        }


    }

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> track=new ArrayList<>();
        backtrack(res,nums,0,track);
        return res;

    }

    private void backtrack(List<List<Integer>> res,int[] nums, int start,ArrayList<Integer> track) {
        res.add(new ArrayList<>(track));
        if (start>=nums.length)return;
        for (int i = start; i <nums.length ; i++) {
            //做选择
            track.add(nums[i]);
            //回溯
            backtrack(res,nums,i+1,track);
            //撤销选择
            track.remove(track.size()-1);
        }
    }
}
