package jianzhioffer2;

/**
 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 */
public class it_70_排序数组中只出现一次的数字 {
    public int singleNonDuplicate(int[] nums) {
        int ans=nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans^=nums[i];
        }
        return ans;
    }
}
