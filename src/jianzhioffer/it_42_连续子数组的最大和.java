package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class it_42_连续子数组的最大和 {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int res=new it_42_连续子数组的最大和().maxSubArray(nums);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        //base case:
        int res=nums[0];
        for (int i = 1; i < nums.length ; i++) {
            nums[i]+=Math.max(nums[i-1],0);
            res=Math.max(res,nums[i]);
        }
        return res;

    }
}
