package leetcode.hot100;

/**
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 * 思路：
 * 本题是模拟题中比较适合做面试题的一种类型，主要难点在于将逻辑用代码准确的表达出来。建议同学在实现代码的时候可以多多输出中间变量验证自己代码的正确性。
 * 「微扰酱」的做法主要分为两部：
 *
 * 确定n对应的数字是几位数字
 * 计算具体是哪一个数字
 * 我们知道 0-9 是一位数， 一位数共有9个， 总计产生 9 * 1 = 9 位数字
 * 我们知道 10-99 是两位数， 一位数共有90个， 总计产生 90 * 2 = 180 位数字
 * ...
 *
 * 依次类推，我们可以把digit位数里产生的数字个数算出来它等于 9*10^{digit}*digit9∗10
 * digit
 *  ∗digit 位数字。
 * 由此通过一个循环，对不同位数一共产生了多少位数字做累计并和n进行比较，我们就可以判断出n对应的数字是几位数字。
 *
 * 第二步；我们找到这个具体的数字，假设n对应的数字是target。
 * 我们先扣掉比target位数低的数字一共占用了多少位。这个在第一步里就求出来了，假设得到的值为N。
 * 剩余的N都是由 digits位数 贡献的，因而我们求除求余就可以知道n对应的是第几个digits位数。
 *
 * 举个例子
 * 以190为例。
 * 第一步我们会扣掉 9+180 = 189； 得到190对应的是一个三位数。 且 190 - 189 = 1 即说明190是第一个三位数。
 * (1 - 1) / 3 = 0
 * (1 - 1) % 3 = 0
 * 说明190是第一个三位数的第一个数字。 而第一个三位数是100，从而得到答案1。
 *
 * 翻译成代码如下：
 *
 * 总的来说就是先找到一步步精确定位出是哪一个数
 */
public class it_400_第N位数字 {
    public static void main(String[] args) {
        int n=10;
        int res = new it_400_第N位数字().findNthDigit(n);
        System.out.println(res);
    }
    public int findNthDigit(int n) {
        long N=n;
        int digits=1;//位数
        long border=9;//digits位数共产生多少数字
        while (N>=0){
            if (N<=border*digits)break;
            N-=border*digits;
            digits++;
            border*=10;
        }
        // 循环结束后 剩余的N都是由 digits位数 贡献的
        // 每个 digits位数 都产生了 digits个数字； 因而我们求除求余就可以知道n对应的是第几个digits位数
        int offset= (int) ((N-1)/digits);
        int begin=1;//用于计算最小的digits位数
        for (int i = 0; i < digits - 1; i++) {
            begin*=10;
        }
        //表示在定位到的这个数的第几个数字
        int mod= (int) ((N-1)%digits);
        //目标数
        String target=String.valueOf(begin+offset);
        int ans=target.charAt(mod)-'0';
        return ans;


    }
}
