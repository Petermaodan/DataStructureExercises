package leetcode.hot100;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 整体思路和之前的三数之和存在不小的差异
 * 使用双指针类似于穷举所有可能
 */
public class it_16_最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        int res = new it_16_最接近的三数之和().threeSumClosest(nums, 1);
        System.out.println(res);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //初始化
        int ans=nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start=i+1,end=nums.length-1;
            while (start<end){
                int sum=nums[start]+nums[end]+nums[i];
                //判断大小
                if (Math.abs(target-sum)<Math.abs(target-ans)){
                    ans=sum;
                }
                if (sum<target){
                    start++;
                }else if (sum>target){
                    end--;
                }else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
