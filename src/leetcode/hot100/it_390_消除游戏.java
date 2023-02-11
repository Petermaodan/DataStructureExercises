package leetcode.hot100;

/**
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 *
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 给你整数 n ，返回 arr 最后剩下的数字。
 *
 * 思路，实际上类似于等差数列，每次消除的步长都要*2
 * 我的想法是每个回合更新和记录head变量，当数组的总数变为1时，head就是最后的一个数
 *
 * 什么时候更新这个head变量呢？
 *
 * 当我们从左边开始移除的时
 * 当我们从右边开始移除并且剩余的数的总数 number % 2 == 1时
 * 比如 2 4 6 8 10，我们从10开始移除，我们将会移除10，6，2，head被移除并且变为4
 * 比如 2 4 6 8 10 12，我们从12开始移除，我们将会移除12，8，4，head仍然是2
 * 然后我们发现了一个更新head的规则
 *
 */
public class it_390_消除游戏 {
    public static void main(String[] args) {
        int n=9;
        int res = new it_390_消除游戏().lastRemaining(n);
        System.out.println(res);
    }
    public int lastRemaining(int n) {
        int head=1,step=1;
        //判断是从左到右消除还是从右到左消除
        boolean flag=true;
        while (n>1){
            //从左到右消除或者从右到左消除时是奇数个，head均要改变，及加上步长，实际上是等差数列
            if (flag||n%2==1){
                head+=step;
            }
            //步长改变
            step*=2;
            //flag取反
            flag=!flag;
            //消除一半的数字
            n/=2;
        }
        return head;
    }
}
