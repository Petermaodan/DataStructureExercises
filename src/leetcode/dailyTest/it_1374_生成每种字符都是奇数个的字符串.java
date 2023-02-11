package leetcode.dailyTest;

/**
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 *
 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 *

 */
public class it_1374_生成每种字符都是奇数个的字符串 {
    public static void main(String[] args) {
        String res = new it_1374_生成每种字符都是奇数个的字符串().generateTheString(4);
        System.out.println(res);
    }
    public String generateTheString(int n) {
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i <n; i++) {
            builder.append('a');
        }
        if (n%2==0){
            builder.deleteCharAt(0);
            builder.append('b');
        }
        return builder.toString();
    }
}
