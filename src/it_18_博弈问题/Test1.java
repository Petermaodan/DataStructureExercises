package it_18_博弈问题;

/**
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 *
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 
 *
 */
public class Test1 {
    public static void main(String[] args) {
        int[] piles={9,1,2,3};
        int result=new Test1().stoneGame(piles);
        System.out.println(result);
    }

    private int stoneGame(int[] piles) {
        int n=piles.length;
        Pair[][] dp= new Pair[n][n];
        for (int i = 0; i < n; i++) {
            //只需要写对角线的上半部分区域
            for (int j =i; j < n; j++) {
                dp[i][j]=new Pair(0,0);
            }
        }
        //base case:->斜对角线为base case
        for (int i = 0; i < n; i++) {
            dp[i][i].fir=piles[i];
            dp[i][i].sec=0;
        }
        //斜着遍历
        for (int l = 2; l <=n; l++) {
            for (int i = 0; i <=n-l; i++) {
                int j=l+i-1;
                //先拿会影响之后的结果
                //每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
                //所以并不能从中间取走石头
                //piles[i]->行的开始，piles[j]->行的结束
                int left=piles[i]+dp[i+1][j].sec;
                int right=piles[j]+dp[i][j-1].sec;

                if (left>right){
                    dp[i][j].fir=left;
                    dp[i][j].sec=dp[i+1][j].fir;
                }else {
                    dp[i][j].fir=right;
                    dp[i][j].sec=dp[i][j-1].fir;
                }
            }
        }
        Pair res=dp[0][n-1];
        return res.fir-res.sec;
    }

}
