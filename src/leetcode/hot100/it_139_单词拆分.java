package leetcode.hot100;
/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 *我们定义dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词。
 * 从前往后计算考虑转移方程，每次转移的时候我们需要枚举包含位置 i−1 的最后一个单词，看它是否出现在字典中以及
 * 除去这部分的字符串是否合法即可。公式化来说，我们需要枚举s[0..i−1] 中的分割点 j ，看s[0..j−1] 组成的字符串 s_1（默认j=0 时 s_1为空串）和
 * s[j..i−1] 组成的字符串 s_2是否都合法，如果两个字符串均合法，那么按照定义 s_1和 s_2
 *   拼接成的字符串也同样合法。由于计算到dp[i] 时我们已经计算出了dp[0..i−1] 的值，因此字符串 s_1是否合法可以直接由 dp[j] 得知，
 *   剩下的我们只需要看 s_2是否合法即可，因此我们可以得出如下转移方程：
 * dp[i]=dp[j] && check(s[j..i−1])
 *
 * 其中 check(s[j..i-1]) 表示子串s[j..i−1] 是否出现在字典中

 *
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class it_139_单词拆分 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict=new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new it_139_单词拆分().wordBreak(s,wordDict));

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet<>(wordDict);
        int n=s.length();
        boolean[] dp= new boolean[n + 1];
        //base case
        dp[0]=true;
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 0; j < i; j++) {
                //dp[i]=dp[j] && check(s[j..i−1])
                if (dp[j]&&wordDictSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
