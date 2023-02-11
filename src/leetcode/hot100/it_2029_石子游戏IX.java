package leetcode.hot100;

/**
 * Alice 和 Bob 再次设计了一款新的石子游戏。现有一行 n 个石子，每个石子都有一个关联的数字表示它的价值。给你一个整数数组 stones ，其中 stones[i] 是第 i 个石子的价值。
 *
 * Alice 和 Bob 轮流进行自己的回合，Alice 先手。每一回合，玩家需要从 stones 中移除任一石子。
 *
 * 如果玩家移除石子后，导致 所有已移除石子 的价值 总和 可以被 3 整除，那么该玩家就 输掉游戏 。
 * 如果不满足上一条，且移除后没有任何剩余的石子，那么 Bob 将会直接获胜（即便是在 Alice 的回合）。
 * 假设两位玩家均采用 最佳 决策。如果 Alice 获胜，返回 true ；如果 Bob 获胜，返回 false 。
 *
 *
 * 首先如果当前 x = 1 时，不能选择 s = 2的石子，否则会导致凑成总和为 3 的倍数而失败；同理 x = 2 时，不能选择 s = 1 的石子；而选择 s = 0的数字，不会改变 x 的状态，可看做换手操作。
 *
 * 同时成对的 s = 0 的等价于没有 s = 0 的石子（双方只需要轮流选完这些 s = 0 的石子，最终会回到先手最开始的局面）；而选择与 x 相同的 s 会导致 x 改变
 * （即 x=1 时，选择 s=1 的石子，会导致 x=2；而 x=2 时，选 s=2 的石子，会导致 x=1）
 *
 */
public class it_2029_石子游戏IX {
    public static void main(String[] args) {
        int[] stones = {5,1,2,4,3};
        boolean res = new it_2029_石子游戏IX().stoneGameIX(stones);
        System.out.println(res);
    }

    public boolean stoneGameIX(int[] stones) {
        int[] count=new int[3];
        for (int stone : stones) {
            //统计0、1、2的数量
            count[stone%3]++;
        }
        //分别判断两种情况
        return count[0]%2==0?!(count[1]==0||count[2]==0):!(Math.abs(count[1]-count[2])<=2);
    }
}
