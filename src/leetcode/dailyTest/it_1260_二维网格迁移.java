package leetcode.dailyTest;

import BaseUtil.ListUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 */
public class it_1260_二维网格迁移 {
    public static void main(String[] args) {
        int[][] grid={{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
//        int[][] grid={{1},{2},{3},{4}};
        List<List<Integer>> res = new it_1260_二维网格迁移().shiftGrid(grid, 4);
        ListUtil.arrayTwo(res);
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        int sumCount=m*n;
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                deque.addLast(grid[i][j]);
            }
        }
        k=k%sumCount;
        for (int i = 0; i < k; i++) {
            deque.addFirst(deque.pollLast());
        }
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(deque.pollFirst());
            }
            res.add(list);
        }
        return res;
    }
}
