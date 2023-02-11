package leetcode.hot100;

import java.util.Stack;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 */
public class it_581_最短无序连续数组 {
    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(new it_581_最短无序连续数组().findUnsortedSubarray(nums));
    }



    //栈的加入代替j循环
    //为了找到 nums[j] 的正确位置，我们不断将栈顶元素弹出，
    // 直到栈顶元素比 nums[j] 小，我们假设栈顶元素对应的下标为 k ，那么我们知道 nums[j] 的正确位置下标应该是 k + 1 。

    public int findUnsortedSubarray(int[] nums) {
        int l=nums.length,r=0;
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                l=Math.min(l,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length-1; i >=0 ; i--) {
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                r=Math.max(r,stack.pop());
            }
            stack.push(i);
        }
        return r-1<0?0:r-l+1;
    }

    //暴力解法
    //在所有的 nums[i] 中，我们找到最左边不在正确位置的 nums[i] ，这标记了最短无序子数组的左边界（l）。
    // 类似的，我们找到最右边不在正确位置的边界 nums[j] ，它标记了最短无序子数组的右边界 (r) 。
    public int findUnsortedSubarray2(int[] nums) {
        int l=nums.length,r=0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    r=Math.max(r,j);
                    l=Math.min(l,i);
                }
            }
        }
        return r-1<0?0:r-l+1;
    }
}
