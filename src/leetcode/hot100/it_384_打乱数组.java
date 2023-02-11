package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *  
 *
 * 示例：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 * 我们可以使用 Knuth 洗牌算法，在 O(n)O(n) 复杂度内等概率返回某个方案。
 *
 * 具体的，我们从前往后尝试填充 [0, n - 1][0,n−1] 该填入什么数时，通过随机当前下标与（剩余的）哪个下标进行值交换来实现。
 *
 * 对于下标 xx 而言，我们从 [x, n - 1][x,n−1] 中随机出一个位置与 xx 进行值交换，当所有位置都进行这样的处理后，我们便得到了一个公平的洗牌方案。
 *
 */

public class it_384_打乱数组 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        Solution solution=new Solution(nums);
        ListUtil.arrayOneNums(solution.shuffle());
        ListUtil.arrayOneNums(solution.reset());
        ListUtil.arrayOneNums(solution.shuffle());
    }

    static class Solution {
        int[] nums;
        Random random=new Random();

        public Solution(int[] nums) {
            this.nums=nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] ans=nums.clone();
            for (int i = 0; i < ans.length; i++) {
                swap(ans,i,i+random.nextInt(ans.length-i));
            }
            return ans;
        }

        private void swap(int[] ans, int i, int j) {
            int temp=ans[i];
            ans[i]=ans[j];
            ans[j]=temp;
        }
    }
}
