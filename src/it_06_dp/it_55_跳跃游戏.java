package it_06_dp;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 贪心，记录能够跳到最远的地方即可

 */
public class it_55_跳跃游戏 {
    public static void main(String[] args) {
        int[] nums={3,2,1,1,4};
        boolean res=new it_55_跳跃游戏().canJump(nums);
        System.out.println(res);
    }

    public boolean canJump(int[] nums) {
        //能够跳到最远的下标
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (i>k)return false;//跳不到这个下标
            k=Math.max(k,i+nums[i]);
        }
        return true;

    }

}
