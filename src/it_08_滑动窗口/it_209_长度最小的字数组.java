package it_08_滑动窗口;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。

 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 双指针滑动窗口

 */
public class it_209_长度最小的字数组 {
    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int res=new it_209_长度最小的字数组().minSubArrayLen(7,nums);
        System.out.println(res);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int left=0,right=0;
        int res=Integer.MAX_VALUE;
        int temp=0;
        while (right<n){
            temp+=nums[right];
            right++;
            while (temp>=target){
                res=Math.min(res,right-left);
                temp-=nums[left++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;

    }
}
