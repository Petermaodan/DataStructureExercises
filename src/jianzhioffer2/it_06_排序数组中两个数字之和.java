package jianzhioffer2;

import BaseUtil.ListUtil;

/**
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 *
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 *
 */
public class it_06_排序数组中两个数字之和 {
    public static void main(String[] args) {
        int[] numbers = {1,2,4,6,10};
        int target = 8;
        int[] ints = new it_06_排序数组中两个数字之和().twoSum(numbers, target);
        ListUtil.arrayOneNums(ints);
    }
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while (i<j){
            int temp=numbers[i]+numbers[j];
            if (target==temp){
                return new int[]{i,j};
            }else if (temp>target){
                j--;
            }else {
                i++;
            }
        }
        return new int[]{-1,-1};
    }
}
