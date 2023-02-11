package leetcode.dailyTest;

import BaseUtil.ListUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 *
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 *
 * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 *
 *  
 * 示例 1：
 *
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * 示例 2：
 *
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 */
public class it_436_寻找右区间 {
    public static void main(String[] args) {
        int[][]intervals={{3,4},{2,3},{1,2}};
        int[] res = new it_436_寻找右区间().findRightInterval(intervals);
        ListUtil.arrayOneNums(res);
    }
    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        int[][] clone=new int[n][2];
        //clone[i][0]记录start,clone[i][1]记录下标idx
        for (int i = 0; i < intervals.length; i++) {
            clone[i]=new int[]{intervals[i][0],i};
        }
        Arrays.sort(clone,(o1, o2) -> {
            return o1[0]-o2[0];
        });
        int[] res=new int[n];
        //二分法查找
        for (int i = 0; i < n; i++) {
            int endi=intervals[i][1];
            int l=0,r=n-1;
            while (l<r){
                int mid=(l+r)/2;
                if (clone[mid][0]>=endi){
                    r=mid;
                }else {
                    l=mid+1;
                }
            }
            res[i]=clone[r][0]>=endi?clone[r][1]:-1;
        }
        return res;
    }
}
