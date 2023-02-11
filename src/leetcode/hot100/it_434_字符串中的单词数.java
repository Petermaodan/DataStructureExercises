package leetcode.hot100;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */
public class it_434_字符串中的单词数 {
    public static void main(String[] args) {
        String s="Hello, my name is John";
        int res = new it_434_字符串中的单词数().countSegments(s);
        System.out.println(res);
    }
    public int countSegments(String s) {
        int len=s.length();
        int res=0;
        int i=0;
        while (i<len){
            if (s.charAt(i)==' '){
                i++;
                continue;
            }
            while (i<len&&s.charAt(i)!=' ')i++;
            res++;
        }
        return res;
    }
}
