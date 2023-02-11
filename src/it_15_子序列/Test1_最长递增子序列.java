package it_15_子序列;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度
 * 层层递进，理解动态规划
 * 但是常规动态规划时间复杂度为O(n^2),如何做到O(nlog2n)呢？
 */
public class Test1_最长递增子序列 {
    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        int[] nums2={7,7,7,7,7,7,7,7};
        int result=new Test1_最长递增子序列().lengthOfLIS2(nums2);
        System.out.println(result);

    }

    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        //base case: dp[i]的初始值为1
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            //和i之前的进行比较，层层递进，因为所需的状态必须已经计算出来
            for (int j = 0; j < i; j++) {
                //若存在递增
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        //遍历出最大值
        int res=0;
        for (int i = 0; i < dp.length; i++) {
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    /**
     * 优化--采用二分法和堆放扑克牌的方法，堆数即为结果
     */
    public int lengthOfLIS2(int[] nums){
        //堆顶
        int[] top=new int[nums.length];
        //初始堆数为0
        int piles=0;
        /*************************/
        //选牌，放堆,采用二分法寻找左边界，遇到nums[mid]==target时不要马上收缩，right=mid-1
        //为何选择左边界？-->当有多个选择时，往左放，才能凑出递增子序列
        for (int i = 0; i < nums.length; i++) {
            int poker=nums[i];
            int left=0,right=piles-1;
            while (left<=right){
                int mid=left+(right-left)/2;
                if (top[mid]<poker){
                    left=mid+1;
                }else if (top[mid]>poker){
                    right=mid-1;
                }else {
                    right=mid-1;
                }
            }
            //没有找到合适的牌
            if (left==piles)piles++;
            //把这张牌放到牌堆顶,因为piles是从0开始的，left==1实际等于有两堆，所以这里直接top[left]=poker;
            top[left]=poker;
        }
        return piles;
    }
}
