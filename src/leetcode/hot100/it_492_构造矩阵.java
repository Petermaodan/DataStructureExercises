package leetcode.hot100;

import BaseUtil.ListUtil;

/**
 * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 *
 * 1. 你设计的矩形页面必须等于给定的目标面积。
 *
 * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 *
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 * 你需要按顺序输出你设计的页面的长度 L 和宽度 W。
 */
public class it_492_构造矩阵 {
    public static void main(String[] args) {
        int area=10;
        int[] ints = new it_492_构造矩阵().constructRectangle(area);
        ListUtil.arrayOneNums(ints);
    }
    public int[] constructRectangle(int area) {
        int maxValue= (int) Math.sqrt(area);
        int[] res=new int[2];
        for (int i = maxValue; i >0 ; i--) {
            int temp=area/i;
            if (temp*i==area){
                res[0]=temp;
                res[1]=i;
                break;
            }
        }
        return res;
    }
}
