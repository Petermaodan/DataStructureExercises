package leetcode.hot100;

/**
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *  
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *

 */
public class it_28_实现strStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        int res = new it_28_实现strStr().strStr(haystack, needle);
        System.out.println(res);
    }

    public int strStr(String haystack, String needle) {
        int len=needle.length();
        if (len==0)return 0;
        int left=0,right=len;
        while (right<=haystack.length()){
            String temp=haystack.substring(left,right);
            if (temp.equals(needle))return left;
            left++;
            right++;
        }
        return -1;
    }
}
