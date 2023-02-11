package jianzhioffer;

import java.util.HashMap;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class it_57_和为s的两个数字 {

    public int[] twoSum2(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while (i<j){
            int sum=nums[i]+nums[j];
            if (sum<target){
                i++;
            }else if (sum>target){
                j--;
            }else {
                return new int[]{nums[i],nums[j]};
            }
        }
        return new int[]{-1,-1};



    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> index=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other=target-nums[i];
            if (index.containsKey(other)&&index.get(other)!=i){
                return new int[]{other,nums[i]};
            }
        }
        return new int[]{-1,-1};
    }
}
