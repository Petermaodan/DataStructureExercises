package leetcode.hot100;

/**
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算 最多 能喝到多少瓶酒。
 */
public class it_1518_换酒问题 {
    public static void main(String[] args) {
        int numBottles=9,numExchange=3;
        int res = new it_1518_换酒问题().numWaterBottles(numBottles, numExchange);
        System.out.println(res);
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        int res=numBottles;
        while (numBottles>=numExchange){
            int exChange=numBottles%numExchange;
            numBottles/=numExchange;
            res+=numBottles;
            numBottles+=exChange;
        }
        return res;
    }
}
