package leetcode.hot100;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 */
public class it_1005_K次取反后最大化的数组和 {
    public static void main(String[] args) {
        int[] nums={2,-3,-1,5,-4};
        int k=2;
        int res = new it_1005_K次取反后最大化的数组和().largestSumAfterKNegations(nums, k);
        System.out.println(res);

    }

    private int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k; i++) {
            int temp=queue.poll();
            queue.add(-temp);
        }
        int res=0;
        for (Integer integer : queue) {
            res+=integer;
        }
        return res;

    }


    //复杂度太高
    public int largestSumAfterKNegations2(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            int temp=nums[0];
            nums[0]=-temp;
            Arrays.sort(nums);
        }
        int res=0;
        for (int num : nums) {
            res+=num;
        }
        return res;
    }
}
