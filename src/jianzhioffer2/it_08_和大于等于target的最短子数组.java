package jianzhioffer2;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组

 */
public class it_08_和大于等于target的最短子数组 {
    public static void main(String[] args) {
        int[] nums = {10,2,3};
        int res = new it_08_和大于等于target的最短子数组().minSubArrayLen(6, nums);
        System.out.println(res);
    }
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        if (n==1&&target>nums[0]){
            return 0;
        }
        int l=0,r=1;
        int sum=nums[0];
        int minL=Integer.MAX_VALUE;
        while (r<n){
            if (nums[l]>=target){
                return 1;
            }
            sum+=nums[r];
            if (sum>=target){
                minL=Math.min(minL,r-l+1);
                sum-=nums[l];
                sum-=nums[r];
                l++;
            }else {
                r++;
            }
        }
        return minL==Integer.MAX_VALUE?0:minL;
    }
}
