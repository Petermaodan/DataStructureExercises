package leetcode.hot100;

/**
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 * 以下是井字游戏的规则：
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 *
 * 思路，本题是模拟题，考虑几种情况，很好理解
 * 由于 X 先手，O 后手，两者轮流下子。因此 O 的数量不会超过 X，且两者数量差不会超过 11，否则为无效局面；
 * 若局面是 X 获胜，导致该局面的最后一个子必然是 X，此时必然有 X 数量大于 O（X 为先手），否则为无效局面；
 * 若局面是 O 获胜，导致该局面的最后一个子必然是 O，此时必然有 X 数量等于 O（X 为先手），否则为无效局面；
 * 局面中不可能出现两者同时赢（其中一方赢后，游戏结束）。
 */
public class it_794_有效的井字游戏 {
    public static void main(String[] args) {
        String[] board = {"XOX","O O","XOX"};
        boolean res = new it_794_有效的井字游戏().validTicTacToe(board);
        System.out.println(res);
    }
    public boolean validTicTacToe(String[] board) {
        //先转化为char数组
        char[][] chars=new char[3][3];
        int x=0,o=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char temp=board[i].charAt(j);
                if (temp=='X'){
                    x++;
                }else if (temp=='O'){
                    o++;
                }
                chars[i][j]=temp;
            }
        }
        boolean a=check(chars,'X'),b=check(chars,'O');
        if (o>x||x-o>1)return false;
        if (a&&x<=o)return false;
        if (b&&x!=o)return false;
        if (a&&b)return false;
        return true;
    }

    private boolean check(char[][] chars, char c) {

        //先判断行和列
        for (int i = 0; i < 3; i++) {
                if (chars[0][i]==c&&chars[1][i]==c&&chars[2][i]==c)return true;
                if (chars[i][0]==c&&chars[i][1]==c&&chars[i][2]==c)return true;
        }

        //判断斜着的是否可行
        boolean a=true,b=true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i==j)a&=chars[i][j]==c;
                if (i+j==2)b&=chars[i][j]==c;
            }
        }
        return a||b;
    }
}
