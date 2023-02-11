package leetcode.dailyTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 */
public class it_648_单词替换_字典树 {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        String s = new it_648_单词替换_字典树().replaceWords2(dictionary, sentence);
        System.out.println(s);


    }

    public String replaceWords2(List<String> dictionary, String sentence) {
        for (String str : dictionary) {
            add(str);
        }
        StringBuilder sb = new StringBuilder();
        for (String str : sentence.split(" ")) sb.append(query(str)).append(" ");
        return sb.substring(0, sb.length() - 1);
    }

    //字典树
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    void add(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (cur.next[c] == null) {
                cur.next[c] = new TrieNode();
            }
            cur = cur.next[c];
        }
        cur.isEnd = true;
    }

    String query(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (cur.next[c] == null) {
                break;
            }
            if (cur.next[c].isEnd) {
                return s.substring(0, i + 1);
            }
            cur = cur.next[c];
        }
        return s;
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, (o1, o2) -> o1.length() - o2.length());
        String[] ss = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            ss[i] = checkString(dictionary, ss[i]);
            builder.append(ss[i]);
            if (i != ss.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private String checkString(List<String> dictionary, String s) {
        out:
        for (String s1 : dictionary) {
            int i = 0, j = 0;
            in:
            while (i < s1.length() && j < s.length()) {
                if (s1.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                } else {
                    break in;
                }
            }
            if (i == s1.length()) {
                return s1;
            }
        }
        return s;
    }
}
