package leetcode.dailyTest;

import java.util.HashSet;
import java.util.Set;

/**
 * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
 * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 */
public class it_1217_玩筹码 {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        int res = new it_1217_玩筹码().minCostToMoveChips(position);
        System.out.println(res);
    }
    public int minCostToMoveChips(int[] position) {
        Set<Integer> set=new HashSet<>();
        int minCost=Integer.MAX_VALUE;
        for (int i : position) {
            if (set.contains(i)){
                continue;
            }
            int cost=0;
            for (int j : position) {
                if (Math.abs(i-j)%2==1){
                    cost++;
                }
            }
            set.add(i);
            minCost=Math.min(minCost,cost);
        }
        return minCost;
    }
}
