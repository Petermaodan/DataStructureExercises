package leetcode.hot100;

import java.util.Arrays;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 */
public class it_268_丢失的数字 {
    public static void main(String[] args) {
        int[] nums={9,6,4,2,3,5,7,0,1};
        int res = new it_268_丢失的数字().missingNumber(nums);
        System.out.println(res);
    }

    //优化，使用异或处理
    private int missingNumber(int[] nums) {
        int res=nums.length;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
            res^=i;
        }
        return res;
    }




    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i)return i;
        }
        return nums.length;
    }
}
