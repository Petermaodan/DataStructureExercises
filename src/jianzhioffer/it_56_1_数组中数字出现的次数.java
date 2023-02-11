package jianzhioffer;

import BaseUtil.ListUtil;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 */
public class it_56_1_数组中数字出现的次数 {
    public static void main(String[] args) {
        int[] nums={1,2,5,2};
        int[] res=new it_56_1_数组中数字出现的次数().singleNumbers(nums);
        ListUtil.arrayOneNums(res);
    }

    public int[] singleNumbers(int[] nums) {
        int x=0,y=0,m=1,n=0;
        for (int num : nums) {
            n^=num;
        }
        while ((n&m)==0){
            m<<=1;
        }
        for (int num : nums) {
            if ((num&m)!=0){
                x^=num;
            }else {
                y^=num;
            }
        }
        return new int[]{x,y};
    }
}
