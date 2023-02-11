package jianzhioffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
。
 */
public class it_35_最小时间差 {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("00:00");
        timePoints.add("23:59");
        int res = new it_35_最小时间差().findMinDifference(timePoints);
        System.out.println(res);
    }
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        int[] times=new int[n];
        for (int i = 0; i < n; i++) {
            String s = timePoints.get(i);
            int temp=Integer.valueOf(s.substring(0,2))*60+Integer.valueOf(s.substring(3,5));
            times[i]=temp;
        }
        Arrays.sort(times);
        int res=24*60+1;
        for (int i = 0; i < n - 1; i++) {
            res=Math.min(res,times[i+1]-times[i]);
        }
        res=Math.min(res,24*60-times[n-1]+times[0]);
        return res;
    }
}
