package leetcode.hot100;

/**
 * 当提莫攻击艾希，艾希的中毒状态正好持续 duration 秒。
 *
 * 正式地讲，提莫在 t 发起发起攻击意味着艾希在时间区间 [t, t + duration - 1]（含 t 和 t + duration - 1）处于中毒状态。如果提莫在中毒影响结束 前 再次攻击，中毒状态计时器将会 重置 ，在新的攻击之后，中毒影响将会在 duration 秒后结束。
 *
 * 给你一个 非递减 的整数数组 timeSeries ，其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击，以及一个表示中毒持续时间的整数 duration 。
 *
 * 返回艾希处于中毒状态的 总 秒数。
 *
 */
public class it_495_提莫攻击 {
    public static void main(String[] args) {
        int[] timeSeries={1,2};
        int res = new it_495_提莫攻击().findPoisonedDuration(timeSeries, 2);
        System.out.println(res);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sumDuration=0;
        int expired=0;
        for (int i = 0; i < timeSeries.length; i++) {
            //没有重叠
            if (expired<=timeSeries[i]){
                sumDuration+=duration;
            }else {
                //有重叠区域，要减去之前添加的数值
                sumDuration+=timeSeries[i]+duration-expired;
            }
            //跟新最后的数值
            expired=timeSeries[i]+duration;
        }
        return sumDuration;
    }
}
