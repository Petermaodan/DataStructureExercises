package leetcode.dailyTest;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 *
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class it_462_最少移动次数使数组元素相等2 {
    public static void main(String[] args) {
        int[] nums = {1,10,2,9};
        int res = new it_462_最少移动次数使数组元素相等2().minMoves2(nums);
        System.out.println(res);
    }
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int N=nums.length;
        int mid=nums[N/2];
        int res=0;
        for (int num : nums) {
            res+=Math.abs(num-mid);
        }
        return res;
    }
}
