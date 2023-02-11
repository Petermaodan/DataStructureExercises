package leetcode.dailyTest;

import java.util.Arrays;

/**
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度：[1,1,4,2,1,3]
 * 预期：[1,1,1,2,3,4]
 * 下标 2 、4 、5 处的学生高度不匹配。
 */
public class it_1051_高度检查器 {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        int res = new it_1051_高度检查器().heightChecker(heights);
        System.out.println(res);
    }
    public int heightChecker(int[] heights) {
        int[] expected;
        expected=Arrays.copyOf(heights,heights.length);
        Arrays.sort(expected);
        int res=0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i]!=expected[i]){
                res++;
            }
        }
        return res;
    }
}
