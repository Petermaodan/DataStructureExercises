package jianzhioffer2;

import java.util.HashMap;
import java.util.Map;

public class it_66_单词之和 {

    class MapSum {

        /** Initialize your data structure here. */
        public MapSum() {
            this.root=new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode cur=root;
            for (int i = 0; i < key.length(); i++) {
                int idx=key.charAt(i)-'a';
                if (cur.next[idx]==null){
                    cur.next[idx]=new TrieNode();
                }
                cur=cur.next[idx];
            }
            cur.value=val;
        }

        public int sum(String prefix) {
            TrieNode cur=root;
            for (int i = 0; i < prefix.length(); i++) {
                int idx=prefix.charAt(i)-'a';
                if (cur.next[idx]==null){
                    return 0;
                }
                cur=cur.next[idx];
            }
            return dfs(cur);
        }

        public int dfs(TrieNode cur) {
            if (cur==null){
                return 0;
            }
            int childSum=0;
            for (int i = 0; i < 26; i++) {
                if (cur.next[i]!=null){
                    childSum+=dfs(cur.next[i]);
                }
            }
            return cur.value+childSum;
        }

        TrieNode root;

        class TrieNode{
            TrieNode[] next=new TrieNode[26];
            int value;
        }
    }


}
