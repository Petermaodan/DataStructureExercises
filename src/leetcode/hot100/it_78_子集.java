package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 *
 * 这种类型的题目，首先想到的时使用回溯法解决，回溯法框架
 * 定义一个backtrack(路径，选择列表）-》方法中路径是关键
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class it_78_子集 {
    public static void main(String[] args) {
        int [] nums={1,2,3};
        List<List<Integer>> res=new it_78_子集().subsets(nums);
        ListUtil.arrayTwo(res);
//        System.out.println(res);


    }
    List<Integer> t=new ArrayList<>();
    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0,nums);
        return res;
    }
    public void backtrack(int cur,int[] nums){
        //跳出递归
        if (cur==nums.length){
            //所有的回溯方法这里都是一样的，需要新建一个List对象，应为t是给回溯重复使用的
            res.add(new ArrayList<>(t));
            //添加完要return,不需要往下面走了，不然会超Array
            return;
        }
        t.add(nums[cur]);
        backtrack(cur+1,nums);
        //撤回操作
        t.remove(t.size()-1);
        //因为是子集，不需要选择每个元素，所以这里在递归进行一次选择
        backtrack(cur+1,nums);
    }
}
