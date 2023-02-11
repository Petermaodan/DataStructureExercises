package niuke;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class it_14跳台阶 {
    public int jumpFloor(int target) {
//         int[] dp=new int[target+1];
        //base case
        int dp_1 = 1;
        int dp_0 = 1;
        int dp_i = 1;
        if (target >= 2) {
            for (int i = 2; i <= target; i++) {
                dp_i = dp_1 + dp_0;
                dp_0 = dp_1;
                dp_1 = dp_i;
            }
        }
        return dp_i;
    }
}
