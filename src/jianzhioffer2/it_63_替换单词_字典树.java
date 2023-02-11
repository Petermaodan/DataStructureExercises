package jianzhioffer2;

import java.util.List;

public class it_63_替换单词_字典树 {


    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            addNode(s);
        }
        StringBuilder builder=new StringBuilder();
        for (String s : sentence.split(" ")) {
            builder.append(query(s)).append(" ");
        }
        return builder.toString().substring(0,builder.length()-1);

    }

    class TrieNode{
        TrieNode[] next=new TrieNode[26];
        boolean isEnd;


    }
    TrieNode root=new TrieNode();

    private void addNode(String s){
        TrieNode cur=root;
        for (int i = 0; i < s.length(); i++) {
            int c=s.charAt(i)-'a';
            if (cur.next[c]==null){
                cur.next[c]=new TrieNode();
            }
            cur=cur.next[c];
        }
        cur.isEnd=true;
    }

    private String query(String s){
        TrieNode cur=root;
        for (int i = 0; i < s.length(); i++) {
            int c=s.charAt(i)-'a';
            if (cur.next[c]==null){
                break;
            }
            if (cur.next[c].isEnd){
                return s.substring(0,i+1);
            }
            cur=cur.next[c];
        }
        return s;
    }
}
