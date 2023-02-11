package leetcode.hot100;

/**
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 *
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * 示例 1：
 *
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 */
public class it_747_至少是其他数字两倍的最大数 {
    public static void main(String[] args) {
        int[] nums={3,6,1,0};
        int res = new it_747_至少是其他数字两倍的最大数().dominantIndex(nums);
        System.out.println(res);
    }
    public int dominantIndex(int[] nums) {
        int[] firstVal={-1,-1};
        int secondVal=-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=firstVal[0]){
                secondVal=firstVal[0];
                firstVal[0]=nums[i];
                firstVal[1]=i;
            }else if (nums[i]>=secondVal){
                secondVal=nums[i];
            }
        }
        return firstVal[0]>=secondVal*2?firstVal[1]:-1;
    }
}
