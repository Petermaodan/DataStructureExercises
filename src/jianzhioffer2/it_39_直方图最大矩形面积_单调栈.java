package jianzhioffer2;

import java.util.Stack;

/**
 * 给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *

 *
 * 上述写法中，我们需要再嵌套一层 while 循环来向左找到第一个比柱体 i 高度小的柱体，这个过程是 O(N) 的；
 * 那么我们可以 O(1) 的获取柱体 i 左边第一个比它小的柱体吗？答案就是单调增栈，因为对于栈中的柱体来说，栈中下一个柱体就是左边第一个高度小于自身的柱体。
 * 因此做法就很简单了，我们遍历每个柱体，若当前的柱体高度大于等于栈顶柱体的高度，就直接将当前柱体入栈，否则若当前的柱体高度小于栈顶柱体的高度，说明当前栈顶柱体找到了右边的第一个小于自身的柱体，那么就可以将栈顶柱体出栈来计算以其为高的矩形的面积了。
 */
public class it_39_直方图最大矩形面积_单调栈 {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int res = new it_39_直方图最大矩形面积_单调栈().largestRectangleArea(heights);
        System.out.println(res);
    }

    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        //考虑边界条件
        int[] newHeights=new int[n+2];
        System.arraycopy(heights,0,newHeights,1,n);
        Stack<Integer> stack=new Stack<>();
        int res=0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty()&&(newHeights[i]<newHeights[stack.peek()])){
                int h=newHeights[stack.pop()];
                res=Math.max(res,(i-stack.peek()-1)*h);
            }
            stack.push(i);
        }
        return res;
    }
}
