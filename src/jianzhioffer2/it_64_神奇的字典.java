package jianzhioffer2;

/**
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
 *
 * 实现 MagicDictionary 类：
 *
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。

 */
public class it_64_神奇的字典 {

    class MagicDictionary {

        /** Initialize your data structure here. */
        public MagicDictionary() {
            root=new TrieNode();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                buildTree(s);
            }
        }

        public boolean search(String searchWord) {
            return dfs(searchWord,root,0,false);
        }
        TrieNode root;

        class TrieNode{
            TrieNode[] next=new TrieNode[26];
            boolean isEnd;
        }

        public void buildTree(String s){
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

        public boolean dfs(String s,TrieNode node,int pos,boolean modified){
            if (pos==s.length()){
                return modified&&node.isEnd;
            }
            int c=s.charAt(pos)-'a';
            if (node.next[c]!=null){
                if (dfs(s,node.next[c],pos+1,modified)){
                    return true;
                }
            }
            if (!modified){
                for (int i = 0; i < 26; i++) {
                    //i!=c非常关键，不然会出错
                    if (i!=c&&node.next[i]!=null){
                        if (dfs(s, node.next[i], pos+1, true)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
