package leetcode.dailyTest;

/**
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 *
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 *
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 *
 */
public class it_1413_逐步求和得到正数的最小值 {
    public static void main(String[] args) {
        int[] nums = {-3,2,-3,4,2};
        int res = new it_1413_逐步求和得到正数的最小值().minStartValue(nums);
        System.out.println(res);
    }
    public int minStartValue(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE;
        for (int i = 0, j = 1; i < n; i++) {
            j = j + nums[i];
            min = Math.min(min, j);
        }
        return min < 1 ? 2 - min : 1;
    }
}
