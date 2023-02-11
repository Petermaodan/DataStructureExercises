package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class it_77_组合 {
    public static void main(String[] args) {
        List<List<Integer>> res = new it_77_组合().combine(4, 2);
        ListUtil.arrayTwo(res);
    }

    List<List<Integer>> res=new ArrayList<>();
    List<Integer> track=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,0);
        return res;
    }

    private void backtrack(int n, int k, int idx) {
        if (track.size()==k){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = idx; i < n; i++) {
            track.add(i+1);
            backtrack(n,k,i+1);
            track.remove(track.size()-1);
        }
    }
}
