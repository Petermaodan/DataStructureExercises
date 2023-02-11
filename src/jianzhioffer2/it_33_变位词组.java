package jianzhioffer2;

import BaseUtil.ListUtil;

import java.util.*;

/**
 * 给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
 * 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class it_33_变位词组 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new it_33_变位词组().groupAnagrams(strs);
        ListUtil.arrayTwoString(lists);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            System.out.println(chars.toString());
            String key = new String(chars);
            System.out.println(key);
            ArrayList<String> list= (ArrayList<String>) map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
