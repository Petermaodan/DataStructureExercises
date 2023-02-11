package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class it_48_最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(new it_48_最长不含重复字符的子字符串().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> windows=new HashMap<>();
        int right=0,left=0;
        int res=0;
        while (right<s.length()){
            char c=s.charAt(right);
            right++;
            windows.put(c,windows.getOrDefault(c,0)+1);
            //当重复元素存在时，就收缩窗口
            while (windows.getOrDefault(c,0)>1){
                char d=s.charAt(left);
                left++;
                //更新窗口
                windows.put(d,windows.getOrDefault(d,0)-1);
            }
            res=Math.max(res,right-left);
        }
        return res;
    }
}
