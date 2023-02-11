package it_08_滑动窗口;
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

import java.util.HashMap;

public class it_3_无重复字符串的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        char[] ss=s.toCharArray();
        HashMap<Character,Integer> window=new HashMap<>();
        int left=0,right=0;
        int res=0;
        while (right<s.length()){
            char c=ss[right];
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            //当出现重复的字母时，就需要收缩
            while (window.getOrDefault(c,0)>1){
                char d=ss[left];
                left++;
                window.put(d,window.getOrDefault(d,0)-1);
            }
            //这里为什么是right-left?，因为当right指向a的时候，right++->就变成了1
            res=Math.max(res,right-left);
        }
        return res;
    }

    public static void main(String[] args) {
        it_3_无重复字符串的最长子串 lols=new it_3_无重复字符串的最长子串();
        String s="abcabcbb";
        System.out.println(lols.lengthOfLongestSubstring(s));
    }
}
