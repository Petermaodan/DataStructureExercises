package leetcode.dailyTest;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 */
public class it_1200_最小绝对差 {
    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        List<List<Integer>> res = new it_1200_最小绝对差().minimumAbsDifference(arr);
        ListUtil.arrayTwo(res);
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbs=Integer.MAX_VALUE;
        int i,j;
        List<List<Integer>> res=new ArrayList<>();
        for (i = 0,j=1; j <arr.length ; i++,j++) {
            int temp=arr[j]-arr[i];
            if (temp>minAbs){
                continue;
            }else if (temp<=minAbs){
                if (temp<minAbs){
                    minAbs=temp;
                    res.clear();
                }
                List<Integer> list=new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[j]);
                res.add(list);
            }
        }
        return res;
    }
}
