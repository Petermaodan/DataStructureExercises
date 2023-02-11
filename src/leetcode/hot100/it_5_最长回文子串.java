package leetcode.hot100;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * 核心思想，从中间开始向两边扩散判断回文串
 */
public class it_5_最长回文子串 {
    public static void main(String[] args) {
        String s="babad";
        String res=new it_5_最长回文子串().longestPalindrome(s);
        System.out.println(res);

    }
//传入两个参数l，r->可以同时处理回文串长度为奇数和偶数的情况
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //长度为奇数的情况
            String s1=palindrome(s,i,i);
            //长度为偶数的情况
            String s2=palindrome(s,i,i+1);
            res=res.length()>s1.length()?res:s1;
            res=res.length()>s2.length()?res:s2;
        }
        return res;
    }
    public String palindrome(String s,int l,int r){

        //防止索引出界
        while (l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        //返回以l和r为中心的最长回文子串
        return s.substring(l+1,r);
    }
}
