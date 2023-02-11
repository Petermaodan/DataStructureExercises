package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.*;

/**
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 *
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成;
 *      "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成;
 *      "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
 *
 *定义 f[i] 为考虑 s 的前 ii个字符（令下标从 1 开始），能够切分出的最大 item 数的个数。
 * 不失一般性的考虑 f[i] 该如何转移：假设 f[i] 可由 f[j] 转移而来（其中 j<i），那么能够转移的充要条件为 f[j]!=0 且子串s[(j+1)..i] 在 words 出现过。
 *
 * 又由于 我们在计算某个子串 s 的哈希值时，是从前往后处理每一位的s[i]，因此在转移f[i] 时，我们期望能够从前往后处理子串，这是常规的从[0,i−1] 范围内找可转移点f[j] 无法做到的。
 *
 * 所以 我们调整转移逻辑为：从 f[i] 出发，枚举范围[i+1,n]，找到可由 f[i] 所能更新的状态f[j]，并尝试使用 f[i] 来更新 f[j]。转移方程为：
 *
 * f[j] = \max(f[j], f[i] + 1)
 * f[j]=max(f[j],f[i]+1)
 *
 * 当然，能够转移的前提条件为 f[i] 为有效值，且子串 s[(i+1),j] 在 words 出现过。
 *
 * 一些细节：为了方便，我们定义f[i]=−1 为无效状态；
 * 另外由于字符串哈希会产生哈希碰撞，这里在计算哈希值的时候，修改了一下哈希计算方式（额外增加了一个 OFFSET），当时的目的是想在电脑没电前 AC，而另一个更加稳妥的方式是使用双哈希，或是干脆记录某个哈希值对应了哪些字符串。
 *

 */
public class it_472_连接词_DP_字符串哈希 {
    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> res = new it_472_连接词_DP_字符串哈希().findAllConcatenatedWordsInADict(words);
        ListUtil.arrayOneString(res);

    }
    Set<Long> set=new HashSet<>();
    //OFFSET避免哈希冲突
    int P=131,OFFSET=128;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String s : words) {
            long hash=0;
            for (char c : s.toCharArray()) {
                hash=hash*P+(c-'a')+OFFSET;
            }
            set.add(hash);
        }
        List<String> ans=new ArrayList<>();
        for (String s : words) {
            if (check(s)){
                ans.add(s);
            }
        }
        return ans;
    }

    //dp
    //*定义 f[i] 为考虑 s 的前 ii个字符（令下标从 1 开始），能够切分出的最大 item 数的个数。
    // * 不失一般性的考虑 f[i] 该如何转移：假设 f[i] 可由 f[j] 转移而来（其中 j<i），那么能够转移的充要条件为 f[j]!=0 且子串s[(j+1)..i] 在 words 出现过。
    private boolean check(String s) {
        int n=s.length();
        int[] f=new int[n+1];
        Arrays.fill(f,-1);
        f[0]=0;
        for (int i = 0; i <=n ; i++) {
            if (f[i]==-1)continue;
            long cur=0;
            for (int j = i+1; j <=n ; j++) {
                cur=cur*P+(s.charAt(j-1)-'a')+OFFSET;
                if (set.contains(cur)){
                    f[j]=Math.max(f[j],f[i]+1);
                }
            }
            if (f[n]>1)return true;
        }
        return false;
    }
}
