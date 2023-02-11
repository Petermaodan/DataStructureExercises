package leetcode.hot100;


import java.util.HashMap;
import java.util.Map;

public class it_3_无重复字符的最长子串 {
    public static void main(String[] args) {
        String s="abcabcbb";
        int res=new it_3_无重复字符的最长子串().lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window=new HashMap<>();
        char[] t=s.toCharArray();
        int left=0,right=0;
        int res=0;
        while (right<s.length()){
            char c=t[right];
            //这里，当right指向0的时候，right已经变成1了
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            //当重复元素存在时，就收缩窗口
            while (window.getOrDefault(c,0)>1){
                char d=t[left];
                left++;
                //更新窗口
                window.put(d,window.getOrDefault(d,0)-1);
            }
            //这里，当right指向0的时候，right已经变成1了
            res=Math.max(res,right-left);
        }
        return res;
    }
}
