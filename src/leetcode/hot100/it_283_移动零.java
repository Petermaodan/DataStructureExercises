package leetcode.hot100;

import BaseUtil.ListUtil;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *双指针轮流向右解决，左指针的左边都已经排好，左指针的右边一直到右指针都为0,始终是左指针交换
 */
public class it_283_移动零 {

    public static void main(String[] args) {
        int [] nums={0,1,0,3,12};
        new it_283_移动零().moveZeroes(nums);
        ListUtil.arrayOneNums(nums);
    }
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int left=0,right=0;
        while (right<n){
            if (nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
