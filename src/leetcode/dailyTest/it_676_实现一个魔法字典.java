package leetcode.dailyTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 *
 * 实现 MagicDictionary 类：
 *
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 */
public class it_676_实现一个魔法字典 {
    public static void main(String[] args) {

    }
    class MagicDictionary {

        Map<Integer, List<String>> map=new HashMap<>();
        public MagicDictionary() {
            map=new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                int key=s.length();
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(s);
                map.put(key,list);
            }
        }

        public boolean search(String searchWord) {
            int len=searchWord.length();
            if (map.containsKey(len)){
                List<String> stringList = map.get(len);
                for (String s : stringList) {
                    if (checkString(searchWord,s)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean checkString(String s1, String s2) {
            int count=0;
            int len=s1.length();
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i)==s2.charAt(i)){
                    continue;
                }
                count++;
                if (count>1){
                    break;
                }
            }
            return count==1;
        }
    }
}
