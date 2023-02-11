package jianzhioffer2;

/**
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 示例 1：
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 */
public class it_20_回文子字符串的个数 {
    public static void main(String[] args) {
        String s = "aaa";
        int res = new it_20_回文子字符串的个数().countSubstrings(s);
        System.out.println(res);
    }
    public int countSubstrings(String s) {
        int res=0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < 2*chars.length-1; i++) {
            int left=i/2,right=left+i%2;
            while (left>=0&&right<=chars.length-1&&isSub(chars,left,right)){
                left--;
                right++;
                res++;
            }
        }
        return res;
    }

    private boolean isSub(char[] chars, int left, int right) {
        if (chars[left]==chars[right]){
            return true;
        }
        return false;
    }
}
