package leetcode.hot100;

/**
 * 我们正在玩一个猜数游戏，游戏规则如下：
 *
 * 我从 1 到 n 之间选择一个数字。
 * 你来猜我选了哪个数字。
 * 如果你猜到正确的数字，就会 赢得游戏 。
 * 如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
 * 每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
 * 给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。

 思路：因此为求得「最坏情况下最好」的结果，我们应当取所有的 x 中的最小值
 和高楼扔鸡蛋类似
 */
public class it_375_猜数字大小 {
    public static void main(String[] args) {
        int res = new it_375_猜数字大小().getMoneyAmount(10);
        System.out.println(res);
    }

    static int N=201;
    int[][] cache=new int[N][N];
    public int getMoneyAmount(int n) {
        return dfs(1,n);
    }

    private int dfs(int l, int r) {
        if (l>=r)return 0;
        if (cache[l][r]!=0)return cache[l][r];
        int ans=Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            //因此为求得「最坏情况下最好」的结果，我们应当取所有的 x 中的最小值
            int cur=Math.max(dfs(l,i-1),dfs(i+1,r))+i;
            ans=Math.min(ans,cur);
        }
        cache[l][r]=ans;
        return ans;
    }




}
