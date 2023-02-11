package it_08_滑动窗口;
/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class it_438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> list=new ArrayList<>();
        char[] ss=s.toCharArray();
        char[] pp=p.toCharArray();
        HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        for (char c : pp) {
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left=0,right=0;
        int valid=0;
        while (right<s.length()){
            char c=ss[right];
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                //注意，这里千万不能用==，Integer 在大于127 的时候 不从常量池里拿，是个对象，所以换成equals
                if (window.getOrDefault(c,0).equals(need.getOrDefault(c,-1))){
                    valid++;
                }
            }
            //判断窗口是否需要收缩
            while (right-left>=p.length()){
                // 当窗口符合条件时，把起始索引加入 res
                if (valid==need.size()){
                    list.add(left);
                }
                char d=ss[left];
                left++;
                if (need.containsKey(d)){
                    if (window.getOrDefault(d,0).equals(need.getOrDefault(d,-1))){
                        valid--;
                    }
                    //d必定在window中
                    window.put(d,window.getOrDefault(d,0)-1);

                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        it_438_找到字符串中所有字母异位词 f=new it_438_找到字符串中所有字母异位词();
        String s="cbaebabacd";
        String p="abc";
        List list=f.findAnagrams(s,p);
        System.out.println(list);
    }
}
