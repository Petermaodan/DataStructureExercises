package leetcode.hot100;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *  
 *这种类型的题目就是直接套用前缀树的模板就可以了
 */
public class it_211_添加与搜索单词_数据结构设计 {
    private Trie root;

    public it_211_添加与搜索单词_数据结构设计(){
        root=new Trie();
    }
    public void addWord(String word){
        root.insert(word);
    }


    public boolean search(String s){
        return dfs(s,0,root);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index==word.length())return node.isEnd();
        char ch=word.charAt(index);
        //判断是否为字母
        if (Character.isLetter(ch)){
            int childIndex=ch-'a';
            //获得子孩
            Trie child=node.getChildren()[childIndex];
            if (child!=null&&dfs(word,index+1,child)){
                return true;
            }
        }else {
            //弱如果是点，那么就遍历整层的字典树
            for (int i = 0; i < 26; i++) {
                Trie child=node.getChildren()[i];
                if (child!=null&&dfs(word,index+1,child)){
                    return true;
                }
            }
        }
        return false;
    }

    //创建字典树的类
    class Trie{
        private Trie[] children;
        private boolean isEnd;

        public Trie(){
            children=new Trie[26];
            isEnd=false;
        }

        //插入操作
        public void insert(String word){
            Trie node=this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index=ch-'a';
                if (node.children[index]==null)node.children[index]=new Trie();
                //指针移到下一个节点
                node=node.children[index];
            }
            node.isEnd=true;
        }

        public Trie[] getChildren() {
            return children;
        }
        public boolean isEnd(){
            return isEnd;
        }
    }

}
