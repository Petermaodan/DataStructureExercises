package jianzhioffer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 */
public class it_16_不含重复字符的最长子字符串 {
    public static void main(String[] args) {
        String s = "bbbbbb";
        int res = new it_16_不含重复字符的最长子字符串().lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            window.put(r, window.getOrDefault(r, 0) + 1);
            while (window.getOrDefault(r, 0) > 1) {
                char l = s.charAt(left);
                window.put(l, window.getOrDefault(l, 0) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
