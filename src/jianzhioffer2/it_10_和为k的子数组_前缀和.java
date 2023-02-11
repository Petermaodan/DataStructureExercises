package jianzhioffer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 *  
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * 示例 2 :
 *
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2

 */
public class it_10_和为k的子数组_前缀和 {
    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 0;
        int res = new it_10_和为k的子数组_前缀和().subarraySum(nums, k);
        System.out.println(res);
    }

    private int subarraySum(int[] nums, int k) {
        int preSum=0;
        Map<Integer,Integer> map=new HashMap<>();
        //初始值
        map.put(0,1);
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            preSum+=nums[i];
            res+=map.getOrDefault(preSum-k,0);
            //统计前缀出现的次数
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return res;
    }

    //无法处理负数
    public int subarraySum2(int[] nums, int k) {
        int l=0,r=0;
        int res=0;
        int sum=0;
        while (r<nums.length){
            sum+=nums[r];
            while (l<=r&&sum>k){
                sum-=nums[l++];
            }
            if (sum==k){
                res++;
            }
            r++;
        }
        return res;
    }
}
