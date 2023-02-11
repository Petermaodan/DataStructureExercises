package it_05_回溯;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]

 */
public class it_22_括号生成 {
    public static void main(String[] args) {
        int n=3;
        List<String> res = new it_22_括号生成().generateParenthesis(n);
        ListUtil.arrayOneString(res);
    }


    List<String> res=new ArrayList<>();
    StringBuilder track=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        if (n==0)return res;
        backtrack(n,0,0);
        return res;

    }

    private void backtrack(int n, int leftCount, int rightCount) {
        if (track.length()==n*2){
            res.add(new StringBuilder(track).toString());
            //跳出递归
            return;
        }
        if (leftCount<n){
            track.append('(');
            backtrack(n,leftCount+1,rightCount);
            track.deleteCharAt(track.length()-1);
        }
        //右边的括号会被左边所限制
        if (leftCount>rightCount){
            track.append(')');
            backtrack(n,leftCount,rightCount+1);
            track.deleteCharAt(track.length()-1);
        }
    }
}
