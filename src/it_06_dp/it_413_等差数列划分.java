package it_06_dp;

/**
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 */
public class it_413_等差数列划分 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,6,6,6,6};
        int res=new it_413_等差数列划分().numberOfArithmeticSlices(nums);
        System.out.println(res);
    }
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length<3)return 0;
        int i=0,j=1;
        int temp=0;
        int res=0;
        while (j<nums.length){
            int a=nums[j]-nums[i];
            while (j<nums.length-1&&nums[j+1]-nums[j]==a){
                temp++;
                j++;
            }
            res+=(temp+1)*temp/2;
            temp=0;
            i=j;
            j++;
        }
        return res;
    }
}
