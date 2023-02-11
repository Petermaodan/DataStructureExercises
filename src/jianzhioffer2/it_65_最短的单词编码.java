package jianzhioffer2;

import java.util.HashSet;
import java.util.Set;

/**
 * 找后缀一样的单词，只保留最长的那个，然后拼到一块，中间用#隔开
 */
public class it_65_最短的单词编码 {
    public static void main(String[] args) {
        String[] words = {"t"};
        int res = new it_65_最短的单词编码().minimumLengthEncoding(words);
        System.out.println(res);
    }
    public int minimumLengthEncoding(String[] words) {
        int res=0;
        Set<String> set=new HashSet<>();
        for (String word : words) {
            addTrie(word);
        }
        for (String word : words) {
            if (set.contains(word)){
                continue;
            }
            set.add(word);
            if (!queryTrie(word)){
                res+=word.length()+1;
            }
        }
        return res;
    }

    class TrieNode{
        TrieNode[] next=new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root=new TrieNode();

    public void addTrie(String s){
        TrieNode cur=root;
        for (int i = s.length()-1; i >=0 ; i--) {
            int temp=s.charAt(i)-'a';
            if (cur.next[temp]==null){
                cur.next[temp]=new TrieNode();
            }
            cur=cur.next[temp];
        }
        cur.isEnd=true;
    }

    public boolean queryTrie(String s){
        TrieNode cur=root;
        for (int i = s.length()-1; i >=0 ; i--) {
            int temp=s.charAt(i)-'a';
            if (cur.next[temp]==null){
                return false;
            }
            cur=cur.next[temp];
        }
        for (int i = 0; i < 26; i++) {
            if (cur.next[i]!=null){
                return true;
            }
        }
        return false;
    }
}
