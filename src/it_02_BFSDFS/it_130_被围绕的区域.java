package it_02_BFSDFS;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class it_130_被围绕的区域 {
    public static void main(String[] args) {
        char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new it_130_被围绕的区域().solve(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }

        }

    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean isEdge=i==0||i==n-1||j==0||j==m-1;
                if (isEdge&&board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
                if (board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (!isArea(board,i,j)||board[i][j]=='X'||board[i][j]=='#')return;
        board[i][j]='#';
        dfs(board,i+1,j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }

    private boolean isArea(char[][] board, int i, int j) {
        return i>=0&&i<board.length&&j>=0&&j<board[0].length;
    }
}
