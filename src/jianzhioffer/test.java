package jianzhioffer;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2) -> o1-o2);
        for (int num : nums) {
            queue.add(num);
        }
        System.out.println(queue.poll());
    }
}
