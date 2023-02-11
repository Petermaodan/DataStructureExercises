package it_05_回溯;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 */
public class it_90_子集2 {


    public static void main(String[] args) {
        int [] nums={1,2,2};
        List<List<Integer>> res = new it_90_子集2().subsetsWithDup(nums);
        ListUtil.arrayTwo(res);

    }
    boolean[] used;
    List<Integer> temp;
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        temp=new ArrayList<>();
        res=new ArrayList<>();
        if (nums.length==0){
            res.add(temp);
            return res;
        }
        //排序，便于去重
        Arrays.sort(nums);
        used=new boolean[nums.length];
        backtrack(nums,0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        if (start>=nums.length){
            return;
        }
        for (int i = start; i <nums.length ; i++) {
            //去重判断,used[i-1],通过前一个判断是否还在同一树层
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            temp.add(nums[i]);
            used[i]=true;
            backtrack(nums,i+1);
            //撤回
            temp.remove(temp.size()-1);
            //标记返回上一树层
            used[i]=false;
        }
    }

//    private List<List<Integer>> ans;
//    private List<Integer> path;
//
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        ans = new ArrayList<>();
//        path = new ArrayList<>();
//        // 首先排序，让相同的两个元素排到一起去，便于去重
//        Arrays.sort(nums);
//        int n = nums.length;
//        // 使用 visited 数组来记录哪一个元素在当前路径中被使用了
//        boolean[] visited = new boolean[n];
//        // 开始回溯
//        backtrace(nums, 0, visited, n);
//        return ans;
//    }
//
//    private void backtrace(int[] nums, int start, boolean[] visited, int n) {
//        // 首先加入当前路径
//        ans.add(new ArrayList<>(path));
//        // 从 start 开始遍历每一个元素，尝试加入路径中
//        for (int i = start; i < n; ++i) {
//            // 如果当前元素和前一个元素相同，而且前一个元素没有被访问，说明前一个相同的元素在当前层已经被用过了
//            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
//            // 记录下来，用过了当前的元素
//            visited[i] = true;
//            path.add(nums[i]); // 放到路径中
//            backtrace(nums, i + 1, visited, n); // 向下一个递归
//            visited[i] = false; // 回溯
//            path.remove(path.size() - 1);
//        }
//    }


//    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
//    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
//    boolean[] used;
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        if (nums.length == 0){
//            result.add(path);
//            return result;
//        }
//        Arrays.sort(nums);
//        used = new boolean[nums.length];
//        subsetsWithDupHelper(nums, 0);
//        return result;
//    }
//
//    private void subsetsWithDupHelper(int[] nums, int startIndex){
//        result.add(new ArrayList<>(path));
//        if (startIndex >= nums.length){
//            return;
//        }
//        for (int i = startIndex; i < nums.length; i++){
//            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
//                continue;
//            }
//            path.add(nums[i]);
//            used[i] = true;
//            subsetsWithDupHelper(nums, i + 1);
//            path.removeLast();
//            used[i] = false;
//        }
//    }
}
