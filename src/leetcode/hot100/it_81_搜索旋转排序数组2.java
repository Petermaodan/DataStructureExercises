package leetcode.hot100;

import sun.rmi.runtime.Log;

/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。

 */
public class it_81_搜索旋转排序数组2 {
    public static void main(String[] args) {
        int[] nums={1,3};
        int target=3;
        boolean res = new it_81_搜索旋转排序数组2().search(nums, target);
        System.out.println(res);

    }
    public boolean search(int[] nums, int target) {
        //base case
        if (nums.length==0)return false;
        if (nums.length==1)return nums[0]==target?true:false;

        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (nums[mid]==target)return true;

            //第一种情况，存在重复的项
            //此时 l++ 即可。相当于去掉一个重复的干扰项
            if (nums[l]==nums[mid]){
                l++;
                continue;
            }

            //总结起来就是总有一边是有序的
            //左半边有序
            if (nums[mid]>nums[l]){
                if (nums[l]<=target&&target<nums[mid]){
                    r=mid-1;
                    System.out.println(r);
                }else {
                    l=mid+1;
                    System.out.println(l);
                }
            }
            //右半边有序
            else {
                if (target>nums[mid]&&target<=nums[r]){
                    l=mid+1;
                    System.out.println(l);
                }else {
                    r=mid-1;
                    System.out.println(r);
                }
            }
        }
        return false;
    }
}
