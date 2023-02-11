package leetcode.hot100;

/**
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 * 根据题意进行模拟即可，利用每个 words[i]words[i] 只有小写字母，且只需要区分两字符是否有字母重复。
 *
 * 我们可以使用一个 int 来代指某个 word[i]word[i]：低 2626 来代指字母 a-z 是否出现过。
 *
 * 然后对每个「字符对」所对应的两个 int 值执行 & 操作（若两字符无重复字符，则结果为 00），并得出最终答案。
 *
 * |	如果相对应位都是 0，则结果为 0，否则为 1
 */
public class it_318_最大单词长度乘积 {
    public static void main(String[] args) {
        String[] S={"abcw","baz","foo","bar","xtfn","abcdef"};
        int res = new it_318_最大单词长度乘积().maxProduct(S);
        System.out.println(res);
    }

    public int maxProduct(String[] words) {
        int len=words.length;
        int maxRes=Integer.MIN_VALUE;
        int idx=0;
        int[] masks=new int[len];

        for (String word : words) {
            int t=0;
            for (int i = 0; i < word.length(); i++) {
                int temp=word.charAt(i)-'a';
                //通过26位记录对应的单词
                t|=(1<<temp);
            }
            masks[idx++]=t;
        }

        //通过mask判断是否有重复单词
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if ((masks[i]&masks[j])==0){
                    maxRes=Math.max(maxRes,words[i].length()*words[j].length());
                }
            }
        }
        return maxRes;

    }
}
