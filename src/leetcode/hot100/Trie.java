package leetcode.hot100;

/**
 * 发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * 插入字符，节点存在时，指针移动到子节点处理下一个字符，节点不存在时，创建新的节点
 * 查找前缀，节点存在时，指针移动到子节点，节点不存在返回空指针
 *
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;//结尾字符

    /** Initialize your data structure here. */
    public Trie() {
        children=new Trie[26];
        isEnd=false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node=this;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            int index=ch-'a';
            if (node.children[index]==null){
                node.children[index]=new Trie();
            }
            //指针移动到子节点
            node=node.children[index];
        }
        node.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node=searchPrefix(word);
        return node!=null&&node.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }

    public Trie searchPrefix(String prefix){
        Trie node=this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch=prefix.charAt(i);
            int index=ch-'a';
            if (node.children[index]==null){
                return null;
            }
            //若存在，指向下一个节点
            node=node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {

    }
}

