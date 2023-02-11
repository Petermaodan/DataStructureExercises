package leetcode.hot100;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同
 * 一个单元格内的字母不允许被重复使用
 * <p>
 * 深度优先搜索解决
 */
public class it_79_单词搜索 {

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}

                };
        String word="ABCCED";
        System.out.println(new it_79_单词搜索().exist(board,word));
    }

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        //维护一个visited数组，用于表示每一个位置是否已经被访问过
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        //第一中情况->匹配的字母不符合，直接返回false
        if (board[i][j] != s.charAt(k)) {
            return false;
        }
        //第二种情况，匹配的是最后自己字母，并且符合要求
        else if (k == s.length()-1) {
            return true;
        }
        //第三种情况，需要向周围寻找符合要求的字符
        visited[i][j] = true;//标记为已经访问过
        //遍历图常用的方位标记
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                //判断是否被访问过
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        //维持visited为未被访问过
        visited[i][j] = false;
        return result;
    }
}
