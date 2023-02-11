package it_07_二分查找;

/**
 * 先确定有序的一遍是否存在目标值，反之就在无序的数组上
 */
public class it_33_搜索旋转排序数组 {
    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int res=new it_33_搜索旋转排序数组().search(nums,target);
        System.out.println(res);
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (nums[mid]==target){
                return mid;
            }
            //若左边有序，先判断是否在左边，总结就是先判断有序的一边先
            if (nums[mid]>=nums[l]){
                if (nums[mid]>target&&target>=nums[l]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                if (target<=nums[r]&&target>nums[mid]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
