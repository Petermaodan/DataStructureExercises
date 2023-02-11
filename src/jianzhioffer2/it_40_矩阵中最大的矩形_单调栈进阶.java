package jianzhioffer2;

import java.util.Stack;

/**
 * Java 转换成求直方图最大矩形面积
 * 首先将第一行看作一个直方图
 *
 * 接着把第二行以上（第一行+第二行）看作直方图
 *
 * 把第三行以上（第一行+第二行+第三行）看作直方图
 *
 * ……
 *
 * 以此类推
 *
 * 高度是从直方图底部向上连续的“1”个数
 *
 * 最大直方图的进阶
 */
public class it_40_矩阵中最大的矩形_单调栈进阶 {
    public static void main(String[] args) {
        String[] matrix = {"10100","10111","11111","10010"};
        int res = new it_40_矩阵中最大的矩形_单调栈进阶().maximalRectangle(matrix);
        System.out.println(res);
    }
    public int maximalRectangle(String[] matrix) {
        if (matrix.length==0){
            return 0;
        }
        int[] heights=new int[matrix[0].length()];
        int maxRectangle=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length(); j++) {
                if (matrix[i].charAt(j)=='1'){
                    heights[j]+=1;
                }else {
                    heights[j]=0;
                }
            }
            maxRectangle=Math.max(maxRectangle,largestRectangleArea(heights));
        }
        return maxRectangle;
    }

    private int largestRectangleArea(int[] heights) {
        int[] newHeights=new int[heights.length+2];
        System.arraycopy(heights,0,newHeights,1,heights.length);
        Stack<Integer> stack=new Stack<>();
        int maxRectangleArea=0;
        for (int i = 0; i < newHeights.length; i++) {
            while ((!stack.isEmpty())&&newHeights[i]<newHeights[stack.peek()]){
                int h=newHeights[stack.pop()];
                maxRectangleArea=Math.max(maxRectangleArea,(i-stack.peek()-1)*h);
            }
            stack.push(i);
        }
        return maxRectangleArea;
    }
}
