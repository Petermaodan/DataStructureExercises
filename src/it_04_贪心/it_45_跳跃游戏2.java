package it_04_贪心;

import it_06_dp.it_55_跳跃游戏;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class it_45_跳跃游戏2 {
    public static void main(String[] args) {
        int[] nums={3,2,1,1,4};
        int res=new it_45_跳跃游戏2().jump(nums);
        System.out.println(res);
    }
    public int jump(int[] nums) {
        int start=0;
        int end=1;
        int res=0;
        while (end<nums.length){
            int max_jump=0;
            for (int i = start; i < end; i++) {
                max_jump=Math.max(max_jump,i+nums[i]);
            }
            //更新下回起跳的范围
            start=end;
            end=max_jump+1;
            res++;
        }
        return res;

    }
}
