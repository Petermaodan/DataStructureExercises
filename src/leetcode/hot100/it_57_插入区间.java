package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 *
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 */
public class it_57_插入区间 {
    public static void main(String[] args) {
        int[][] intervals={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervals={4,8};
        int[][] ints = new it_57_插入区间().insert(intervals, newIntervals);
        ListUtil.arrayTowNums(ints);
    }

    //关键是有三种状态
    //左边不合并，右边不合并以及中间的合并区间
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int i=0;
        int len=intervals.length;
        //左边不重复的区间加入结果
        while (i<len&&intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        //中间重复部分
        while (i<len&&newInterval[1]>=intervals[i][0]){
            //左端取较小者，更新给兰区间的左端
             //右端取较大者，更新给兰区间的右端
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        //右边的不重叠区域
        while (i<len){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
