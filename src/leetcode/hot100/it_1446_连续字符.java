package leetcode.hot100;

/**
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串的能量。
 * 示例 1：
 *
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 */
public class it_1446_连续字符 {
    public static void main(String[] args) {
        String s="triplepillooooow";
        int res = new it_1446_连续字符().maxPower(s);
        System.out.println(res);
    }
    public int maxPower(String s) {
        int len=s.length();
        if(len==0)return 0;
        int left=0,right=0;
        int maxRes=0;
        while (right<len){
            while (right<len&&s.charAt(left)==s.charAt(right)){
                right++;
            }
            maxRes=Math.max(maxRes,right-left);
            left=right;
        }
        return maxRes;
    }
}
