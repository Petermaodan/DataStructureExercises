package leetcode.hot100;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *q
 * 思路：本题和把数字翻译成字符串类似若可以翻译，但是存在非法字符的情况因此，
 * 我们有如下转移方程：
 * f[i]=f[i−1],1⩽a≤9
 * f[i]=f[i−2],10⩽b⩽26
 * f[i]=f[i−1]+f[i−2],1⩽a≤9,10⩽b⩽26
 * ​

 */
public class it_91_解码方法 {
    public static void main(String[] args) {
        String s="2306";
        int res = new it_91_解码方法().numDecodings(s);
        System.out.println(res);
    }

    private int numDecodings(String s) {
        int n=s.length();
        //增加一个前导位
        s=" "+s;
        int[] dp=new int[n+1];
        char[] chars = s.toCharArray();
        dp[0]=1;
        for (int i = 1; i <=n ; i++) {
            int a=chars[i]-'0',b=(chars[i-1]-'0')*10+chars[i]-'0';
            if (a>=1&&a<=9)dp[i]+=dp[i-1];
            if (b>=10&&b<=26)dp[i]+=dp[i-2];
        }
        return dp[n];
    }

    //不能通过全部用例,有问题，本题不太适用
    public int numDecodings2(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        //base case
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            String temp=s.substring(i-2,i);
            if (temp.charAt(0)=='0')continue;
            dp[i]=temp.compareTo("10")>=0&&temp.compareTo("26")<=0?dp[i-2]+dp[i-1]:dp[i-1];
        }
        return dp[n];
    }
}
