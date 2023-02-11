package jianzhioffer;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 首先比较容易想到回溯，试试看
 */
public class it_38_字符串的排列 {
    public static void main(String[] args) {
        String s="abc";
        String[] res = new it_38_字符串的排列().permutation(s);
        ListUtil.arrayOneString(Arrays.asList(res));
    }

    List<String> res=new ArrayList<>();
    StringBuilder track=new StringBuilder();
    public String[] permutation(String s) {
        if (s==null)return null;
        char[] chars=s.toCharArray();
        Arrays.sort(chars);
        boolean[] used=new boolean[s.length()];
        backtrack(chars,0,used);

        String[] ans=new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i]=res.get(i);
        }
        return ans;

    }

    private void backtrack(char[] chars, int idx, boolean[] used) {
        if (idx==chars.length){
            res.add(new StringBuilder(track).toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]||(i>0&&chars[i]==chars[i-1]&&!used[i-1])){
                continue;
            }
            track.append(chars[i]);
            used[i]=true;
            backtrack(chars,idx+1,used);
            //回溯
            track.deleteCharAt(track.length()-1);
            used[i]=false;
        }
    }
}
