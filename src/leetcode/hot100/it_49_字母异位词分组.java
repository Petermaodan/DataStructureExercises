package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 *
 * 可以使用相同点作为一组字母异位词的标志，使用哈希表存储每一组字母异位词，哈希表的键为一组字母异位词的标志，哈希表的值为一组字母异位词列表。
 *
 * 由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键
 */
public class it_49_字母异位词分组 {
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","bat","ate","nat"};
        List list=new it_49_字母异位词分组().groupAnagrams(strs);
        ListUtil.arrayTwoString(list);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] chars=str.toCharArray();
            //排序
            Arrays.sort(chars);
            //排序之后的作为键
            String key=new String(chars);
            //将具有相同键的列表放到一个list中
            List<String> list=map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            //更新map
            map.put(key,list);
        }
        //map.value作为新的列表
        return new ArrayList<>(map.values());
    }
}
