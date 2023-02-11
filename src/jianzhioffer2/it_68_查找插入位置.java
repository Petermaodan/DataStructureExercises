package jianzhioffer2;

/**
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2

 */
public class it_68_查找插入位置 {
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=(l+r)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return l==nums.length-1&&nums[l]<target?l+1:l;
    }
}
