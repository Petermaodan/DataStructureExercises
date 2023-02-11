package it_07_二分查找;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 */
public class it_162_寻找峰 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3,2,5,6};
        int res = findPeakElement2(nums);
        System.out.println(res);
    }


    public static int findPeakElement2(int[] nums){
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=(l+r)/2;
            if (nums[mid]>nums[mid+1]){
                r=mid;//可能mid就是峰值，不能跳过,如果是求低估的话，可能正好反过来
            }else {
                l=mid+1;
            }
        }
        return l;
    }
    //笨比方法
    public static int findPeakElement(int[] nums) {
        if (nums.length < 3) {
            int max = Integer.MIN_VALUE;
            int max_index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    max_index = i;
                }
            }
            return max_index;
        } else {
            int temp = Integer.MIN_VALUE;
            for (int i = 0; i <= nums.length - 1; i++) {
                if (nums[i] > temp) {
                    temp = nums[i];
                }
                if (i == 0) {
                    if (nums[i] > nums[1]) {
                        return i;
                    }
                    continue;
                } else if (i == nums.length - 1) {
                    if (nums[i] > nums[i - 1]) {
                        return nums.length - 1;
                    }
                } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }

        return -1;
    }
}
