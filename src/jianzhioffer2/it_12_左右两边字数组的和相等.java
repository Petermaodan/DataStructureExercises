package jianzhioffer2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。
 * 这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。

 */
public class it_12_左右两边字数组的和相等 {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int res = new it_12_左右两边字数组的和相等().pivotIndex(nums);
        System.out.println(res);
    }

    public int pivotIndex(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        int preSum=0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum==sum-nums[i]){
                return i;
            }
            preSum+=nums[i];
            sum-=nums[i];
        }
        return -1;
    }
}
