package it_08_滑动窗口;
/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 */

import java.util.HashMap;

public class it_567_字符串的排列 {

    public boolean checkInclusion(String s,String t){
        HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();

        for (char c : tt) {
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int valid=0;
        while (right<s.length()){
            char c=ss[right];
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.getOrDefault(c,0).equals(need.getOrDefault(c,-1))){
                    valid++;
                }
            }
            //判断窗口是否需要收缩
            //这里为什么是right-left?，因为当right指向a的时候，right++->就变成了1
            while (right-left>=t.length()){
                if (valid==need.size()){
                    return true;
                }
                char d=ss[left];
                left++;
                if (need.containsKey(d)){
                    if (window.getOrDefault(d,0).equals(need.getOrDefault(d,-1))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        it_567_字符串的排列 pm=new it_567_字符串的排列();
        String t="ab";
        String s="eidbaooo";
        System.out.println(pm.checkInclusion(s,t));
    }
}
