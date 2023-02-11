package leetcode.hot100;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 */
public class it_414_第三大的数 {
    public static void main(String[] args) {
        int[] nums={2,3};
        int res = new it_414_第三大的数().thirdMax(nums);
        System.out.println(res);
    }
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        Queue<Integer> queue=new PriorityQueue<>();
        int max=nums[nums.length-1];
        for (int i = nums.length-1; i >=0 ; i--) {
            if (queue.size()==3)break;
            if (!queue.isEmpty()&&queue.peek()==nums[i]){
                continue;
            }else {
                queue.add(nums[i]);
            }
        }
        return queue.size()==3?queue.peek():max;

    }
}
