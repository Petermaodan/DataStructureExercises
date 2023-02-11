package leetcode.dailyTest;

import BaseUtil.ListUtil;

/**
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 * <p>
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 * <p>
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 * <p>
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 */
public class it_1706_球会落何处 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        int[] answer = new it_1706_球会落何处().findBall(grid);
        ListUtil.arrayOneNums(answer);

    }

    int n, m;

    public int[] findBall(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            int idx = dfs(grid, 0, i);
            answer[i] = idx;
        }
        return answer;
    }

    private int dfs(int[][] grid, int row, int col) {
        //跳出递归
        if ((grid[row][col] == -1 && col == 0)
                || (grid[row][col] == 1 && col == m - 1)
                || (grid[row][col] == 1 && grid[row][col + 1] == -1)
                || (grid[row][col] == -1 && grid[row][col - 1] == 1)) {

            return -1;
        }
        if (row == n - 1) {
            if (grid[row][col] == 1) {
                return col + 1;
            } else {
                return col - 1;
            }
        }
        if (grid[row][col] == 1) {
            return dfs(grid, row + 1, col + 1);
        } else {
            return dfs(grid, row + 1, col - 1);
        }
    }
}
