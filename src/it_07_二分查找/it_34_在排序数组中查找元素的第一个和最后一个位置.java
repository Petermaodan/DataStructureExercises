package it_07_二分查找;

import BaseUtil.ListUtil;

public class it_34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums={1};
        int[] res=new it_34_在排序数组中查找元素的第一个和最后一个位置().searchRange(nums,1);
        ListUtil.arrayOneNums(res);
    }

    public int[] searchRange(int[] nums, int target) {

        int leftIdx=binarySearch(nums,target,true);//找左边界
        int rightIdx=binarySearch(nums,target,false)-1;
        if (leftIdx<=rightIdx&&rightIdx<nums.length&&nums[leftIdx]==target&&nums[rightIdx]==target){
            return new int[]{leftIdx,rightIdx};
        }
        return new int[]{-1,-1};

    }

    int binarySearch(int[] nums, int target, boolean lower) {
        int left=0,right=nums.length-1;
        int ans=nums.length;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]>target||(lower&&nums[mid]>=target)){
                right=mid-1;
                ans=mid;
            }else {
                left=mid+1;
            }
        }
        return ans;
    }
}
