package niuke;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 */
public class it_4_最小的K个数 {
    public static void main(String[] args) {
        int[] nums={4,5,1,6,2,7,3,8};
        ListUtil.arrayOne(new it_4_最小的K个数().GetLeastNumbers_Solution(nums,4));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> queue =new PriorityQueue<>(k,(o1, o2) ->o2-o1);
//        PriorityQueue<Integer> queue=new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
        int maxValue=Integer.MAX_VALUE;
        for (int num : input) {
            if (queue.size()!=k){
                queue.offer(num);
            }else if (queue.peek()>num){
                queue.poll();
                queue.offer(num);
            }
        }
        for (Integer integer : queue) {
            result.add(integer);
        }
        return  result;

    }


}
