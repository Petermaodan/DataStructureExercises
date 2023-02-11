package it_08_滑动窗口;
/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 输入：s = "ADOBECODEBANC", t = "ABC"
 输出："BANC"
 */

import java.util.HashMap;
import java.util.Scanner;

/**
 * ADOBECODEBANC
 * ABC
 */

public class it_76_最小覆盖子串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = slidingWindow(s, t);
        System.out.println(result);


    }

    private static String slidingWindow(String s, String t) {
        char[] tt = t.toCharArray();
        char[] ss = s.toCharArray();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : tt) {
            need.put(c, need.getOrDefault(c, 0) + 1);//getOrDefault,返回指定键映射到的值，如果此映射不包含该键的映射，则返回 defaultValue
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0;
        int len=Integer.MAX_VALUE;
        while (right < ss.length) {
            char c = ss[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.getOrDefault(c, 0) == need.getOrDefault(c, -1)) {
                    valid++;
                }
            }
            //开始收缩窗口的条件
            while (valid == need.size()) {
                //这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = ss[left];
                left++;
                if (need.containsKey(d)) {
                    if (window.getOrDefault(d, 0) == need.getOrDefault(d, -1)) {
                        valid--;
                    }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? " " : s.substring(start,  (start + len));
    }
}

