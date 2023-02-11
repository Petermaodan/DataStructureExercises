package it_05_回溯;

/**
 * 回溯算法，求解目标和，需要一个备忘录记录重复结果
 */

import java.util.HashMap;

public class Test3_优化 {
    public static void main(String[] args) {
        Test3_优化 test3 = new Test3_优化();

        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(test3.findTargetSumWays(nums, target));
    }

    HashMap<String,Integer> hashMap=new HashMap<>();
    private int findTargetSumWays(int[] nums, int target) {
        if (nums.length==0){
            return 0;
        }
        return dp(nums,0,target);

    }

    private int dp(int[] nums, int i, int rest) {
        if (nums.length==i){
            if (rest==0){
                return 1;
            }return 0;
        }
        String key=i+","+rest;
        if (hashMap.containsKey(key)){
            return hashMap.get(key);
        }


        int result=dp(nums,i+1,rest-nums[i])+dp(nums,i+1,rest+nums[i]);
        hashMap.put(key,result);
        return result;
    }

}
