package leetcode.hot100;

/**
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 *
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，请你将 s​​ 截断 ​，​​​使截断后的句子仅含 前 k​​​​​​ 个单词。返回 截断 s​​​​​​ 后得到的句子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Hello how are you Contestant", k = 4
 * 输出："Hello how are you"
 * 解释：
 * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
 * 前 4 个单词为 ["Hello", "how", "are", "you"]
 * 因此，应当返回 "Hello how are you"
 *
 * 思路，其实不需要考虑边界条件，只需要考虑空格就行，k=4时，有3个空格
 */
public class it_1816_截断句子 {
    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        String res = new it_1816_截断句子().truncateSentence(s, k);
        System.out.println(res);
    }
    public String truncateSentence(String s, int k) {
        StringBuilder builder=new StringBuilder();
        int idx=0;
        int count=0;
        while (idx<s.length()&&count<k){
            char temp = s.charAt(idx);
            if (temp==' ')count++;
            if (count<k)builder.append(temp);
            idx++;
        }
        return builder.toString();
    }
}
