package leetcode.dailyTest;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
 *
 * 给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
 *
 * 返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
 *
 * 每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
 *
 */
public class it_1282_用户分组 {
    public static void main(String[] args) {
        int[] groupSizes = {2,1,3,3,3,2};
        List<List<Integer>> lists = new it_1282_用户分组().groupThePeople(groupSizes);
        ListUtil.arrayTwo(lists);
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n=groupSizes.length;
        int[][] newGroup=new int[n][2];
        for (int i = 0; i < n; i++) {
            newGroup[i][0]=groupSizes[i];
            newGroup[i][1]=i;
        }
        Arrays.sort(newGroup,(o1, o2) -> o1[0]-o2[0]);
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count=newGroup[i][0];
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < count; j++) {
                list.add(newGroup[i+j][1]);
            }
            res.add(list);
            i=i+count-1;
        }
        return res;
    }
}
