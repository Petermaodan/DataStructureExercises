package jianzhioffer;
/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 */

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class it_57_2_和为s的连续正数序列 {
    public static void main(String[] args) {
        int target=9;
        int[][] res=new it_57_2_和为s的连续正数序列().findContinuousSequence(target);
        ListUtil.arrayTowNums(res);
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        int i=1,j=1;//左闭右开的滑动窗口
        int sum=0;
        while (i<=target/2){
            if (sum<target){
                sum+=j;
                j++;
            }else if (sum>target){
                sum-=i;
                i++;
            }else {
                //找到目标值
                int[] arr=new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i]=k;
                }
                res.add(arr);

                // 记录完之后左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
