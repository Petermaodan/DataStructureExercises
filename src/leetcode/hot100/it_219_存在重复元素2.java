package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 *
 */
public class it_219_存在重复元素2 {
    public static void main(String[] args) {
        int[] nums = {1};
        boolean res = new it_219_存在重复元素2().containsNearbyDuplicate(nums, 1);
        System.out.println(res);
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set =new HashSet<>();
        int i=0,j=0;
        for (int l = 0; l <= k&&j<nums.length; l++) {
            int temp=nums[j];
            if (set.contains(temp)){
                return true;
            }
            set.add(temp);
            j++;
        }
        while (j<nums.length){
            int temp=nums[j];
            set.remove(nums[i]);
            if (set.contains(temp)){
                return true;
            }
            set.add(temp);
            i++;
            j++;
        }
        return false;
    }
}
