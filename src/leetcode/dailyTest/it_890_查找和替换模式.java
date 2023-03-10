package leetcode.dailyTest;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 *
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 *
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 *
 * 返回 words 中与给定模式匹配的单词列表。
 *
 * 你可以按任何顺序返回答案。
 * 示例：
 *
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 */
public class it_890_查找和替换模式 {
    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> list = new it_890_查找和替换模式().findAndReplacePattern(words, pattern);
        ListUtil.arrayOneString(list);
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res=new ArrayList<>();
        //使用数组代替哈希表
        int[] map=new int[26],visited=new int[26];
        for (String word : words) {
            Arrays.fill(map,-1);
            Arrays.fill(visited,0);
            boolean ok=true;
            for (int i = 0; i < pattern.length()&&ok; i++) {
                int c1=pattern.charAt(i)-'a',c2=word.charAt(i)-'a';
                if (map[c1]==-1&&visited[c2]==0){
                    map[c1]=c2;
                    visited[c2]=1;
                }else if (map[c1]!=c2){
                    ok=false;
                }
            }
            if (ok){
                res.add(word);
            }
        }
        return res;
    }
}
