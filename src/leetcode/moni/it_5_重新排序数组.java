package leetcode.moni;

import BaseUtil.ListUtil;

/**
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 *
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组
 */

public class it_5_重新排序数组 {
    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int n = 3;
        ListUtil.arrayOneNums(new it_5_重新排序数组().shuffle(nums,n));

    }

    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[2*n];
        int s=n-1;
        for (int i = 0; i < 2*n; i+=2) {
            ans[i]=nums[i/2];
            s++;
            ans[i+1]=nums[s];
        }
        return ans;
    }
}
