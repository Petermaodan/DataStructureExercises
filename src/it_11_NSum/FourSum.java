package it_11_NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 同样的方法，在fourSum中调用一次threeSum即可
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums={1, 0, -1, 0, -2, 2};
        int target=0;
        List<List<Integer>> result=fourSum(nums,target);
        for (List<Integer> res : result) {
            for (Integer re : res) {
                System.out.print(re+" ");
            }
            System.out.println();
        }
        Arrays.sort(nums);
        List<List<Integer>> result2=new NSum().nSumTarget(nums,4,0,0);
        for (List<Integer> res : result2) {
            for (Integer re : res) {
                System.out.print(re+" ");
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 对 target - nums[i] 计算 threeSum
            List<List<Integer>> tuples=threeSum(nums,i+1,target-nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i<n-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return res;
    }

    private static List<List<Integer>> threeSum(int[] nums,int start, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < n; i++) {
            List<List<Integer>> tuples = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // 左指针改为从 start 开始，其他不变
        int lo = start, hi = n - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
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
