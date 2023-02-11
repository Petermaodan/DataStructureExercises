package leetcode.hot100;

/**
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
 *
 * 补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词 。
 *
 * 在匹配 licensePlate 中的字母时：
 *
 * 忽略 licensePlate 中的 数字和空格 。
 * 不区分大小写。
 * 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 *
 * 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 那个。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 解释：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
 * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * "steps" 包含 "t"、"p" 和两个 "s"。
 * "stripe" 缺一个 "s"。
 * "stepple" 缺一个 "s"。
 * 因此，"steps" 是唯一一个包含所有字母的单词，也是本例的答案。
 */
public class it_748_最短补全词 {
    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        String res = new it_748_最短补全词().shortestCompletingWord(licensePlate, words);
        System.out.println(res);
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] countPlate=new int[26];
        int len=licensePlate.length();
        int isMin=Integer.MAX_VALUE;
        String res="";
        for (int i = 0; i < len; i++) {
            char c = Character.toLowerCase(licensePlate.charAt(i));
            int temp=c-'a';
            if (temp>=0&&temp<=25){
                countPlate[temp]++;
            }
        }
        for (String word : words) {
            int wordLen=word.length();
            if (wordLen<isMin){
                boolean flag=check(countPlate,word);
                if (flag){
                    res=word;
                    isMin=wordLen;
                }
            }
        }
        return res;
    }

    private boolean check(int[] countPlate, String word) {
        int len=word.length();
        int[] newCount=new int[26];
        for (int i = 0; i < len; i++) {
            int temp=word.charAt(i)-'a';
            newCount[temp]++;
        }
        for (int i = 0; i < 26; i++) {
            if (newCount[i]-countPlate[i]<0)return false;
        }
        return true;
    }
}
