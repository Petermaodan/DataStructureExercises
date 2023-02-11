package jianzhioffer;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 */
public class it_12_矩阵中的路径 {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean res=new it_12_矩阵中的路径().exist(board,word);
        System.out.println(res);
    }


    int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(board,word,visited,i,j,0))return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int m, int n, int k) {
        //跳出循环的条件
        if (board[m][n]!=word.charAt(k))return false;
        //找到单词了
        if (k==word.length()-1)return true;
        //设置标记
        visited[m][n]=true;
        boolean result=false;
        for (int[] ints : direction) {
            int newi=m+ints[0],newj=n+ints[1];
            //判断是否出界
            if (isArea(board,newi,newj)&&!visited[newi][newj]){
                //k加一很关键
                    boolean flag=dfs(board,word,visited,newi,newj,k+1);
                    if (flag){
                        result=flag;
                        break;
                    }
            }
        }
        //回溯
        visited[m][n]=false;
        return result;

    }

    private boolean isArea(char[][] board, int newi, int newj) {
        return newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length;
    }


//    public boolean exist(char[][] board, String word) {
//        char[] words=word.toCharArray();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (dfs(board,words,i,j,0))return true;
//            }
//        }
//        return false;
//    }
//
//    boolean dfs(char[][] board, char[] words, int i, int j, int k) {
//        //边界条件
//        if (i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=words[k])return false;
//        //终止条件
//        if (k==words.length-1)return true;
//
//        //给已经访问过的做标记
//        board[i][j]='\0'; //java设置空字符的方法
//        //递归查找,上下左右
//        boolean res=dfs(board,words,i+1,j,k+1)||dfs(board,words,i-1,j,k+1)
//                ||dfs(board,words,i,j+1,k+1)||dfs(board,words,i,j-1,k+1);
//        //溯回，防止对之后的查找造成影响
//        board[i][j]=words[k];
//        return res;
//
//    }
}
