package it_05_回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class it_78_子集 {
    public static void main(String[] args) {
        int[] nums={1,2,3};

        List<List<Integer>> res=new it_78_子集().subsets(nums);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }

    List<List<Integer>> res=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        tarckBack(nums,0);
        return res;
    }

    private void tarckBack(int[] nums, int i) {
        if (i==nums.length){
            //注意，这里要重新创建一个列表
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        tarckBack(nums,i+1);
        //撤回操作
        temp.remove(temp.size()-1);
        tarckBack(nums,i+1);
    }
}
