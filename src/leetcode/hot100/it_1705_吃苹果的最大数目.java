package leetcode.hot100;

import java.util.PriorityQueue;

/**
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 *
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 *
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 *
 * 经典优先队列+贪心的问题
 * 直觉上，我们会觉得「优先吃掉最快过期的苹果」会是最优，而这个维护苹果过期的过程，可以使用「小根堆」来实现。
 *
 * 具体的，我们可以按照如下逻辑进行模拟（令 n 为数组长度，time 为当前时间，ans 为吃到的苹果数量）：
 *
 * 首先，如果「time<n」或者「堆不为空」，说明「还有苹果未被生成」或者「未必吃掉」，继续模拟；
 * 在当日模拟中，如果「time<n」，说明当天有苹果生成，先将苹果 以二元组 (time+days[time]−1,apples[time]) 形式加入小根堆中；
 * 其中二元组表示 (最后食用日期, 当日产生苹果数量)(最后食用日期,当日产生苹果数量)，同时需要过滤 apples[time]=0 的情况。
 *
 * 然后尝试从堆中取出「最后食用日期」最早「可食用」的苹果 cur，如果堆顶元素已过期，则抛弃；
 * 如果吃掉 cur 一个苹果后，仍有剩余，并且最后时间大于当前时间（尚未过期），将 cur 重新入堆；
 * 循环上述逻辑，直到所有苹果出堆。
 *
 * 优先队列，每次捡快烂的吃

 */
public class it_1705_吃苹果的最大数目 {
    public static void main(String[] args) {
        int[] apples = {1,2,3,5,2}, days = {3,2,1,4,2};
        int res = new it_1705_吃苹果的最大数目().eatenApples(apples, days);
        System.out.println(res);
    }
    public int eatenApples(int[] apples, int[] days) {
        //小根堆
        PriorityQueue<int[]> queue=new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        int ans=0,time=0;
        int n=apples.length;
        while (time<n||!queue.isEmpty()){
            //如果time小于n并且apples[i]>0就入堆
            //其中二元组表示 (最后食用日期, 当日产生苹果数量)(最后食用日期,当日产生苹果数量)，同时需要过滤 apples[time]=0 的情况。
            //根据可使用的最后期限排序
            if (time<n&&apples[time]>0)queue.add(new int[]{time+days[time]-1,apples[time]});
            while (!queue.isEmpty()&&queue.peek()[0]<time){
                queue.poll();
            }
            if (!queue.isEmpty()){
                int[] cur = queue.poll();
                //如果下次还可以吃就再次加入堆中
                if (--cur[1]>0&&cur[0]>time){
                    queue.add(cur);
                }
                ans++;
            }
            time++;
        }
        return ans;
    }
}
