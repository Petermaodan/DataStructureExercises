package it_21_KMP字符匹配;

/**
 * dp 数组只和 pat 有关， 那么我们这样设计 KMP 算法就会⽐较漂
 * 亮
 */
public class KMP {
    private int[][] dp;
    private String pat;
    public KMP(String pat){
        this.pat=pat;
        //通过pat构建dp数组
        //需要O(M)时间
        int M=pat.length();
        //dp[状态][字符]=下一个状态
        //base case:只有遇到pat[0]这个字符才能使状态从0到1
        dp[0][pat.charAt(0)]=1;
        //影子状态X初始值为0
        int X=0;
        //构建状态转移图
        for (int j = 1; j <M ; j++) {
            for (int c = 0; c <256 ; c++) {
                if (c==pat.charAt(j)){
                    //是需要的字符，状态推进
                    dp[j][c]=j+1;
                }else {
                    //状态重启、委托X计算重启位置，实际到达影子字符的位置
                    dp[j][c]=dp[X][c];
                }
            }
            //更新影子状态,在 pat 中匹配 pat[1..end]
            //当前是状态X，遇到字符pat[j],X应该转移到哪个状态
            X=dp[X][pat.charAt(j)];
        }
    }
    public int search(String txt){
        //借助dp数组去匹配txt
        //需要O(N)时间
        int M=pat.length();
        int N=txt.length();
        //pat的初始态为0
        int j=0;
        for (int i = 0; i < N; i++) {
            //当前是状态j，遇到字符txt[i]
            //pat应该转移到哪个状态
            j=dp[j][txt.charAt(i)];
            //如果达到终止态，返回匹配开头的索引
            if (j==M)return i-M+1;
        }
        //没有达到终止态，匹配失败
        return -1;
    }
}
