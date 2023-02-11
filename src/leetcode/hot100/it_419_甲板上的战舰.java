package leetcode.hot100;

/**
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
 *
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 *
 * 输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
 * 输出：2
 *
 * 实际上只要保证X格子的左边和上边是空位即可
 */
public class it_419_甲板上的战舰 {
    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        int res = new it_419_甲板上的战舰().countBattleships(board);
        System.out.println(res);
    }

    public int countBattleships(char[][] board) {
        int n=board.length,m=board[0].length;
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //注意边界条件
                if (i>0&&board[i-1][j]=='X')continue;
                if (j>0&&board[i][j-1]=='X')continue;
                if (board[i][j]=='X')ans++;
            }
        }
        return ans;
    }
}
