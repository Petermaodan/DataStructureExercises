package leetcode.dailyTest;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]

 */
public class it_442_数组中的重复数据_原地哈希 {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> list = new it_442_数组中的重复数据_原地哈希().findDuplicates(nums);
        ListUtil.arrayOne(list);
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp=nums[i];
            if (temp<0||temp-1==i){
                continue;
            }
            if (nums[temp-1]==temp){
                res.add(temp);
                nums[i]=-1;
            }else {
                //交换到正确的位置上
                int c = nums[temp - 1];
                nums[temp - 1] = temp;
                //保证每个数据都被遍历过
                nums[i--] = c;
            }
        }
        return res;
    }
}
