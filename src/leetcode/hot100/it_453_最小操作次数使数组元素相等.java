package leetcode.hot100;

/**
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * 思路，取巧
 * 对n-1个数加一等价于对一个数-1，这个非常关键
 */
public class it_453_最小操作次数使数组元素相等 {
    public static void main(String[] args) {
        int[] nums={1,1,3};
        int res = new it_453_最小操作次数使数组元素相等().minMoves(nums);
        System.out.println(res);
    }
    public int minMoves(int[] nums) {
        int minValue=Integer.MAX_VALUE;
        for (int num : nums) {
            minValue=Math.min(minValue,num);
        }
        int res=0;
        for (int num : nums) {
            res+=Math.abs(minValue-num);
        }
        return res;
    }
}
