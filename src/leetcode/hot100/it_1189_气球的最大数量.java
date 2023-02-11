package leetcode.hot100;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * 示例 1：
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 * 输入：text = "loonbalxballpoon"
 * 输出：2**/

public class it_1189_气球的最大数量 {
    public static void main(String[] args) {
        String text="loonbalxballpoon";
        int res = new it_1189_气球的最大数量().maxNumberOfBalloons(text);
        System.out.println(res);
    }

    public int maxNumberOfBalloons(String text) {
        int x='a'-97,y='b'-97,z='n'-97,n='l'-97,m='o'-97;
        int[] count=new int[26];
        int len=text.length();
        int res=0;
        for (int i = 0; i < len; i++) {
            int temp=text.charAt(i)-97;
            count[temp]++;
        }
        while ((--count[x]>=0&&--count[y]>=0&&--count[z]>=0&&(count[n]-2>=0)&&count[m]-2>=0)){
            res++;
            count[n]-=2;
            count[m]-=2;
        }
        return res;
    }
}
