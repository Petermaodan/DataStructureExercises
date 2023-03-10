package jianzhioffer2;

/**
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。

 */
public class it_09_乘积小于K的子数组 {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        int res = new it_09_乘积小于K的子数组().numSubarrayProductLessThanK(nums, k);
        System.out.println(res);
    }

    //滑动窗口
    private int numSubarrayProductLessThanK(int[] nums, int k) {
        int l=0,r=0;
        int subarray=1;
        int res=0;
        while (r<nums.length){
            subarray*=nums[r];
            while (l<=r&&subarray>=k){
                subarray/=nums[l++];
            }
            if (l<=r){
                res+=r-l+1;
            }
            r++;
        }
        return res;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int count=0;

        int n=nums.length;
        for (int i = 0; i < n; i++) {
            int subarray=1;
            for (int j = i; j < n; j++) {
                subarray*=nums[j];
                if (subarray<k){
                    count++;
                }else {
                    break;
                }
            }
        }
        return count;
    }
}
