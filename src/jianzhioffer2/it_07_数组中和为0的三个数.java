package jianzhioffer2;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]

 */
public class it_07_数组中和为0的三个数 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new it_07_数组中和为0的三个数().threeSum(nums);
        ListUtil.arrayTwo(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuples=twoSum(nums,i+1,-nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return res;

    }

    private List<List<Integer>> twoSum(int[] nums,int start,int target){
        Arrays.sort(nums);
        int l=start,r=nums.length-1;
        List<List<Integer>> res=new ArrayList<>();
        while (l<r){
            int sum=nums[l]+nums[r];
            int left=nums[l],right=nums[r];
            if (sum<target){
                while (l<r&&nums[l]==left){
                    l++;
                }
            }else if (sum>target){
                while (l<r&&nums[r]==right){
                    r--;
                }
            }else {
                List<Integer> list=new ArrayList<>();
                list.add(nums[l]);
                list.add(nums[r]);
                res.add(list);
                while (l<r&&nums[l]==left){
                    l++;
                }
                while (l<r&&nums[r]==right){
                    r--;
                }
            }
        }
        return res;
    }
}
