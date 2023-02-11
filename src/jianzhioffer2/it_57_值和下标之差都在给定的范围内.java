package jianzhioffer2;

import java.util.Set;
import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 */
public class it_57_值和下标之差都在给定的范围内 {
    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        int  k = 2, t = 3;
        boolean res = new it_57_值和下标之差都在给定的范围内().containsNearbyAlmostDuplicate2(nums, k, t);
        System.out.println(res);
    }

    private boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {

        //只需要判断滑动窗口中所有大于等于 x−t 的元素中的最小元素是否小于等于 x+t 即可,因为这就是绝对值的范围
        //使用treeset保证有序并且二分查找
        TreeSet<Long> set=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling=set.ceiling((long)nums[i]-(long)t);
            if (ceiling!=null&&ceiling<=(long)nums[i]+(long)t){
                return true;
            }
            set.add((long)nums[i]);
            if (i>=k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i]-nums[j])<=t&&Math.abs(i-j)<=k){
                    return true;
                }
            }
        }
        return false;
    }
}
