package leetcode.hot100;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 * <p>
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 * 示例 1：
 * <p>
 * 输入：nums = [7,1,5,4]
 * 输出：4
 * 解释：
 * 最大差值出现在 i = 1 且 j = 2 时，nums[j] - nums[i] = 5 - 1 = 4 。
 * 注意，尽管 i = 1 且 j = 0 时 ，nums[j] - nums[i] = 7 - 1 = 6 > 4 ，但 i > j 不满足题面要求，所以 6 不是有效的答案。
 */
public class it_2016_增量元素之间的最大差值 {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 4};
        int res = new it_2016_增量元素之间的最大差值().maximumDifference2(nums);
        System.out.println(res);
    }

    //将复杂度降低到O（n）
    private int maximumDifference2(int[] nums) {
        int res=-1,min=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>min){
                res=Math.max(res,nums[i]-min);
            }
            min=Math.min(min,nums[i]);
        }
        return res;
    }

    public int maximumDifference(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[j] - nums[i];
                if (temp > 0) {
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }
}
