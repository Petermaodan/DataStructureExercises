package jianzhioffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 直接用二分法找到左边界
 */
public class it_53_1_在排序数组中查找数字1 {
    public static void main(String[] args) {
        int[] nums={1};
        int res = new it_53_1_在排序数组中查找数字1().search(nums, 1);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int res=0;
        while (i<j){
            int mid=i+(j-i)/2;
            if (nums[mid]>=target){
                j=mid;
            }else if (nums[mid]<target){
                i=mid+1;
            }
        }
        while (i<nums.length&&nums[i++]==target){
            res++;
        }
        return res;
    }

}
