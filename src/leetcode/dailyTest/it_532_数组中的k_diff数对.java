package leetcode.dailyTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 *
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * 注意，|val| 表示 val 的绝对值。

 */
public class it_532_数组中的k_diff数对 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        int res = new it_532_数组中的k_diff数对().findPairs(nums, k);
        System.out.println(res);
    }
    public int findPairs(int[] nums, int k) {
        int n=nums.length;
        if (n==1){
            return 0;
        }
        Arrays.sort(nums);
        Set<String> res=new HashSet<>();
        out:
        for (int i = 0; i < n-1; i++) {
            in:
            for (int j = i+1; j < n; j++) {
                if (nums[j]-nums[i]==k){
                    res.add(nums[j]+"-"+nums[i]);
                }else if (nums[j]-nums[i]>k){
                    break in;
                }
            }
        }
        return res.size();
    }
}
