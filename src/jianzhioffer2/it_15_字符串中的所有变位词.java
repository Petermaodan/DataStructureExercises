package jianzhioffer2;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 变位词 指字母相同，但排列不同的字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 */
public class it_15_字符串中的所有变位词 {
    public static void main(String[] args) {
        String s = "ab", p = "ba";
        List<Integer> res = new it_15_字符串中的所有变位词().findAnagrams(s, p);
        ListUtil.arrayOne(res);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length(), m = s.length();
        List<Integer> res = new ArrayList<>();
        if (n > m) {
            return res;
        }
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        for (int i = 0; i < n; i++) {
            countS1[p.charAt(i) - 'a']++;
            countS2[s.charAt(i) - 'a']++;
        }
        if (n==m&&Arrays.equals(countS1, countS2)){
            res.add(0);
        }
        for (int l = 0, r = n; r < m; l++, r++) {
            if (Arrays.equals(countS1, countS2)) {
                res.add(l);
            }
            countS2[s.charAt(r) - 'a']++;
            countS2[s.charAt(l) - 'a']--;
            if (r == m - 1 && Arrays.equals(countS1, countS2)) {
                res.add(l + 1);
            }
        }
        return res;
    }
}
