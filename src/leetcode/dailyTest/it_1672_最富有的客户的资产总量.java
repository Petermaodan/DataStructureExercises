package leetcode.dailyTest;

/**
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​
 * 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 */
public class it_1672_最富有的客户的资产总量 {
    public static void main(String[] args) {
        int[][] accounts={{1,2,3},{3,2,1}};
        int res = new it_1672_最富有的客户的资产总量().maximumWealth(accounts);
        System.out.println(res);
    }
    public int maximumWealth(int[][] accounts) {
        int res=Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int sum=0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum+=accounts[i][j];
            }
            res=Math.max(res,sum);
        }
        return res;
    }
}
