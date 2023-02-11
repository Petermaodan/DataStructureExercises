package jianzhioffer2;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/Ygoe9J
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class it_81_允许重复选择元素的组合 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = new it_81_允许重复选择元素的组合().combinationSum(candidates, target);
        ListUtil.arrayTwo(lists);
    }


    List<List<Integer>> res=new ArrayList<>();
    List<Integer> track=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,target,0,0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int sum,int idx) {
        if (sum==target){
            res.add(new ArrayList<>(track));
            return;
        }
        if (sum>target)return;
        for (int i = idx; i < candidates.length; i++) {
            int temp=candidates[i];
            sum+=temp;
            track.add(temp);
            //进入下一层
            backtrack(candidates, target, sum,i);
            //回溯
            track.remove(track.size()-1);
            sum-=temp;
        }
    }
}
