package leetcode.dailyTest;

import BaseUtil.ListUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 *
 * 序号代表了一个元素有多大。序号编号的规则如下：
 *
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 *
 *
 */
public class it_1331_数组序号转换 {
    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        int[] ints = new it_1331_数组序号转换().arrayRankTransform(arr);
        ListUtil.arrayOneNums(ints);
    }
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(copy);
        Map<Integer,Integer> map=new HashMap<>();
        int index=1;
        for (int i : copy) {
            if (map.containsKey(i)){
                continue;
            }else {
                map.put(i,index++);
            }
        }
        int[] res=new int[n];
        for (int i = 0; i < n; i++) {
            res[i]=map.get(arr[i]);
        }
        return res;
    }
}
