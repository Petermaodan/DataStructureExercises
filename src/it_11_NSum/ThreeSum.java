package it_11_NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2,0,0,2,2};
        int target = 0;
        List<List<Integer>> result = threeSum(nums, target);
        for (List<Integer> res : result) {
            for (Integer re : res) {
                System.out.print(re+" ");
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);// 数组得排个序
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 穷举 threeSum 的第一个数
        for (int i = 0; i < n; i++) {
            // 对 target - nums[i] 计算 twoSum
            List<List<Integer>> tuples = twoSum(nums, i + 1, target - nums[i]);
            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
    /* 计算数组 nums 中所有和为 target 的三元组 */
    private static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);// 数组得排个序
        // 左指针改为从 start 开始，其他不变
        int lo = start, hi = n - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if  (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res;
    }
}
