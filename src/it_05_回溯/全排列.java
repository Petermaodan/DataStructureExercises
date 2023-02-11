package it_05_回溯;

import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        全排列 test1=new 全排列();
        int[] nums = {1, 2, 3};
//        List<List<Integer>> res=new LinkedList<>();
        List<List<Integer>> result= test1.permute(nums);
        System.out.println(result);
    }

    List<List<Integer>> res = new LinkedList<>();

    private  List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, nums);
        return res;
    }

    private  void backtrack(LinkedList<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
//            res.add(new LinkedList<>(track));
            res.add(new LinkedList<>(track));
            return;

        }
        for (int i = 0; i <nums.length ; i++) {
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(track,nums);
            track.removeLast();
        }
    }
}
