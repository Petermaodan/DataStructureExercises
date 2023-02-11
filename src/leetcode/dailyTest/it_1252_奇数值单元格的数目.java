package leetcode.dailyTest;

/**
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 *
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 */
public class it_1252_奇数值单元格的数目 {

    public int oddCells(int m, int n, int[][] indices) {
        boolean[] row=new boolean[m],col=new boolean[n];
        int a=0,b=0;
        for (int[] index : indices) {
            //非常优雅的写法
            a+=(row[index[0]]=!row[index[0]])?1:-1;
            b+=(col[index[1]]=!col[index[1]])?1:-1;
        }
        return a*(n-b)+b*(m-a);
    }
}
