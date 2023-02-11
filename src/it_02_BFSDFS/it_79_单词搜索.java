package it_02_BFSDFS;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 记住深度优先搜索的框架
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


    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, word, visited, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;


    }

    private boolean check(char[][] board, String word, boolean[][] visited, int i, int j, int idx) {
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }else if (idx==word.length()-1){
            return true;
        }
        //标记访问过
        visited[i][j]=true;
        boolean result=false;
        //遍历四个方位
        for (int[] ints : direction) {
            int newi=i+ints[0],newj=j+ints[1];
            if (!isArea(board,newi,newj)||visited[newi][newj]){
                continue;
            }
            boolean flag = check(board, word, visited, newi, newj, idx + 1);
            if (flag){
                result=true;
                break;
            }
        }
        //溯回
        visited[i][j]=false;
        return result;
    }

    private boolean isArea(char[][] board, int newi, int newj) {
        return newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length;
    }
}
