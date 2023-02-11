package it_05_回溯;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 输入：digits = "23"
 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class it_17_电话号码的字母组合 {
    public static void main(String[] args) {
        List<String> res=new leetcode.hot100.it_17_电话号码的字母组合().letterCombinations("45");
        for (String re : res) {
            System.out.print(re+"--");
        }
    }


    List<String> res=new ArrayList<>();
    StringBuilder track=new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0)return res;

        Map<Character,String> phoneMap=new HashMap<Character, String>(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrack(digits,res,track,phoneMap,0);
        return res;


    }

    private void backtrack(String digits, List<String> res, StringBuilder track, Map<Character, String> phoneMap, int idx) {
        if (track.length()==digits.length()){
            res.add(new StringBuilder(track).toString());
            return;
        }
        char c = digits.charAt(idx);
        String s = phoneMap.get(c);
        for (int i = 0; i < s.length(); i++) {
            track.append(s.charAt(i));
            backtrack(digits,res,track,phoneMap,idx+1);
            track.deleteCharAt(track.length()-1);
        }
    }
}
