package leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 *
 */
public class it_594_最长和谐子序列 {
    public static void main(String[] args) {
        int[] nums={1,3,2,2,5,2,3,7};
        int res = new it_594_最长和谐子序列().findLHS(nums);
        System.out.println(res);
    }

    private int findLHS(int[] nums) {
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int num : nums) {
            if (map.containsKey(num-1)){
                ans=Math.max(ans,map.get(num)+map.get(num-1));
            }
        }
        return ans;
    }

    public int findLHS2(int[] nums) {
        Arrays.sort(nums);
        int left=0,right=0;
        int ans=0;
        while (right<nums.length){
            while (left<right&&nums[right]-nums[left]>1)left++;
            if (nums[right]-nums[left]==1){
                ans=Math.max(ans,right-left+1);
            }
            right++;
        }
        return ans;
    }
}
