package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 基本思路，使用滑动窗口解决
 */
public class it_438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = new it_438_找到字符串中所有字母异位词().findAnagrams(s, p);
        ListUtil.arrayOne(anagrams);
    }

    //使用数组对map进行空间上的优化
    //更加容易理解
    private List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        int n=s.length(),m=p.length();
        int[] windows=new int[26],need=new int[26];
        for (int i = 0; i < m; i++) {
            need[p.charAt(i)-'a']++;
        }
        //双指针
        int left=0,right=0;
        while (right<n){
            char c=s.charAt(right);
            right++;
            windows[c-'a']++;
            if (right-left>m){
                windows[s.charAt(left++)-'a']--;
            }
            if (check(windows,need)){
                res.add(left);
            }
        }
        return res;
    }

    private boolean check(int[] windows, int[] need) {
        for (int i = 0; i < 26; i++) {
            if (windows[i]!=need[i])return false;
        }
        return true;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res=new ArrayList<>();
        Map<Character,Integer> need=new HashMap<>();
        Map<Character,Integer> windows=new HashMap<>();
        int pLen=p.length();
        int count=0;
        //键需要的单词进行统计
        for (int i = 0; i <pLen; i++) {
            char c = p.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        //双指针实现滑动窗口
        int left=0,right=0;
        while (right<s.length()){
            char c=s.charAt(right);
            right++;
            //如果need包含c,windows就需要加上
            if (need.containsKey(c)){
                windows.put(c,windows.getOrDefault(c,0)+1);
                //若两个map中的个数相等，则总数加一
                if (need.getOrDefault(c,0).equals(windows.getOrDefault(c,-1))){
                    count++;
                }
            }

            //right-left>=pLen时，则进行收缩
            if (right-left>=pLen){
                if (need.size()==count){
                    res.add(left);
                }
                char d=s.charAt(left);
                if (need.containsKey(d)){
                    if (need.getOrDefault(d,0).equals(windows.getOrDefault(d,-1))){
                        count--;
                    }
                    //窗口中的d要减一
                    windows.put(d,windows.get(d)-1);
                }
                left++;
            }
        }
        return res;
    }
}
