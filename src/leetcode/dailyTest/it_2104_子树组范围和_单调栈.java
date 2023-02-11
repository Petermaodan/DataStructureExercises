package leetcode.dailyTest;

import java.util.Stack;

/**
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * 返回 nums 中 所有 子数组范围的 和 。
 * 子数组是数组中一个连续 非空 的元素序列。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [2]，范围 = 2 - 2 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,2]，范围 = 2 - 1 = 1
 * [2,3]，范围 = 3 - 2 = 1
 * [1,2,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4

 */
public class it_2104_子树组范围和_单调栈 {
    public static void main(String[] args) {
        int[] nums = {4,-2,-3,4,1};
        long res = new it_2104_子树组范围和_单调栈().subArrayRanges(nums);
        System.out.println(res);
    }
    //使用「单调栈」找到某个 nums[i]nums[i] 的左边/右边的最近一个符合某种性质的位置，
    // 从而知道 nums[i]nums[i] 作为区间最值时，左右端点的可选择个数，
    // 再结合乘法原理知道 nums[i]nums[i] 能够作为区间最值的区间个数，从而知道 nums[i]nums[i] 对答案的贡献。
    //
    //值得注意的是，由于 nums[i]nums[i] 存在相同元素，因此上述两边均取等号的做法会导致某些区间被重复计算，
    // 因此我们可以令最近右端点的部分不取等号，确保区间统计不重不漏
    //比如数组｛1，2，3｝。 单元素的不说了。含有两个元素的区间｛1，2｝｛2，3｝，三个元素的｛1，2，3｝。
    // 计算的时候是 2-1 + 3-2 + 3-1。 也可以写成2+3+3-1-2-1，2这个元素在一个区间中做了最大值，在一个区间中做了最小值，
    // 所以最终的结果中有一个+2，一个-2。 其他元素同理


    int n;
    private long subArrayRanges(int[] nums) {
        n=nums.length;
        long[] min=getCnt(nums,true),max=getCnt(nums,false);
        long res=0;
        for (int i = 0; i < n; i++) {
            res+=(max[i]-min[i])*nums[i];
        }
        return res;
    }

    private long[] getCnt(int[] nums, boolean isMin) {
        int[] a=new int[n],b=new int[n];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()&&(isMin?nums[stack.peek()]>=nums[i]:nums[stack.peek()]<=nums[i])){
                stack.pop();
            }
            a[i]=stack.isEmpty()?-1:stack.peek();
            stack.add(i);
        }
        stack.clear();
        for (int i = n-1; i >=0 ; i--) {
            while (!stack.isEmpty()&&(isMin?nums[stack.peek()]>nums[i]:nums[stack.peek()]<nums[i])){
                stack.pop();
            }
            //特别注意
            b[i]=stack.isEmpty()?n:stack.peek();
            stack.add(i);
        }
        long[] ans=new long[n];
        for (int i = 0; i < n; i++) {
            ans[i]=(i-a[i])*1L*(b[i]-i);

        }
        return ans;
    }

    //枚举
    public long subArrayRanges2(int[] nums) {
        int n=nums.length;
        long res=0;
        for (int i = 0; i < n-1; i++) {
            int minValue=nums[i];
            int maxValue=nums[i];
            for (int j = i+1; j <n ; j++) {
                minValue=Math.min(minValue,nums[j]);
                maxValue=Math.max(maxValue,nums[j]);
                res+=maxValue-minValue;
            }
        }

        return res;
    }

//    public long getValue(int[] arr){
//        Arrays.sort(arr);
//        return arr[arr.length-1]-arr[0];
//    }
}
