package leetcode.hot100;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 *
 * 思路，和最长递增子序列类似的思路
 */
public class it_334_递增的三元子序列 {
    public static void main(String[] args) {
        int[] nums={2,1,5,0,4,6};
        boolean res = new it_334_递增的三元子序列().increasingTriplet2(nums);
        System.out.println(res);
    }

    //思路，扑克牌的堆放解决，使用二分法解决
    private boolean increasingTriplet2(int[] nums) {
        int n=nums.length;
        int[] top=new int[n];
        int piles=0;
        for (int i = 0; i < n; i++) {
            //从第0堆开始，所以right-1；
            int left=0,right=piles-1;
            int poker=nums[i];
            while (left<=right){
                int mid=(left+right)/2;
                if (top[mid]<poker){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
            //若没有找到对应的堆，则多一堆
            if (left==piles){
                piles++;
            }
            if (piles>=3)return true;
            //把这张牌放到牌堆顶,因为piles是从0开始的，left==1实际等于有两堆，所以这里直接top[left]=poker;
            top[left]=poker;
        }
        return false;
    }

    //超时
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if (dp[i]>=3){
                return true;
            }
        }
        return false;
    }
}
