package leetcode.hot100;

/**
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 * 下面这个条件很关键
 * 在第 j/3 + (i/3)*3个box中是否出现过.为什么是j/3 + (i/3)*3呢
 *
 * 思路：就按照从左往右、从上往下的顺序遍历一次board，完成3个条件的检验
 * 给定i和j，如何判定board[i][j]在第几个box呢？
 *  显然属于第几个box由i和j的组合唯一确定，例如board[2][2]一定是第0个box，board[4][7]一定是第5个box，可以画出来看一下，但是规律在哪里呢？
 *

 */
public class it_36_有效的数独 {
    public static void main(String[] args) {
    }
    public boolean isValidSudoku(char[][] board) {
        // 哈希表存储每一行的每个数是否出现过，默认初始情况下，每一行每一个数都没有出现过
        // 整个board有9行，第二维的维数10是为了让下标有9，和数独中的数字9对应。
        //总的来说就是对出现的数字进行标记
        int[][] row=new int[9][10];
        int[][] col=new int[9][10];
        //每一块
        int[][] box=new int[9][10];
        //按行遍历
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.')continue;

                int temp=board[i][j]-'0';
                if (row[i][temp]==1)return false;
                if (col[j][temp]==1)return false;
                if (box[j/3+(i/3)*3][temp]==1)return false;
                //不存在重复，记录相应数字在对应行列以及块中出现的次数
                row[i][temp]=1;
                col[j][temp]=1;
                box[j/3+(i/3)*3][temp]=1;
            }
        }
        return true;

    }

}
