package leetcode.dailyTest;

/**
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
 *
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 *
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 *
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
 * 示例 1：
 * 输入：maxChoosableInteger = 10, desiredTotal = 11
 * 输出：false
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 */
public class it_464_我能赢吗_博弈论_位运算 {
    public static void main(String[] args) {
        int maxChoosableInteger = 10, desiredTotal = 11;
        boolean res = new it_464_我能赢吗_博弈论_位运算().canIWin(maxChoosableInteger, desiredTotal);
        System.out.println(res);
    }

    int[] visited=new int[1<<21];
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        return dfs(0,0,maxChoosableInteger,desiredTotal);
    }

    private boolean dfs(int state, int sum, int maxChoosableInteger, int desiredTotal) {
        if (visited[state]==1)return true;
        if (visited[state]==2)return false;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (((1<<i)&state)!=0){
                continue;
            }
            if (sum+i>=desiredTotal){
                visited[state]=1;
                return true;
            }
            if (!dfs((1<<i)|state,sum+i,maxChoosableInteger,desiredTotal)){
                visited[state]=1;
                return true;
            }
        }
        visited[state]=2;
        return false;
    }
}
